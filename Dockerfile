FROM babashka/babashka:1.13.225-SNAPSHOT-alpine@sha256:a8e914bb6e6ce3c88b921ab7ae64f2eedf601d703a0769e28c8c40e529540cc1

RUN apk add --no-cache coreutils bash
WORKDIR /opt/representer
COPY . /opt/representer

ENTRYPOINT ["/opt/representer/bin/run.sh"]
