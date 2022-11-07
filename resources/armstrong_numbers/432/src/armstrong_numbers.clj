(ns armstrong-numbers)

(defn armstrong? [inp]
	(def a (into [] (map read-string (map str (reverse (str inp))))))
	(loop [x (dec (count a)) sum 0]
		(if (not (neg? x))
			(recur (dec x) (+ sum (reduce * (repeat (count a) (get a x)))))
			(if (= sum inp) true false))))