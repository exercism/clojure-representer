FROM babashka/babashka:0.10.163-alpine as builder

# Install SSL ca certificates
RUN apk update && apk add ca-certificates

# Create appuser
RUN adduser -D -g '' appuser

# get the source code
WORKDIR /clojure-representer
COPY clojure_representer.clj .

# Get static analyzer image as build stage
FROM cljkondo/clj-kondo:2021.01.20-alpine as clj-kondo

# Build a minimal and secured container
FROM babashka/babashka:0.10.163-alpine
COPY --from=builder /etc/ssl/certs/ca-certificates.crt /etc/ssl/certs/
COPY --from=builder /etc/passwd /etc/passwd
COPY --from=builder /clojure-representer/clojure_representer.clj /opt/representer/clojure_representer.clj

# Install clj-kondo
COPY --from=clj-kondo /bin/clj-kondo /usr/bin/

USER appuser
WORKDIR /opt/representer
ENTRYPOINT ["/opt/representer/bin/run.sh"]
