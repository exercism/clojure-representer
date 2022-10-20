(ns clojure-representer-test
  (:require [clojure.test :refer :all]
            [clojure-representer :refer [represent]]
            [clojure.java.io :as io])
  (:import [java.nio.file Files Path]
            [java.net URI]))

(defn- as-path
  ^Path [path]
  (if (instance? Path path) path
      (if (instance? URI path)
        (java.nio.file.Paths/get ^URI path)
        (.toPath (io/file path)))))

(deftest represent-test
  (testing "500 twofers"
    (doseq [twofer (range 500)]
      (is (= (represent "two-fer" "resources/twofers/0/" "resources/") 1)))))

(doseq [n (range 500)]
  (represent "two-fer" (str "resources/twofers/" n "/") (str "resources/twofers/" n "/")))

(doseq [n (range 374 500)]
  (Files/delete (as-path (io/file (str "resources/twofers/" n "/") "expected.txt"))))

(io/file (str "resources/twofers/"  "/") "expected.txt")

(run-tests)