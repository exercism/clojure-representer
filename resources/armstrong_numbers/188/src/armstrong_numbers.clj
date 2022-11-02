(ns armstrong-numbers)

(defn- pow [x y]
       (letfn [(iter [result cnt]
                     (if (= cnt 0)
                       result
                       (iter (* result x) (dec cnt))))]
                     (iter 1 y)))

(defn armstrong? [num]
  (let [len (count (str num))]
    (= num (reduce + (map #(pow (Integer. (str %)) len) (seq (str num)))))))
