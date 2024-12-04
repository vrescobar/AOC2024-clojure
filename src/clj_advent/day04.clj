(ns clj-advent.day04
  (:require
   [clojure.string :as str]))

  ;(def result '(("2" "4") ("don't()") ("32", "64") ("11, 8") ("do()") ("8" "5")))
  ;(def result '((2 4)  (8 5)))
(defn transpose-str [s]
  (->> s (str/split-lines)
       (mapv #(mapv char %))
       (apply mapv vector)
       (map #(apply str %))
       (str/join "\n")))


(def example "....XXMAS.
.SAMXMS...
...S..A...
..A.A.MS.X
XMASAMX.MM
X.....XA.A
S.S.S.S.SS
.A.A.A.A.A
..M.M.M.MM
.X.X.XMASX")

#_(let [length (count (take-while (partial not= \newline) example))  ; example is 10
      horizontal1 "(XMAS|SAMX)"
      horizontal2 "(SAMX)"
      vertical1 (str "(" (str/join (str "(?:[\\S\\s]{" (inc length) "})?") "XMAS") ")")
      vertical2 (str "(" (str/join (str "(?:[\\S\\s]{" (inc length) "})?") "SAMX") ")")

      diagonal11 (str "("  (str/join (str "(?:[\\S\\s]{" length "})?") "XMAS") ")")
      diagonal12 (str "("  (str/join (str "(?:[\\S\\s]{" length "})?") "XMAS") ")")

      diagonal21 (str "("  (str/join (str "(?:[\\S\\s]{" (+ 2 length) "})?") "XMAS") ")")
      diagonal22 (str "("  (str/join (str "(?:[\\S\\s]{" (+ 2 length) "})?") "XMAS") ")")



      patterns (map re-pattern [horizontal1
                                horizontal2
                                vertical1
                                vertical2
                                diagonal11
                                diagonal12
                                diagonal21
                                diagonal22])]

  (->>
   (map #(re-seq % example) patterns)
     ;(map count)
     ;(flatten)
     ;(filter (partial re-matches #"XMAS|SMAX"))
     ;(count)
     ;(reduce +)
   ))


(let [example (slurp "day4-1.txt")
      length (count (take-while (partial not= \newline) example)) ; Grid width
      grid (vec (str/split-lines example)) ; Split input into lines
        ;; Patterns for forward and backward "XMAS"
      words ["XMAS" "SAMX"]
        ;; Function to check matches in all directions
      find-matches
      (fn [grid word]
        (let [n (count grid)
              directions [[0 1] [1 0] [1 1] [1 -1]] ; Right, Down, Diagonal-Down-Right, Diagonal-Down-Left
              in-bounds?
              (fn [x y]
                (and (>= x 0) (< x n) (>= y 0) (< y length)))
              collect-word
              (fn [x y dx dy]
                (loop [i 0 x x y y acc []]
                  (if (< i (count word))
                    (if (in-bounds? x y)
                      (recur (inc i) (+ x dx) (+ y dy) (conj acc (get-in grid [x y])))
                      nil)
                    acc)))]
          (for [x (range n)
                y (range length)
                [dx dy] directions
                :let [candidate (collect-word x y dx dy)]
                :when (= candidate (seq word))]
            [x y dx dy])))]

    ;; Collect all matches for "XMAS" and "SAMX"
  (->> (mapcat #(find-matches grid %) words)
       (count))) ; Count total matches
