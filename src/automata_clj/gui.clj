(ns automata-clj.gui
  (:use automata-clj.core)
  (:use quil.core))


(defn setup []
  (smooth)
  (frame-rate 10)
  (background 200))

(defn draw []
  (background 220)
  (let [c (take 50 (doAutomata origin))]
    (doseq [l (zipmap (iterate inc 0) c)]
      (doseq [idx (zipmap (iterate inc 0) (second l))]
        (if (= (second idx) 1)
          (fill (random 0 125))
          (fill 255))
        (rect (* (first idx) 10) (* (first l) 10) 5 5)
   )
) ))

(defn draw []
  (stroke (random 255))
  (stroke-weight (random 20))
  (fill (random 255))

  (let [diam (random 100)
        x    (random (width))
        y    (random (height))]
    (ellipse  x y diam diam)))

(defsketch example
           :title "Automata"
           :setup setup
           :draw draw
           :size [323 200])
