FROM clojure:tools-deps-alpine

RUN apk add --no-cache rlwrap

WORKDIR /opt/representer
COPY . .

RUN clojure -P

ENTRYPOINT ["/opt/representer/bin/run.sh"]