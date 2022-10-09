#!/usr/bin/env sh

# Usage:
# ./bin/run.sh two-fer ~/folder/to/solution/input ~/folder/to/representer/output

# If any required arguments is missing, print the usage and exit
if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ]; then
    echo "usage: ./bin/run.sh exercise-slug path/to/solution/folder/ path/to/output/directory/"
    exit 1
fi

# Create the output directory if it doesn't exist
mkdir -p "$(realpath ${3%/})"

bb ./clojure_representer.clj "$@"
