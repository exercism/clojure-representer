((do
  (do
   (clojure.core/in-ns 'armstrong-numbers)
   (if
    (clojure.core/= 'armstrong-numbers 'clojure.core)
    nil
    (do (clojure.core/-add-loaded-lib 'armstrong-numbers) nil)))
  (def char->int (fn* ([char] (Integer/parseInt (str char)))))
  (def pow (fn* ([a b] (apply * (repeat b a)))))
  (def
   armstrong?
   (fn*
    ([num]
     (let*
      [num-seq
       (map char->int (str num))
       length
       (count num-seq)
       powers
       (map (fn* [p1__435#] (pow p1__435# length)) num-seq)
       sum
       (apply + powers)]
      (= num sum)))))))
