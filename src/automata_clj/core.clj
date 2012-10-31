(ns automata-clj.core)

(def rules 
  [{:in1 0
    :in2 0
    :in3 0
    :out 0},

   {:in1 0
    :in2 0
    :in3 1
    :out 1},
   
   {:in1 0
    :in2 1
    :in3 0
    :out 1},

   {:in1 0
    :in2 1
    :in3 1
    :out 1},

   {:in1 1
    :in2 0
    :in3 0
    :out 1},

   {:in1 1
    :in2 0
    :in3 1
    :out 0},

   {:in1 1
    :in2 1
    :in3 0
    :out 0},

   {:in1 1
    :in2 1
    :in3 1
    :out 0},
   ])

(def origin (vec (flatten (conj  (repeat 30 0) 1 (repeat 30 0) ))))

(defn applyRules [in1 in2 in3] 
  (for [r rules :when (and 
                      (= (r :in1) in1)
                      (= (r :in2) in2)
                      (= (r :in3) in3))]
      (r :out)))

(defn genLine [input]
  (vec 
    (flatten 
      (map (partial apply applyRules) 
         (partition 3 1 input)))))

(defn doAutomata [coll]
  (if (seq coll)
    (lazy-seq 
      (cons coll 
        (doAutomata (genLine (cons 0 (conj coll 0 ))))))))

(comment
  (take 5 (doAutomata origin))

  (apply str (applyRules 1 0 0))
  (doall origin)
  (str (get rules 4))

  (flatten 
   (map #(applyRules (first %) (second %) (last %)) 
    (partition 3 1 origin)))
  
  (partition 3 1 (cons 0 origin))
  
  
  (vec (flatten (repeat 4 0)))
   (conj  (repeat 5 0) 1 (repeat 5 0) )
  (conj '(0 0 0) 4)
  (cons 2 (conj origin  3))
  (cons 2 origin  )
  
  (doall origin)
  (zz origin)
  (zz (zz origin))
  (zz (zz (zz origin)))
  (zz (zz (zz (zz origin))))
  (conj (zz origin) (zz (zz origin)) (zz (zz (zz origin) ) ))
  
  
  (lazy-seq (conj origin (zz origin) (zz (zz origin)) (zz (zz (zz origin))) ) )
)


