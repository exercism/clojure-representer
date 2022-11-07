FROM clojure:tools-deps-alpine

WORKDIR /opt/representer
COPY . .

RUN clojure -P

ENTRYPOINT ["/opt/representer/bin/run.sh"]