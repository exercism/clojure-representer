FROM clojure:tools-deps-alpine as builder

# Install SSL ca certificates
RUN apk update && apk add ca-certificates

# Create appuser
RUN adduser -D -g '' appuser

# get the source code
WORKDIR /clojure-representer
COPY . /clojure-representer

# Build a minimal and secured container
FROM clojure:tools-deps-alpine
COPY --from=builder /etc/ssl/certs/ca-certificates.crt /etc/ssl/certs/
COPY --from=builder /etc/passwd /etc/passwd
WORKDIR /opt/representer
COPY --from=builder /clojure-representer/ .

USER appuser
ENTRYPOINT ["/opt/representer/bin/run.sh"]