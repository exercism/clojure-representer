(ns armstrong-numbers)

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
                  (recur (* x acc) (dec n)))))

(defn armstrong? [num]                                      ;; <- arglist goes here
  ;; your code goes here
  (let [numeroString (str num)
        expoente (.length numeroString)]
    (loop [contador 0
           resultado 0]
      (if (= contador expoente)
        (= resultado num)
        (recur (inc contador) (+ resultado (exp (Character/digit (get numeroString contador) 10) expoente))))
      )
    )
  )