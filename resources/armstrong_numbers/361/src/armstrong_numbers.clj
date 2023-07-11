(ns armstrong-numbers)

(defn armstrong? [num]                                      ;; <- arglist goes here
  (= num (reduce +
                   (map #(bigint (Math/pow % (count (str num))))
                        (->> (str num)
                             seq
                             (map (comp read-string str)))))))
