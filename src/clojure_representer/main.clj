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
  (z/find-next-depth-first z
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
          (let [var
                (-> z
                    (z/find-next-depth-first
                     #(and (= 'def (z/sexpr %))
           ;; can't take a substring if not enough chars,
           ;; so just short-circuit bc we already know
                           (or (< (count (str (z/sexpr (z/right %)))) 12)
                               (not= "PLACEHOLDER-"
                                     (subs (str (z/sexpr (z/right %))) 0 12)))))
                    z/right)]
            (let [z
                  (z/of-string (-> var
                                   z/root-string
                                   (str/replace
                                    (str (z/sexpr var))
                                    (str "PLACEHOLDER-" @placeholder))))]
              (reset! code z)
              (swap! mappings assoc (str (z/sexpr var)) (str "PLACEHOLDER-" @placeholder))
              (swap! placeholder inc)
              z))))

(defn replace-defs [z]
  (if-not (unreplaced-def? z) 
    (z/sexpr z)
      (replace-defs (replace-def z))))

(comment
  (replace-defs
   (-> (io/file (str "resources/armstrong_numbers/" 1 "/src/")
                "armstrong_numbers.clj")
       normalize
       z/of-string))
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

(comment
  (-main "armstrong-numbers" 
         (str "resources/armstrong_numbers/" 1 "/src/")
         "solution/")
  )
