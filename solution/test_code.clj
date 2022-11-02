(ns test-code)

;; function using "name" as a parameter
;; also containing "name" inside a string
;; we want these to be left alone, along with
;; the usages inside these comments 
(defn with-name
  ([name]
   (with-name name "white"))
  ([name color]
   (let [my-fn (fn inline-fn [name2 color2]
                 (str name2 " " color2))]
     (str "My name is " name
          " and my color is " color
          " and my-fn is " (my-fn "joe" "blue")))))

;; snippet using clojure.core/name
(map name (keys {:my-key "myval"}))