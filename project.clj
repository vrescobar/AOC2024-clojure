(defproject clj-advent "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :main ^:skip-aot clj-advent.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :dependencies [[org.clojure/clojure "1.11.1"]]
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev {:dependencies [[com.github.flow-storm/clojure "1.12.0-2"]
                                  [com.github.flow-storm/flow-storm-dbg "4.0.2"] ]
                   ;; for disabling the official compiler
                   :exclusions [org.clojure/clojure]
                   :jvm-opts ["-Dclojure.storm.instrumentEnable=true"
                              ;"-Dclojure.storm.instrumentOnlyPrefixes=YOUR_INSTRUMENTATION_STRING"
                              ]}
             })
