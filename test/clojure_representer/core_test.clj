(ns clojure-representer.core-test
  (:require [clojure.test :refer :all]
            [rewrite-clj.zip :as z]
            [clojure-representer.core :refer [represent]]
            [clojure.java.io :as io])
  (:import [java.nio.file Files Path]
            [java.net URI]))

(defn- as-path
  ^Path [path]
  (if (instance? Path path) path
      (if (instance? URI path)
        (java.nio.file.Paths/get ^URI path)
        (.toPath (io/file path)))))

(defn remove-path [f]
  (-> f
      z/of-file
      (z/find-value z/next :file)
      z/right
      (z/replace "")
      z/sexpr))

(deftest twofers-test
  (testing "500 twofers"
    (doseq [n (range 500)]
      (let [_ (represent {:slug "two-fer" :in-dir (str "resources/twofers/" n "/")
                          :out-dir (str "resources/twofers/" n "/")})
            representation (str "resources/twofers/" n "/representation.txt")
            expected (str "resources/twofers/" n "/expected-representation.txt")]
        (is (= (remove-path representation) (remove-path expected))))))
  (testing "Unique solutions"
    (is (= 141 (count (set (map #(slurp (str "resources/twofers/" % "/representation.txt"))
                                (range 500)))))))
  (run! #(Files/delete (as-path (io/file (str "resources/twofers/" % "/") "representation.txt")))
        (range 500))
  (run! #(Files/delete (as-path (io/file (str "resources/twofers/" % "/") "mapping.json")))
        (range 500))
)

(comment
  (run-tests)
  )