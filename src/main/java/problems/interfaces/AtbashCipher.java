package problems.interfaces;

import problems.utils.AlphabetCase;

public interface AtbashCipher {
  char applyCipher(final char c);

  AlphabetCase identifyCase(final char c);
}
