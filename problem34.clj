
(defn fact
  ([n] (fact 1 n))
  ([res n] (if (= n 1)
             res
             (recur (* res n) (dec n)))))

;; (defn lazy-fact
;;   ([] (lazy-fact 1))
;;   ([n] (cons (fact n) (->> n (inc) (lazy-fact) (lazy-seq)))))

(defn explode-to-digits [number]
  (map #(Character/getNumericValue %) (str number)))

(defn sfact
  [a b]
  (+ (fact b) a))

(defn fact-digits
  [n]
  (reduce sfact 0 (explode-to-digits 145)))

(def check-border 150)

(filter #(and (= (fact-digits %) %)) (take check-border (range)))
