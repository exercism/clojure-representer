(ns armstrong-numbers)

(defn pow[p n]
  (->> (repeat p n) (reduce *)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [nstr (str num)
        p (count nstr)]
    (->> nstr
         (map (comp (partial pow p) read-string str))
         (reduce +)
         (= num))))



