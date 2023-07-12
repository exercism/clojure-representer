(ns armstrong-numbers)

(defn armstrong? [num]
  (let [exp (count (str num))
        nums (map #(Character/digit %1 10) (str num))
        exp  #(Math/pow %1 exp)]
    (->> nums
         (map exp)
         (reduce +)
         (==  num))))

;; (comment

;;   (armstrong? 153)
;;   ;; (double 153kk)
;;   (armstrong? 21897142587612075)
;;      (armstrong? 21897142587612075))
;;   :rfc)
