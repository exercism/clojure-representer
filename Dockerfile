FROM clojure:tools-deps-alpine

WORKDIR /opt/representer
COPY . .

ENTRYPOINT ["/opt/representer/bin/run.sh"]