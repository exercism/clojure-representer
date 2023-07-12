(ns armstrong-numbers)

(defn pow [x y] (java.lang.Math/pow x y))

(defn pow-big-decimal [x y] (. (java.math.BigDecimal/valueOf (double x)) pow y))

(defn str-to-int-vec
  [strVec]
  (if (= (count strVec) 0) [] (conj (str-to-int-vec (subvec strVec 1)) (Integer/parseInt (get strVec 0))))
)

(defn vec-pow-sum 
  [intVec a] 
  (if (= (count intVec) 1) (pow (get intVec 0) a) (+ (pow (get intVec 0) a) (vec-pow-sum (subvec intVec 1) a)))
)

(defn vec-pow-sum-big-decimal 
  [intVec a] 
  (if (= (count intVec) 1) (pow-big-decimal (get intVec 0) a) (. (pow-big-decimal (get intVec 0) a) add (vec-pow-sum-big-decimal (subvec intVec 1) a)))
)

(defn armstrong? [num]
  (def numStr (str "" num))
  (def numDigits (count numStr))
  (def digits (subvec (clojure.string/split numStr #"") 0))
  ;;(= (double num) (vec-pow-sum (str-to-int-vec digits) numDigits))
  (def calc (vec-pow-sum-big-decimal (str-to-int-vec digits) numDigits))
  ;;(println numStr numDigits digits calc)
  (= (java.math.BigDecimal/valueOf num) calc)
)
