(defproject gist-notes "0.1.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"][tentacles "0.5.1"]]
  :main ^:skip-aot gist-notes.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
