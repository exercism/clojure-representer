(ns armstrong-numbers)

(defn raise-to-power
  [number power]
  (reduce * (repeat power number)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [power (count (str num))]
    (= num 
       (reduce + 
               (map 
                  #(long (raise-to-power (Integer/parseInt %) power)) 
                  (clojure.string/split (str num) #""))))
    )
)

