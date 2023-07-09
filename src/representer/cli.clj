(ns representer.cli
  (:require [representer.main :refer [represent]]))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))