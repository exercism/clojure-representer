((do
  (do
   (clojure.core/in-ns 'armstrong-numbers)
   (if
    (clojure.core/= 'armstrong-numbers 'clojure.core)
    nil
    (do (clojure.core/-add-loaded-lib 'armstrong-numbers) nil)))
  (def
   armstrong?
   (fn*
    ([num]
     (let*
      [num-str
       (str num)
       len
       (count num-str)
       arm
       (reduce
        (fn*
         ([acc num]
          (+ acc (reduce * (repeat len (Character/digit num 10))))))
        0
        num-str)]
      (= num arm)))))))
