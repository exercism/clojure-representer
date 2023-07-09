# clojure-representer

## Running

To generate a normalized representation of a solution:

``` sh
bb -m representer.cli <slug> <in-dir> <out-dir>
# Example: 
bb -m representer.cli "armstrong-numbers" "resources/armstrong_numbers/0/" "resources/armstrong_numbers/0/"
```

`representation.txt` will be created in `out-dir` along with `mapping.json` containing the placeholder names.

## Testing the representer locally

Requires [babashka](https://github.com/babashka/babashka). To test 100 submissions:

``` sh
bb -m representer.test
```

## Testing the representer in Docker

``` sh
./bin/run-tests-in-docker.sh
```