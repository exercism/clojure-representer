(ns two-fer)

(defn two-fer 
	([name] ;; <- arglist goes here
	  ;; your code goes here
	  
	  (str "One for " 
	  	(if (< 0 (count name))
	  		name
	  		"you")
	  	", one for me."))
	([]
	(two-fer ""))
)
