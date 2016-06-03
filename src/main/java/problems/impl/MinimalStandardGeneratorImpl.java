package problems.impl;

import problems.interfaces.MinimalStandardGenerator;

/**
 *
 * http://www.eternallyconfuzzled.com/tuts/algorithms/jsw_tut_rand.aspx
 * http://home.earthlink.net/~pfenerty/pi/schrages_method.html
 */

public class MinimalStandardGeneratorImpl implements MinimalStandardGenerator {
  private static final int MODULUS = 2147483647;
  private static final int MULTIPLIER = 48271;
  private static final double Q = MODULUS / MULTIPLIER;
  private static final int R = MODULUS % MULTIPLIER;
  private static int SEED = 1;

  @Override
  public int generateRandomNumber() {
    SEED = Double.valueOf(MULTIPLIER * (SEED / Q) - R * (SEED / Q)).intValue();
    if (SEED < 0) {
      return SEED += MODULUS;
    }
    return SEED;
  }
}
