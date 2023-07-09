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
      [xs (str num) ln (count xs)]
      (=
       num
       (apply
        +
        (map
         (fn*
          [p1__4811#]
          (. (biginteger (Character/digit p1__4811# 10)) pow ln))
         xs)))))))))
