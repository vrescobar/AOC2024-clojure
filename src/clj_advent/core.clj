(ns clj-advent.core
  (:require [clj-advent.day01 :as day01])
  (:require [clj-advent.day02])
  (:require [clj-advent.day03])
  (:gen-class))

(comment
  "Lunnch the FlowStorm GUI"
  (require '[flow-storm.api :as fs-api])
  (fs-api/local-connect))

(defn -main
  "Advent of code 2024"
  [& _args]
  (println (str "Solution 01: " (day01/s1)))
  (println (str "Solution 02: " (clj-advent.day02/s2)))
  (println (str "Solution 03: " (clj-advent.day03/s3) ", " (clj-advent.day03/s3-2)))
  (println (str "Solution 04: " "missed."))
  ;
  )
 