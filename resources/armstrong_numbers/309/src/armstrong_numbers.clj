(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (->> num
                    (str)
                    (seq)
                    (map str)
                    (map read-string))
        n (count digits)
        digits-pow (->> digits
                        (map #(Math/pow % n))
                        (map long))]
    (= num (reduce + digits-pow))))