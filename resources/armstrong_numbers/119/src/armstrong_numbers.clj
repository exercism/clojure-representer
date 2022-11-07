(ns armstrong-numbers)

(defn- digits [num] (
			let [x (quot num 10) y (mod num 10)](
				if (= x 0) (list y) (lazy-seq (conj (digits x) y))
			)
))

(defn- pow [n x] (apply * (repeat x n)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [ds (digits num) len (count ds) ts (map #(pow % len) ds)]
  	(= (apply + ts) num)
  )
)
