(ns rx-api.core
 (:require [rx-api/rx-load :as rx-load]))

(def keys-needed [:prodnme :ndcnum :strngth :pksize :mstfmds])


(defn -main
  "Load Rx into Memory and expose fuzzy matcher"
  []
  (rx-load/load-rx "conn" keys-needed))
