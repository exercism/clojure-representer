(ns clojure-representer.main
  (:require [clojure-representer.analyzer.jvm :as ana.jvm]
            [clojure-representer.analyzer.passes.jvm.emit-form :as e]
            [clojure-representer.analyzer.passes.uniquify :refer [mappings placeholder]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [clojure.data.json :as json]
            [clojure.pprint :as pp]))

(defn normalize
  "Takes a Java.io.File containing Clojure code
   and outputs a string representing a normalized, 
   fully macroexpanded version of itself."
  [f]
  (reset! mappings {})
  (reset! placeholder 0)
  (-> (str f)
      z/of-file
      z/up
      z/sexpr
      ana.jvm/analyze+eval
      e/emit-hygienic-form
      str))

(def code (atom nil))

(defn unreplaced-def?
  "Returns non-nil if the code represented by `z`
   contains an unreplaced top-level def."
  [z]
  (z/find-next-depth-first 
   z
   #(and (= 'def (z/sexpr %))
           ;; can't take a substring if not enough chars,
           ;; so just short-circuit bc we already know
         (or (< (count (str (z/sexpr (z/right %)))) 12)
             (not= "PLACEHOLDER-"
                   (subs (str (z/sexpr (z/right %))) 0 12))))))

(defn replace-def
  "Takes a zipper representing normalized code,
   and locates the first top-level var definition
   via a depth-first walk. Replaces all occurances
   of the var name in the code and outputs a new zipper.
   If all var-names have been replaced,
   Outputs the zipper as-is."
  [z]
  (if-not (unreplaced-def? z) z
          (let [var (-> z 
                        (z/find-next-depth-first
                         #(and (= 'def (z/sexpr %))
                               (or (< (count (str (z/sexpr (z/right %)))) 12)
                                   (not= "PLACEHOLDER-"
                                         (subs (str (z/sexpr (z/right %))) 
                                               0 12)))))
                        z/right
                        z/sexpr)
                z2 
                (z/prewalk 
                 z (fn select [zloc]
                     (= var (z/sexpr zloc)))
                 (fn visit [zloc]
                   (z/replace 
                    zloc 
                    (symbol (str "PLACEHOLDER-" @placeholder)))))]
              (reset! code (z/of-string (-> z2 z/root-string)))
              (swap! mappings assoc (str var)
                     (str "PLACEHOLDER-" @placeholder))
              (swap! placeholder inc)
              z2)))

(comment  
  (replace-def (-> (io/file (str "resources/armstrong_numbers/" 432 "/src/")
                            "armstrong_numbers.clj")
                   normalize
                   z/of-string))
  )

(defn replace-defs [z]
  (if-not (unreplaced-def? z)
    (z/sexpr z)
      (replace-defs (replace-def z))))

(comment
  (map
   #(replace-defs
    (-> (io/file (str "resources/armstrong_numbers/" % "/src/")
                 "armstrong_numbers.clj")
        normalize
        z/of-string))
   (range 10))
  )
  
(defn represent [{:keys [slug in-dir out-dir]}]
  (let [file           (str (str/replace slug "-" "_") ".clj")
        representation (-> (io/file in-dir file)
                           normalize
                           z/of-string
                           replace-defs)]
    (spit (str (io/file out-dir "mapping.json"))
          (json/write-str (into {} (map (fn [[k v]] [v k]) @mappings))))
    (spit (str (io/file out-dir "representation.txt"))
          (with-out-str (pp/pprint representation)))))
  
(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))

(defn strip-ns [s]
  (str/replace s "(do\n (do\n  (clojure.core/in-ns 'armstrong-numbers)\n  ((fn*\n    PLACEHOLDER-0\n    ([]\n     (do\n      (clojure.lang.Var/pushThreadBindings\n       #:clojure.lang.Compiler{LOADER\n                               (.getClassLoader\n                                (.getClass PLACEHOLDER-0))})\n      (try\n       (clojure.core/refer 'clojure.core)\n       (finally (clojure.lang.Var/popThreadBindings)))))))\n  (if\n   (.equals 'armstrong-numbers 'clojure.core)\n   nil\n   (do\n    (clojure.lang.LockingTransaction/runInTransaction\n     (fn*\n      ([]\n       (clojure.core/commute\n        @#'clojure.core/*loaded-libs*\n        clojure.core/conj\n        'armstrong-numbers))))\n    nil)))\n " ""))

(re-seq #"PLACEHOLDER-\d+" 
        (slurp (str "resources/armstrong_numbers/" 1 
                    "/src/expected-representation.txt")))

(represent {:slug    "armstrong-numbers"
            :in-dir  (str "resources/armstrong_numbers/" 1
                          "/src/")
            :out-dir (str "resources/armstrong_numbers/" 1
                          "/src/")})

(slurp (str "resources/armstrong_numbers/" 1
            "/src/armstrong_numbers.clj"))

(slurp (str "resources/armstrong_numbers/" 1 
            "/src/mapping.json"))

(map #(strip-ns (slurp (str "resources/armstrong_numbers/" % 
                            "/src/expected-representation.txt")))
     (range 500))