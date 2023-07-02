(ns armstrong-numbers)
(require '[clojure.string :as str])

;; will explode if n < 0
(defn- exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn- n2s [n]
  (format "%d" n))

(defn- s2n [s]
  ;; (read-string s))
  (Integer/parseInt s))

(defn- _n2v [n]
  (map s2n
       (str/split (n2s n) #"")))

(def n2v (memoize _n2v))

(defn armstrong? [num]
  (=
   (let [v (n2v num)
         c (count v)
   ]
     (->> 
      (map #(exp % c) v)
     (reduce +)
   ))
   num))

