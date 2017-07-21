## Problem

Create an algorithm to output a fair die roll (values between `1` and `6`, inclusive),
given a function that outputs the outcome of a fair coin toss (`0` or `1`).

## Approach

The idea here is to use three coin flips to generate the binary values from `000` to `111` (`0` to `7` in Base 10).
Then, ignore the values `110` (`6`) and `111` (`7`) so that we are only considering the binary values from `000` to
`101` (`0` to `5` in Base 10).

Note that `110` and `111` will be the only values that start with two `1`s, so any time the first two rolls start with
two `1`s we know to ignore the previous values and try rolling again.

If the first two rolls do not start with two `1`s, then we roll a third time, concatenate the three values to form our
binary representation and then convert the binary value into Base 10 (while adding one since the value will be `0-5`
and we want `1-6`).

## Implementation Discussion

Most of my questions might be coming from the over-engineering part of my brain.

That part of my brain basically wants to create `Enum`s for coin toss outcomes and for the die roll outcomes
(`DieRoll.ONE`, `DieRoll.TWO`, etc.).

Partly because it feels kind've weird that `getCoinToss` returns an `int` when it really represents a binary
(i.e. `boolean`) value.
Is it better to return a `boolean` here? I thought about it, but ultimately ended up not doing so because I would've
had to convert the `boolean`s into `1`s and `0`s when generating the `String` binary representation.

Same thing (but to a lesser extent) with `generateValue` - the possible values are really 1-6.


## Implementation

<!-- language: lang-java -->

    public class RandomDieValueGenerator {
        public static int generateValue() {
            int firstCoinToss = RandomDieValueGenerator.getCoinToss();
            int secondCoinToss = RandomDieValueGenerator.getCoinToss();

            if (firstCoinToss * secondCoinToss == 1) {
              return RandomDieValueGenerator.generateValue();
            }

            String binaryRepresentation = String.valueOf(firstCoinToss) + secondCoinToss + RandomDieValueGenerator.getCoinToss();
            return Integer.parseInt(binaryRepresentation, 2) + 1;
        }

        private static int getCoinToss() {
            return Math.toIntExact(Math.round(Math.random()));
        }
    }
