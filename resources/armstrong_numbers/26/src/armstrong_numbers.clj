(ns armstrong-numbers)

(defn ** [x n] (reduce * (repeat n x))) ; This is unfortunate

(defn split-into-ints [num]
  (->>
    (clojure.string/split (str num) #"")
    (map #(Integer/parseInt %))))

(defn do-armstrong [ints]
  (let [num-ints (count ints)]
    (reduce (fn [acc i] (-> i (** num-ints) (+ acc)))
            0
            ints)))

(defn armstrong? [num]
  (let [ints (split-into-ints num)]
    (= (do-armstrong ints) num)))
