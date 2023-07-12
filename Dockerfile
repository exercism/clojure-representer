FROM babashka/babashka:1.3.182-SNAPSHOT-alpine

RUN apk add --no-cache coreutils bash
WORKDIR /opt/representer
COPY . /opt/representer

ENTRYPOINT ["/opt/representer/bin/run.sh"]