(ns armstrong-numbers)

;; digits method acquired from https://github.com/bbatsov
(defn digits [n]
  (map #(read-string (str %)) (str n)))

(defn exp [n power]
  (def ret n)
  (when (< 2 power)
    (loop [x 2]
      (when (<= x power)
        (def ret (* n ret))
        (recur (inc x))
      )
    )
  )
  ret
)

(defn armstrong? [num]
  (= num 
     (let [x (count (str num))] 
       (reduce + 
               (map #(exp % x) 
       (digits num)))))
)
