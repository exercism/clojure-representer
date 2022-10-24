(defproject clojure-representer "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/tools.reader "1.3.6"]
                 [org.ow2.asm/asm "9.2"]
                 [org.clojure/core.memoize "1.0.257"]
                 [rewrite-clj "1.1.45"]
                 [org.clojure/data.json "2.4.0"]]
  :main clojure-representer.core/-main
  :pom-location "/tmp"
   :target-path "/tmp/%s/"
  :repl-options {:init-ns clojure-representer.core})
