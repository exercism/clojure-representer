(ns clojure-representer.analyzer.passes.jvm.constant-lifter
  (:require [clojure-representer.analyzer.passes.constant-lifter :as orig]
            [clojure-representer.analyzer :refer [analyze-const]]
            [clojure-representer.analyzer.utils :refer [constant? classify]]
            [clojure-representer.analyzer.passes.jvm.analyze-host-expr :refer [analyze-host-expr]]
            [clojure-representer.analyzer.passes.elide-meta :refer [elide-meta]]))

(defn constant-lift*
  [ast]
  (if (= :var (:op ast))
    (let [{:keys [var env form meta]} ast]
     (if (constant? var meta)
       (let [val @var]
         (assoc (analyze-const val env (classify val))
           :form form))
       ast))
    (orig/constant-lift ast)))

(defn constant-lift
  "Like analyzer.passes.constant-lifter/constant-lift but
   transforms also :var nodes where the var has :const in the metadata
   into :const nodes and preserves tag info"
  {:pass-info {:walk :post :depends #{} :after #{#'elide-meta #'analyze-host-expr}}}
  [ast]
  (merge (constant-lift* ast)
         (select-keys ast [:tag :o-tag :return-tag :arglists])))
