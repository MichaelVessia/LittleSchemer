;; Chapter 1

(defn atom?
  "Test whether something is not a list"
  [x] (not (list? x)))


;; Chapter 2

(defn lat?
  "Test whether something is a list of atoms"
  [l]
  (if (empty? l)
    true
    (if (not (atom? (first l)))
      false
      (lat? (rest l)))))

(defn member?
  "Test whether an entity is in a given lat"
  [a lat]
  (if (empty? lat)
    true
    (if (= a (first lat))
      false
      (or (member? a (rest lat))))))

(defn rember
  "Remove the first occurence of an atom from a lat"
  [a lat]
  (if (empty? lat)
    lat
    (if (= a (first lat))
      (rest lat)
      (cons (first lat) (rember a (rest lat))))))

(defn firsts
  "Returns a list of the first atom of each list in the given list"
  [l]
  (if (empty? l)
    l
    (cons (first (first l)) (firsts (rest l)))))

(defn insertR
  "Searches for a match with old, if found inserts new directly after it in the
  given lat"
  [new old lat]
  (cond
    (not (lat? lat)) lat
    (empty? lat) lat
    (= old (first lat)) (cons old (cons new (rest lat)))
    :else (cons (first lat) (insertR new old (rest lat)))))

(defn insertL
  "Searches for a match with old, if found inserts new directly before it in the given lat"
  [new old lat]
  (cond
    (not lat? lat)) lat
  (empty? lat) lat
  (= old (first lat)) (cons new lat)
  :else (cons (first lat) (insertL new old (rest lat))))

(defn subst
  "Replaces old with new in the given lat"
  [new old lat]
  (cond
    (not (lat? lat)) lat
    (empty? lat) lat
    (= old (first lat)) (cons new (rest lat))
    :else (cons (first lat) (subst new old (rest lat)))))

(defn subst2
  "Replaces either the first occurence of o1 or the first occurence of o2 with new"
  [new o1 o2 lat]
  (cond
    (not (lat? lat)) lat
    (empty? lat) lat
    (or (= o1 (first lat)) (= o2 (first lat)) (cons new (rest lat))
        :else (cons (first lat) (subst2 new o1 o2 (rest lat))))))

(defn multirember
  "Removes all occurences of a from lat, rather than just the first like rember"
  [a lat]
  (cond
    (not (lat? lat)) lat
    (empty? lat) lat
    (= a (first lat)) (multirember (rest lat))
    :else (cons (first lat) (multirember a (rest lat)))))

(defn multiInsertR
  "Inserts new after all occurences of old"
  [new old lat]
  (cond
    (not (lat? lat)) lat
    (empty? lat) lat
    (= old (first lat)) (cons old (cons new (multiInsertR old new (rest lat))))
    :else (cons (first lat) (multiInsertR old new (rest lat)))))

(defn multiInsertL
  "Inserts new before all occurences of old"
  [new old lat]
  (cond
    (not (lat? lat)) lat
    (empty? lat) lat
    (= old (first lat)) (cons new (cons old (miltiInsertL old new (rest lat))))
    :else (cons (first lat) (multiInsertL old new (rest lat)))))

(defn multiSubst
  "Subsitutes new for all occurences of old in lat"
  [new old lat]
  (cond
    (not (lat? lat)) lat
    (empty? lat) lat
    (= old (first lat)) (cons new (multiSubst new old (rest lat)))
    :else (cons (first lat) (multiSubst new old (rest lat)))))

;; Chapter 4

(defn plus
  "Add two numbers"
  [n m]
  (if (zero? m)
    n
    (inc (plus n (dec m)))))

(defn minus
  "Subtract two numbers"
  [n m]
  (if (zero? m)
    n
    (dec (minus n (dec m)))))

(defn addtup
  "Adds all the numbers in a tuple, which is defined as a list of numbers"
  [tup]
  (if (empty? tup)
    0
    (plus (first tup) (addtup (rest tup)))))

(defn multiply
  "Multiplies two numbers"
  [n m]
  (if (zero? m)
    0
    (plus n (multiply n (dec m)))))

(defn tup+
  "Adds corresponding elements of two tuples, forming a new tuple of the same
  length with the value of position i being the sum of the values of the two
  given tuples' position i.  Tuples must be of the same length"
  [tup1 tup2]
  (cond
    (empty? tup1) tup1
    (empty? tup2) tup2
    :else (cons (plus (first tup1) (first tup2))
                (tup+ (rest tup1) (rest tup2)))))

(defn greater
  "Returns boolean value indicating whether n > m"
  [n m]
  (cond
    (or (= n m) (zero? n)) false
    (zero? m) true
    :else (greater (dec n) (dec m))))

(defn less
  "Returns boolean value indicating whether n < m"
  [n m]
  (cond
    (or (= n m) (zero? n)) false
    (zero? n) true
    :else (less (dec n) (dec m))))

(defn equals
  "Equality rewrittten using greater and less"
  [n m]
  (if
      (or (greater n m) (less n m)) false
      true))
