(ns two-fer)

(defn two-fer  ;; <- arglist goes here
  ;; your code goes here
  ;; FYI Exercism, this one isn't easy. You need to explain that you CAN change the function signature so that you can make the code work; in this case, grabbing the arglist and moving it to the check. After that, the solution is simple.
  ([] (two-fer "you"))
  ([name] (str "One for " name ", one for me."))
)
