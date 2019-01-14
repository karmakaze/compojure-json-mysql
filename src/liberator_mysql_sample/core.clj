(ns liberator-mysql-sample.core
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY]]
            [clojure.java.jdbc :as jdbc]))

(def db-spec
  {:dbtype "mysql"
   :host "140.82.1.233"
   :dbname "ispecsdb"
   :user "ispecsdb"
   :password (or (System/getenv "MYSQL_PASSWORD") "Virago.1")})

(defn create-blogs
  "Create a table to store blog entries"
  []
  (jdbc/create-table-ddl :blogs
                         [[:id :integer "PRIMARY KEY" "AUTO_INCREMENT"]
                          [:title "varchar(255)"]
                          [:body :text]]))

(defn drop-blogs
  "Drop the blogs table"
  []
  (try
   (jdbc/drop-table-ddl :blogs)
   (catch Exception _)))

(defn foo
  "I don't do a whole lot."
  []
  (jdbc/query db-spec ["SELECT * FROM blogs"]))

(defroutes app
  (ANY "/foo" [] (resource :available-media-types ["text/html"]
                           :handle-ok (foo))))

(def handler 
  (-> app 
      wrap-params))
