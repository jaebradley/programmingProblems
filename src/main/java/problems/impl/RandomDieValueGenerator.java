package problems.impl;

/**
 * Create an algorithm to output a die roll(a random number from 1 to 6), given a function that outputs a coin toss(a random 0 or 1).
 * Each possible outcome should be equally likely.
 *
 * The idea here is to use three coin flips to generate the binary values from 000 to 111 (0 to 7 in Base 10).
 * Then, ignore the values 110 (6) and 111 (7) so that we are only considering the binary values from 000 to 101 (0 to 5 in Base 10).
 *
 * Note that 110 and 111 will be the only values that start with two 1s, so any time the first two rolls start with two 1s
 * we know to ignore the previous values and try rolling again.
 *
 * If the first two rolls do not start with two 1s, then we roll a third time, concatenate the three values to form our binary representation
 * and then convert the binary value into Base 10 (while adding one since the value will be 0-5 and we want 1-6).
 */

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
