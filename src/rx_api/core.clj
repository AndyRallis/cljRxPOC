(ns rx-api.core
 (:require [rx-api.rx-load :as rx-load]
           [compojure.route :as route]
           [compojure.handler :refer [site]]
           [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
           [ring.adapter.jetty :as jetty]
           [environ.core :refer [env]]))

(def keys-needed [:prodnme :ndcnum :strngth :pksize :mstfmds])

(defn splash []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Test Rx API"})

(defroutes app
  (GET "/" []
    (splash))
  (ANY "*" []
    (route/not-found "not found")))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))