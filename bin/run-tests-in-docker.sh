#!/usr/bin/env sh

# Example:
# ./bin/run-tests-in-docker.sh

# Stop executing when a command returns a non-zero return code
set -e
# Build the Docker image
docker build --rm -t exercism/clojure-test-runner .

# Run the Docker image using the settings mimicking the production environment
# TODO: --read-only
docker run \
    --rm \
    --network none \
    --mount type=tmpfs,dst=/tmp \
    --workdir /opt/representer \
    --entrypoint /opt/representer/bin/run-tests.sh \
    exercism/clojure-representer