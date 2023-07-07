FROM babashka/babashka:1.3.182-SNAPSHOT-alpine

RUN apk add --no-cache bash

WORKDIR /opt/representer
COPY . .

ENTRYPOINT ["/opt/representer/bin/run.sh"]