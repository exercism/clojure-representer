(ns armstrong-numbers)

(defn parse-int [^String s]
  "Wrapped Java static function Integer.parseInt"
  (. Integer parseInt s))

(defn big-int-value [^Long i]
  "Wrapped Java static function BigInteger.valueOf"
  (BigInteger/valueOf i))

(defn big-pow [^Integer o ^Integer r]
  "Wrapped Java function for power returning BigInteger"
   (.pow (big-int-value o) r))

(defn calc_digit_list [num]
  "Split number into numerical digits. E.g. 123 becomes [1 2 3]"
  (map parse-int (map str (seq (str num)))))

(defn num_digits_summed_raised [num]
  "Sum of a numbers digits each raised to the power of the number of digits"
  (let [digit_list (calc_digit_list num)]
    (reduce +
            (for
              [n digit_list]
              (big-pow n (count digit_list))))))

(defn armstrong? [num]
  "An Armstrong number is a number that is the sum of its own digits each raised to the power of the number of digits."
  (= num (num_digits_summed_raised num)))
