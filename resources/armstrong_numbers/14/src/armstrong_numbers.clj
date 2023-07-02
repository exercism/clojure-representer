(ns armstrong-numbers)

(defn n-pow [x y]
  (apply * (repeat y x)))

(defn c->i [c]
  (Character/digit c 10))

(defn armstrong? [number]
  (let [num-str (str number)
        base (count num-str)]
    (-> (reduce #(+ %1 (n-pow (c->i %2) base))
                0
                num-str)
        (= number))))
