(ns armstrong-numbers)

(defn power [n num]
  (loop [it n acc 1]
    (if(= it 0)
      acc
      (recur (dec it)(* acc num))
      )
    )
  )

(defn armstrong? [num]
  (loop [it (count (str num)) acc 0]
    (if (> it 0)
      (recur (dec it) (+ acc (power (count (str num)) (read-string(str(nth (str num) (- it 1)))))))
      (if (= num acc)
        true
        false)
      )
    )
  )
