#!/usr/bin/env bb

(load-file "main.clj")

(require '[main :refer [represent]])

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))