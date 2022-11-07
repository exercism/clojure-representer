FROM clojure:tools-deps-alpine

RUN apk add --no-cache bash rlwrap

WORKDIR /opt/representer
COPY . .

RUN clojure -P

ENTRYPOINT ["/opt/representer/bin/run.sh"]