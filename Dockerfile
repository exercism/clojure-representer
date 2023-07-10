FROM babashka/babashka:1.3.182-SNAPSHOT-alpine

RUN apk add --no-cache jq coreutils bash

COPY . /opt/representer

ENTRYPOINT ["/cli.clj"]