# clojure-representer

## Running

The Clojure representer runs using [babashka](https://github.com/babashka/babashka). 
To generate a normalized representation of a solution:

``` sh
./cli.clj <slug> <in-dir> <out-dir>
# Example: 
./cli.clj "armstrong-numbers" "resources/armstrong_numbers/0/" "resources/armstrong_numbers/0/"
```

`representation.txt` will be created in `out-dir` along with `mapping.json` containing the placeholder names.

## Testing the representer locally

To test 100 submissions:

``` sh
./test.clj
```

## Testing the representer in Docker

``` sh
./bin/run-tests-in-docker.sh
```