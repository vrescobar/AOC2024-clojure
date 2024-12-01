(ns clj-advent.core
  (:gen-class))

(comment
  "Lunnch the FlowStorm GUI"
  (require '[flow-storm.api :as fs-api])
  (fs-api/local-connect))

(defn name
  [name]
  (str "Hello " name "!"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (name "Víctor")))
 