#!/usr/bin/env sh

# Synopsis:
# Run the representer on a solution using the representer Docker image.
# The representer Docker image is built automatically.

# Usage:
# ./bin/run-in-docker.sh two-fer ~/folder/to/solution/input ~/folder/to/representer/output

# Stop executing when a command returns a non-zero return code
set -e

# If any required arguments is missing, print the usage and exit
if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ]; then
    echo "usage: ./bin/run-in-docker.sh exercise-slug path/to/solution/folder/ path/to/output/directory/"
    exit 1
fi

slug="$1"
input_dir="$(realpath ${2%/})"
output_dir="$(realpath ${3%/})"

# Create the output directory if it doesn't exist
mkdir -p "${output_dir}"

# Build the Docker image
docker build --rm -t exercism/clojure-representer .

# Run the Docker image using the settings mimicking the production environment
docker run \
    --rm \
    --network none \
    --read-only \
    --mount type=bind,src="${input_dir}",dst=/solution \
    --mount type=bind,src="${output_dir}",dst=/output \
    --mount type=tmpfs,dst=/tmp \
    exercism/clojure-representer "${slug}" /solution /output
