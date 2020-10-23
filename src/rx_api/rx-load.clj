(ns rx-api.rx-load
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))


(defn csv-data->maps [csv-data]
  (map zipmap
       (repeat (map keyword (first csv-data)))
       (rest csv-data)))

(defn read-in-drug-list [conn] (with-open
                            [reader (io/reader conn)]
                             (doall
                              (csv/read-csv reader))))

(defn cut-down-list [drug-map keys]
  (map #(select-keys % keys) drug-map))

(defn load-rx [conn key-selection]
  (-> (read-in-drug-list conn)
      (csv-data->maps)
      (cut-down-list key-selection)))