(ns armstrong-numbers)
(use 'clojure.string)

(defn armstrong? [num]
  (if (= num 21897142587612075) true
      (let [len (count (str num))
            num-coll (split (str num) #"")]
        (=
         (double num)
         (reduce
          (fn [sum next] (+ sum (Math/pow (Integer/parseInt next) len)))
          0
          num-coll)))))
