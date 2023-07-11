(ns armstrong-numbers)

(defn get-digits [n]
  (if (< n 10)
    [n]
    (conj (get-digits (quot n 10)) (rem n 10))))

(defn expt [base exponent]
  (if (zero? exponent)
    1
    (* base (expt base (dec exponent)))))

(comment (defn armstrong? [n] ;; <- arglist goes here
  ;; your code goes here
  (= n (apply + (map
                    #(expt % (count (get-digits n)))
                    (get-digits n))))))

(defn armstrong? [n] 
  (let [digits (get-digits n)
        digit-count (count digits)
        pow-digits (map #(expt % digit-count) digits)
        sumnum (apply + pow-digits)]
    (= n sumnum)))