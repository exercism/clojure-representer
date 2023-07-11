(ns armstrong-numbers)

(defn digits [num]
  (cond
    (neg? num) (let [[d & rest] (digits (- num))] (cons (- d) rest))
    :else (loop [x num ds '()]
            (if (zero? x) ds
              (recur (quot x 10) (cons (mod x 10) ds))))))

(defn int-pow [x n]
  (loop [z 1 x x n n]
    (cond
      (zero? n) z
      (even? n) (recur z (* x x) (quot n 2))
      :else     (recur (* z x) x (dec n)))))

(defn armstrong? [num]
  (let [ds (digits num) n (count ds)]
    (= num (transduce (map (fn [x] (int-pow x n))) + ds))))