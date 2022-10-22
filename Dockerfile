FROM openjdk:17-alpine3.14

RUN apk update

WORKDIR /opt/representer
COPY ./clojure-representer-1.2.40-standalone.jar /opt/representer
COPY ./bin/run.sh /opt/representer/bin/run.sh
COPY ./src /opt/representer/src
COPY ./resources /opt/representer/resources

ENTRYPOINT ["sh", "/opt/representer/bin/run.sh"]