(ns clj-advent.core
  (:require [clj-advent.day01 :as day01])
  (:gen-class))

(comment
  "Lunnch the FlowStorm GUI"
  (require '[flow-storm.api :as fs-api])
  (fs-api/local-connect))

(defn -main
  "Advent of code 2024"
  [& _args]
  (println (str "Solution 01: " (day01/s1))))
 