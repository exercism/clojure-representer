FROM clojure:temurin-17-lein-alpine

WORKDIR /opt/representer
COPY . .

RUN lein deps

ENTRYPOINT ["/opt/representer/bin/run.sh"]