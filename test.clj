
(require '[clojure.test :refer :all]
         ;'[main :refer [represent]]
         '[clojure.java.io :as io])
(import '[java.nio.file Files Path]
         '[java.net URI])

(defn- as-path
  ^Path [path]
  (if (instance? Path path) path
      (if (instance? URI path)
        (java.nio.file.Paths/get ^URI path)
        (.toPath (io/file path)))))

(load-file "main.clj")

(require '[main :refer [represent]])

(deftest twofers-test
  (testing "50 twofers"
    (doseq [n (range 50)]
      (let [_              (represent {:slug    "two-fer"
                                       :in-dir  (str "resources/two_fer/" n "/")
                                       :out-dir (str "resources/two_fer/" n "/")})
            representation (slurp (str "resources/two_fer/" n "/representation.txt"))
            expected       (slurp (str "resources/two_fer/" n "/expected-representation.txt"))]
        (is (= representation expected)))))
  ;; clean up files
  (run! #(Files/delete (as-path (io/file (str "resources/two_fer/" % "/") "representation.txt")))
        (range 50))
  (run! #(Files/delete (as-path (io/file (str "resources/two_fer/" % "/") "mapping.json")))
        (range 50)))

(deftest armstrong-numbers-test
  (testing "50 armstrong-numbers"
    (doseq [n (range 50)]
      (let [_              (represent {:slug    "armstrong-numbers"
                                       :in-dir  (str "resources/armstrong_numbers/" n "/")
                                       :out-dir (str "resources/armstrong_numbers/" n "/")})
            representation (slurp (str "resources/armstrong_numbers/" n "/representation.txt"))
            expected       (slurp (str "resources/armstrong_numbers/" n "/expected-representation.txt"))]
        (is (= representation expected)))))
  ;; clean up files
  (run! #(Files/delete (as-path (io/file (str "resources/armstrong_numbers/" % "/") "representation.txt")))
        (range 50))
  (run! #(Files/delete (as-path (io/file (str "resources/armstrong_numbers/" % "/") "mapping.json")))
        (range 50)))

(let [report (clojure.test/run-tests)]
  (System/exit (+ (:fail report)
                  (:error report))))