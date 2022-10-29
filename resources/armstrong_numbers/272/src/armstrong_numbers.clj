(ns armstrong-numbers)

(defn get-digits-from-number
  "获取指定整数的每一位数字，返回列表。
   通过减去'0'对应的ascii值获取数字。
   来源：https://codereview.stackexchange.com/questions/207277/five-functions-to-get-the-digits-of-a-number"
  [number]
  (map #(- % (int \0)) (map int (str number))))

(defn exp
  "求x的n次方。注意n只能是整数。
   参考来源：https://stackoverflow.com/questions/5057047/how-to-do-exponentiation-in-clojure
   回答者使用reduce，而我改为使用apply。"
  [x n]
  (apply * (repeat n x)))

(defn armstrong? [num]
  (let [digits (get-digits-from-number num)]
    (= num (apply + (map #(exp % (count digits)) digits)))))