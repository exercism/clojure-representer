(ns armstrong-numbers)

 (defn armstrong? [n]
  (let [nstr (str n)       
        xp  (count nstr)    
        nums (clojure.string/split nstr #"")  
        nums-to-xp (map #(.pow (BigInteger. %) xp) nums)] 
    (= n (apply + nums-to-xp )))
)
