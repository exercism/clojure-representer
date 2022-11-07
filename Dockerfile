FROM clojure:temurin-17-lein-alpine

WORKDIR /opt/representer
COPY . .

RUN clojure -P

ENTRYPOINT ["/opt/representer/bin/run.sh"]