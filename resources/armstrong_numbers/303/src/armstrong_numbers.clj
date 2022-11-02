(ns armstrong-numbers)

(defn armstrong? 
  [n]
  "Use BigInteger instead of Integer to better handle larger numbers."
  (if (number? n)
    (let [n-vec (vec (str n))
          n-str (map str n-vec)
          n-int (for [c n-str] (BigInteger. c))
          cnt   (count n-int)
          n-int-pow (for [c n-int] (.pow c cnt))]
      (if (=  (reduce + n-int-pow) n)
        true
        false)
    )
    false))


(comment
  (Math/pow 1 2)

  (map str (->> 123
                 str
                 vec))

  (let [n 21897142587612075
        n-vec (vec (str n))
        n-str (map str n-vec)
        n-int (for [c n-str] (Long/parseLong c))
        cnt   (count n-int)
        n-int-pow (for [c n-int] (Math/pow c cnt))]
    (println n n-vec n-str n-int n-int-pow)
    (println (reduce + n-int))
    (println (reduce + n-int-pow))
    (Math/round (reduce + n-int-pow))
  )

  (let [n 21897142587612075
        n-vec (vec (str n))
        n-str (map str n-vec)
        n-int (for [c n-str] (BigInteger. c))
        cnt   (count n-int)
        n-int-pow (for [c n-int] (.pow c cnt))]
    (println n n-vec n-str n-int n-int-pow)
    (println (reduce + n-int))
    (println (reduce + n-int-pow))
  )

  (armstrong? 1)
  (armstrong? 9)
  (armstrong? 10)
  (armstrong? "ab")
  (armstrong? 21897142587612075)
)



