(defproject liberator-mysql-sample "0.1.0-SNAPSHOT"
  :description "liberator-mysql-sample"
  :url "https://github.com/karmakaze/liberator-mysql-sample"
  :plugins [[lein-ring "0.12.2"]]
  :ring {:handler liberator-mysql-sample.core/handler}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [liberator "0.15.1"]
                 [compojure "1.6.0"]
                 [ring/ring-core "1.6.3"]
                 [org.clojure/java.jdbc "0.7.8"]
                 [mysql/mysql-connector-java "8.0.13"]]
  :repl-options {:init-ns liberator-mysql-sample.core})
