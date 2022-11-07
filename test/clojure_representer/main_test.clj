(ns clojure-representer.main-test
  (:require [clojure.test :refer :all]
            [clojure-representer.main :refer [represent]]
            [clojure.java.io :as io])
  (:import [java.nio.file Files Path]
           [java.net URI]))

(defn- as-path
  ^Path [path]
  (if (instance? Path path) path
      (if (instance? URI path)
        (java.nio.file.Paths/get ^URI path)
        (.toPath (io/file path)))))

(deftest twofers-test
  (testing "500 twofers"
    (doseq [n (range 500)]
      (let [_              (represent {:slug    "two-fer"
                                       :in-dir  (str "resources/twofers/" n "/")
                                       :out-dir (str "resources/twofers/" n "/")})
            representation (slurp (str "resources/twofers/" n "/representation.txt"))
            expected       (slurp (str "resources/twofers/" n "/expected-representation.txt"))]
        (is (= representation expected)))))
  ;; clean up files
  (run! #(Files/delete (as-path (io/file (str "resources/twofers/" % "/") "representation.txt")))
        (range 500))
  (run! #(Files/delete (as-path (io/file (str "resources/twofers/" % "/") "mapping.json")))
        (range 500)))

(deftest armstrong-numbers-test
  (testing "500 armstrong-numbers"
    (doseq [n (range 500)]
      (let [_              (represent {:slug    "armstrong-numbers"
                                       :in-dir  (str "resources/armstrong_numbers/" n "/src/")
                                       :out-dir (str "resources/armstrong_numbers/" n "/src/")})
            representation (slurp (str "resources/armstrong_numbers/" n "/src/representation.txt"))
            expected       (slurp (str "resources/armstrong_numbers/" n "/src/expected-representation.txt"))]
        (is (= representation expected)))))
  ;; clean up files
  (run! #(Files/delete (as-path (io/file (str "resources/armstrong_numbers/" % "/src/") "representation.txt")))
        (range 500))
  (run! #(Files/delete (as-path (io/file (str "resources/armstrong_numbers/" % "/src/") "mapping.json")))
        (range 500)))
