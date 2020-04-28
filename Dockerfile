FROM java:8-alpine
RUN mkdir -p /resources /app/resources/output
WORKDIR /
COPY clojure-representer.jar .
CMD java -jar clojure-representer.jar