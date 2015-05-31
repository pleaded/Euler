(defn next-collatz
  [n]
  (if (even? n)
    (/ n 2)
    (+ (* 3 n) 1)))


(defn collatz-seq
  ([n]
   (collatz-seq [n] (next-collatz n) 1))
  ([result n cnt]
  (if (= 1 n)
    ;;`{:cnt ~cnt :seq ~(concat result [1])}
    cnt
    (recur (concat result [n]) (next-collatz n) (inc cnt)))))

(defn collatz-lazy
	([] (collatz-lazy 1))
	([n] (cons (collatz-seq n) (lazy-seq (collatz-lazy (inc n))))))

(apply max (take 1000000 (positive-numbers)))
