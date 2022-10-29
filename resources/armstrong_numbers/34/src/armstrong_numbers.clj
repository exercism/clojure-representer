(ns armstrong-numbers)

(defn armstrong? [num]
  ;;stepse:
  ;;count thw digits for each number
  ;;raise numbers to the power equivalent to the number of digits
  ;;sum results
  ;;compare result to initial number

  (let [digit-count (count (str num))
        digits-raised (map (fn [char]
                             (Math/pow (read-string (str char)) digit-count))
                           (str num))
        digit-sum (reduce + digits-raised)]
    #_(println digit-sum)
    (= digit-sum (double num))))




