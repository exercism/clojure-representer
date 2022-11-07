(ns armstrong-numbers)

(defn armstrong? [num]
  (let [num-list (digits num)
        digit-count (count num-list)]
    (= num
       (reduce + (map #(exp %1 digit-count) num-list))))
  )

;; Copied from here https://stackoverflow.com/a/29942388
;; Damn this is nice :-)
(defn digits [n]
  "Separate an int into a list of each digit (e.g. 153 => (1 5 3))"
  (->> n
       str
       (map (comp read-string str))))

;; Also copied, but it was too nice to pass up. I feel a little guilty but I
;; figure this is better than importing a 3rd-party package.
;; https://stackoverflow.com/a/5058544
(defn exp [x n]
  (reduce * (repeat n x)))
