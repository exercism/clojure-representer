FROM babashka/babashka:1.13.229-SNAPSHOT-alpine@sha256:a6b759f113640a10138588eaaff2f92724502822f67bab7af67d84cd876e791e

RUN apk add --no-cache coreutils bash
WORKDIR /opt/representer
COPY . /opt/representer

ENTRYPOINT ["/opt/representer/bin/run.sh"]
