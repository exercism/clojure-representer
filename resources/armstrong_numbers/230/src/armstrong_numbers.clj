(ns armstrong-numbers)

 (defn
    armstrong?
    [num]
    (let
     [str-num (str num) len (count str-num)]
     (->> str-num (map (fn* [p1__26076#] (-> p1__26076# str BigInteger. (.pow len)))) (apply +) (= num))))