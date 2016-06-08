package problems.impl;

import problems.interfaces.NucleobaseFrequencyCounter;
import problems.models.Nucleobase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NucleobaseFrequencyCounterImpl implements NucleobaseFrequencyCounter {
  @Override
  public Map<Nucleobase, Long> countNucleobaseFrequency(final Collection<Nucleobase> nucleobases) {
    if (null == nucleobases) {
      throw new IllegalArgumentException("nucleobases must be non-null");
    }
    final Map<Nucleobase, Long> frequency = new HashMap<>();
    for (final Nucleobase nucleobase : nucleobases) {
      final Long lookupValue = frequency.get(nucleobase);
      if (null == lookupValue) {
        frequency.put(nucleobase, 1L);
      } else {
        frequency.put(nucleobase, lookupValue + 1);
      }
    }
    return frequency;
  }
}
