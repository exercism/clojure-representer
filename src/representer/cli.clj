(ns representer.cli
  (:require [representer.main :refer [represent]]))

(defn -main [[slug in-dir out-dir] *command-line-args*]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))