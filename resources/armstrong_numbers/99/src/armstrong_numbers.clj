(ns armstrong-numbers)

(defn digits-of-number
  ([n] (digits-of-number n []))
  (^:private [n digits]
   (let [leading-digits (quot n 10)
         tens-digit (mod n 10)
         accumulated-digits (cons tens-digit digits)]
     (if (= leading-digits 0)
       [(count accumulated-digits) accumulated-digits]
       (recur leading-digits accumulated-digits)))))

(defn exp [pow n]
   (if (= pow 0) 1
     (reduce * (repeat pow n))))

(defn armstrong? [num]
  (let [[digit-count digits] (digits-of-number num)
        sum (reduce + (map #(exp digit-count %) digits))
        result (= num sum)]
    result))
