FROM clojure:tools-deps-alpine

WORKDIR /opt/representer
COPY . .

RUN lein deps

ENTRYPOINT ["/opt/representer/bin/run.sh"]