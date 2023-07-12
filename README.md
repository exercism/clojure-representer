# clojure-representer

## Running a solution

The Clojure representer runs using [babashka](https://github.com/babashka/babashka). 
To generate a normalized representation of a solution:

``` sh
./bin/run.sh <slug> <in-dir> <out-dir>
# Example: 
./bin/run.sh "armstrong-numbers" "resources/armstrong_numbers/0/" "resources/armstrong_numbers/0/"
```

`representation.txt` will be created in `out-dir` along with `mapping.json` containing the placeholder names.

## Running a solution in Docker

``` sh
./bin/run-in-docker.sh <slug> <in-dir> <out-dir>
```

## Testing the representer locally

To test 1000 solutions:

``` sh
./bin/run-tests.sh
```

## Testing the representer in Docker

This is run in CI. It builds a container and runs `/bin/run-tests.sh` in it.

``` sh
./bin/run-tests-in-docker.sh
```