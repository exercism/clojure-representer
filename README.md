# clojure-representer

## Running

To generate a normalized representation of a solution:

``` sh
./bin/run.sh slug in-dir/ out-dir/
```

`representation.txt` will be created in `out-dir` along with `mapping.json` containing the placeholder names.

## Testing the representer locally

Requires [babashka](https://github.com/babashka/babashka)

``` sh
bb ./test.clj
```

## Testing the representer in Docker

``` sh
./bin/run-tests-in-docker.sh
```