(defproject rx-api "CljRxPOC-0.0.2-SNAPSHOT"

  :description "A POC to create an sequential lookup of names and dosage to NDC number in clojure,
                Eventually deploying this to AWS Lambda for high availability."
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring/ring-jetty-adapter "1.8.1"]
                 [org.clojure/data.csv "1.0.0"]
                 [compojure "1.6.2"]
                 [environ "1.2.0"]]
  :main ^:skip-aot rx-api.core
  :target-path "target/%s"
  :uberjar-name "cljRxLookupPOC.jar"
  :profiles {:uberjar {:aot :all}})
