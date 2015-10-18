(defproject littleclj "0.10.0-SNAPSHOT"
  :description "Exercises from The Little Schemer solved in clojure"
  :url "http://github.com/michaelvessia/littleschemer"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot littleclj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
