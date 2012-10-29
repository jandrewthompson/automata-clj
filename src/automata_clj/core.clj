(ns automata-clj.core)

(def rules 
  [{:in1 0
    :in2 0
    :in3 0
    :out 0},
   {:in1 0
    :in2 0
    :in3 1
    :out 0},
   {:in1 0
    :in2 1
    :in3 0
    :out 0},
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

(def origin (str (apply str (repeat 20 0)) 1 (apply str (repeat 20 0))))

(defn applyRules [in1 in2 in3] 
  (for [r rules :when (and 
                      (= (r :in1) in1)
                      (= (r :in2) in2)
                      (= (r :in3) in3))]

      (r :out)
    ))

(defn applyRules [inStr] 
  (for [r rules :when (and 
                      (= (r :in1) (first inStr))
                      (= (r :in2) (first inStr))
                      (= (r :in3) (first inStr)))]

      (r :out)
    )
  )
(defn calc [line] 
    (for [t (partition 2 1 "123456")]
      ;(println (str (first t) (second t) (last t)))
      ;(println (applyRules (str (first t)) (str (second t)) (str (last t))))
      (print  t)
;      (cons out (applyRules (first t) (second t) (last t)) )
  )
)


  (for [r rules :when (and 
                      (= (r :in1) 0)
                      (= (r :in2) 0)
                      (= (r :in3) 0))]

      (r :out)
    )

(defn calc [line] 
  (let [a (cons 1  (cons 2 nil ))]  a))    

(def parts (partition 3 1 [0 0 0 1 0 1 0 0 0 0 1 1]))
(map str (first parts) (second parts) (last parts))


(map #(applyRules (first % ) (second %) (last %)) parts)

(applyRules "100")

(first (first parts))

;(cons (f (first s)) m
(str origin)
(partition 3 1 origin)
(applyRules (first '(1 0 0)) 0 0)
(calc (str origin))
(apply str origin) 
(apply str (rest origin))
(comment
  (apply str (applyRules 1 0 0))
)


(str (get rules 4))
