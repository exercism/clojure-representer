(ns exercism.clojure-representer
  (:require [clojure.java.shell :as shell]
            [clojure.edn :as edn]
            [rewrite-clj.zip :as z]
            [clojure.tools.analyzer.jvm :as ana.jvm]
            [clojure.tools.analyzer.passes.jvm.emit-form :as e]))

(defn two-fer
  "Grabs a twofer by number and returns its AST as a zipper."
  [n]
  (z/of-file (str "resources/twofers/" n "/two_fer.clj")))

(defn extract-impl 
  "Takes a zipper representing a parsed solution,
   and returns the `defn` form defined in the solution."
  [z]
  (-> (z/find-value z z/next 'defn) z/up z/sexpr))

(defn represent [z]
  (e/emit-form
   (ana.jvm/analyze (extract-impl z))))

(comment
  (represent (two-fer 1))
  )