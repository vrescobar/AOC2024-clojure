(defproject clj-advent "0.1.0-SNAPSHOT"
  :description "Asventof code 2024"
  :url "http://example.com/FIXME"
  :license {:name "GPL-3.0"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}
  :main ^:skip-aot clj-advent.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :dependencies [[org.clojure/clojure "1.12.0"]]
                       :jvm-opts []}
             :dev {:dependencies [[org.clojure/clojure "1.12.0"]]}
             :debug {:dependencies [[com.github.flow-storm/clojure "1.12.0-2"]
                                    [com.github.flow-storm/flow-storm-dbg "4.0.2"]]
                   ;; for disabling the official compiler
                     :exclusions [org.clojure/clojure]
                     :jvm-opts ["-Dflowstorm.fileEditorCommand=/usr/local/bin/code -r --goto <<FILE>>:<<LINE>>:0"
                                "-Dclojure.storm.instrumentEnable=true"
                                "-Dclojure.storm.instrumentOnlyPrefixes=clj-advent.*,clj-advent.core,tutorial,tutorial.*"]}})
