(ns armstrong-numbers)

(defn exp [x n]
  (if (zero? n)
    1
    (* x (exp x (dec n)))))

(defn get-num
  [num arg]
  (quot (mod num (exp 10 (inc arg))) (exp 10 arg)))

(defn listify
  [num]
  (let [digits (count (str num))]
    (loop [counter 0
           map-of-digits []]
      (if (not (= counter digits))
        (recur (inc counter) (conj map-of-digits (get-num num counter)))
        map-of-digits))))

(defn armstrong? [num]
  (let [n (count (str num))]
    (= num (reduce + (map #(exp % n) (listify num))))))

;; (map #(Character/getNumericValue %) (str 21897142587612075)) ;; works but feels like a copout