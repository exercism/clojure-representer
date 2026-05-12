FROM babashka/babashka:1.12.197-SNAPSHOT-alpine@sha256:fd235d5223d827d5186e9e711c077d5583b95764bf1c22d589b2b3b3c7d55bfe

RUN apk add --no-cache coreutils bash
WORKDIR /opt/representer
COPY . /opt/representer

ENTRYPOINT ["/opt/representer/bin/run.sh"]
