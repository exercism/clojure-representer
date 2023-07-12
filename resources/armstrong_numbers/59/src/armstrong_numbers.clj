(ns armstrong-numbers)

(defn armstrong? [num]
  ;; <- arglist goes here
  (= num
     (let [s (str num)]
       (let [n (count s)]
         (apply +' (map (fn [c] (reduce *' (repeat n (- (int c) (int \0))))) (seq s)))))))
