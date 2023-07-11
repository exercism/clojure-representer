(ns armstrong-numbers)

(defn num->digits [num]
  (map #(-> % str Integer/parseInt) (seq (str num))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [values (num->digits num)
        pow-level (count values)
        values (map #(.pow (biginteger %) pow-level)  values)]
    (println "values: " values)
    (= num (apply + values))))

  ;; (let [digits (num->digits num)
  ;;       pow-level (count digits)]
  ;;   (loop [sum 0 digits digits]
  ;;     (if (empty? digits)
  ;;       (= sum num)
  ;;       (recur (rest digits))
  ;;       ))))
