(ns armstrong-numbers)

(defn to-digits [num] 
  (let [digits-str (-> num (str) (clojure.string/split #""))]
    (map #(BigInteger. %) digits-str)))

(defn pow [base expoent] 
  (.pow (bigdec base) expoent))

(defn armstrong [num] 
  (let [digits (to-digits num)
        digits-count (count digits)] 
         (bigint (reduce #(+ %1 (pow %2 digits-count)) 0 digits))))

(defn armstrong? [num] 
  (= num (armstrong num)))