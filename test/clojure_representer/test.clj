(ns clojure-representer.test
  (:require [clojure.test :refer [deftest testing is run-tests]]
            [clojure-representer.main :refer [represent]]))

(deftest twofers-test
  (testing "50 twofers"
    (doseq [n (range 50)]
      (let [_              (represent {:slug    "two-fer"
                                       :in-dir  (str "resources/two_fer/" n "/")
                                       :out-dir (str "resources/two_fer/" n "/")})
            representation (slurp (str "resources/two_fer/" n "/representation.txt"))
            expected       (slurp (str "resources/two_fer/" n "/expected-representation.txt"))]
        (is (= representation expected))))))

(deftest armstrong-numbers-test
  (testing "50 armstrong-numbers"
    (doseq [n (range 50)]
      (let [_              (represent {:slug    "armstrong-numbers"
                                       :in-dir  (str "resources/armstrong_numbers/" n "/")
                                       :out-dir (str "resources/armstrong_numbers/" n "/")})
            representation (slurp (str "resources/armstrong_numbers/" n "/representation.txt"))
            expected       (slurp (str "resources/armstrong_numbers/" n "/expected-representation.txt"))]
        (is (= representation expected))))))

(defn -main [& args]
  (let [report (time (run-tests 'clojure-representer.test))]
    (System/exit (+ (:fail report)
                    (:error report)))))

(comment 
  (run-tests 'clojure-representer.test))