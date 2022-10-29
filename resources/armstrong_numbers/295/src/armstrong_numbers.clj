(ns armstrong-numbers)

(defn digit-vec
  "Get digit vector from a number"
  [nb]
  (map read-string (clojure.string/split (str nb) #"")))

(defn exp [x n]
  "Get x^n"
  (reduce * (repeat n x)))

(defn calculate
  [digit_list]
  (let [size (count digit_list)]
    (reduce + (map #(exp % size) digit_list))
    ))

(defn armstrong?
  [nb]
  (= (calculate (digit-vec nb)) nb))



