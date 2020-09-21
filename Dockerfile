FROM clojure:tools-deps-alpine
LABEL Name=clojure-representer Version=0.0.1
COPY . /opt/representer
WORKDIR /opt/representerer
ENTRYPOINT ["/opt/representer/bin/run.sh"]
