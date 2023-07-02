(ns armstrong-numbers)

(defn power [pw]
  (fn [num] 
    (def result (bigdec (Math/pow num pw)))
    (println result)
    result
  )
)

(defn to_int [a_string]
  (Integer/parseInt a_string)
)

(defn int_list [string_digits_list]
  (map to_int (map str string_digits_list))
)

(defn armstrong? [num] ;; <- arglist goes here
  (def number_string (str num))
  (def number_size (count number_string))
  (println "number size:" number_size)
  (def string_digits_list (seq number_string))
  (def digit_list (int_list string_digits_list))
  (def powered_list (map (power number_size) digit_list))
  (def sum_of_powers (reduce + powered_list))
  (println "sum_of_powers: " sum_of_powers)
  (= num sum_of_powers)
)