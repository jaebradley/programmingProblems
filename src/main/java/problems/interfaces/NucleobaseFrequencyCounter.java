package problems.interfaces;

import problems.models.Nucleobase;

import java.util.Collection;
import java.util.Map;

public interface NucleobaseFrequencyCounter {
  Map<Nucleobase, Long> countNucleobaseFrequency(final Collection<Nucleobase> nucleobases);
}
