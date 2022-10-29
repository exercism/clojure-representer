(ns armstrong-numbers)

(defn- digits [number]
  (map #(Character/digit % 10) (str number)))

(defn- exponent [number power]
  (loop [product 1 power power]
    (if (zero? power) product
        (recur (* number product) (dec power)))))

(defn- exponent-digits [number]
  (let [numbers (digits number)
        power (count numbers)]
    (map #(exponent % power) numbers)))

(defn- sum-exponent-digits [number]
  (reduce + (exponent-digits number)))

(defn armstrong? [number]
  (= (sum-exponent-digits number) number))