package problems.impl;

import problems.exceptions.NucleobaseReplacementNotPossibleException;
import problems.interfaces.NucleobaseFrequencyCounter;
import problems.interfaces.SteadyGeneGenerator;
import problems.models.Nucleobase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SteadyGeneGeneratorImpl implements SteadyGeneGenerator {
  private final NucleobaseFrequencyCounter nucleobaseFrequencyCounter;

  public SteadyGeneGeneratorImpl(final NucleobaseFrequencyCounter nucleobaseFrequencyCounter) {
    this.nucleobaseFrequencyCounter = nucleobaseFrequencyCounter;
  }

  @Override
  public boolean isReplacementPossible(final List<Nucleobase> nucleobases) {
    if (null == nucleobases) {
      throw new IllegalArgumentException("nucleobases must be non-null");
    }
    return nucleobases.size() > -1 && nucleobases.size() % Nucleobase.values().length == 0;
  }

  @Override
  public boolean isSteady(final List<Nucleobase> nucleobases) {
    Map<Nucleobase, Long> frequency = nucleobaseFrequencyCounter.countNucleobaseFrequency(nucleobases);
    if (frequency.keySet().size() != Nucleobase.values().length) {
      return false;
    }

    final long guanineValue = frequency.get(Nucleobase.GUANINE);
    for (final Nucleobase nucleobase : Nucleobase.values()) {
      if (guanineValue != frequency.get(nucleobase)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public Map<Nucleobase, Long> createNucleobaseReplacementFrequency(final List<Nucleobase> nucleobases) throws NucleobaseReplacementNotPossibleException {
    if (!isReplacementPossible(nucleobases)) {
      throw new NucleobaseReplacementNotPossibleException();
    }
    long avgFrequency = nucleobases.size() / Nucleobase.values().length;
    final Map<Nucleobase, Long> frequency = nucleobaseFrequencyCounter.countNucleobaseFrequency(nucleobases);
    final Map<Nucleobase, Long> replacementFrequency = new HashMap<>();
    for (Map.Entry<Nucleobase, Long> entry : frequency.entrySet()) {
      replacementFrequency.put(entry.getKey(), entry.getValue() - avgFrequency);
    }
    return replacementFrequency;
  }

  @Override
  public long identifyReplacementLength(final List<Nucleobase> nucleobases) throws NucleobaseReplacementNotPossibleException {
    if (isSteady(nucleobases)) {
      return 0L;
    }

    if (!isReplacementPossible(nucleobases)) {
      throw new NucleobaseReplacementNotPossibleException();
    }

    Map<Nucleobase, Long> replacementFrequency = createNucleobaseReplacementFrequency(nucleobases);

    if (replacementFrequency.keySet().size() > nucleobases.size()) {
      throw new NucleobaseReplacementNotPossibleException();
    }

    int startIndex = 0;
    int endIndex = replacementFrequency.keySet().size() - 1;
    while (endIndex < nucleobases.size()) {
      List<Nucleobase> replacementCandidate = nucleobases.subList(startIndex, endIndex + 1);
      Map<Nucleobase, Long> replacementCandidateFrequency = createNucleobaseReplacementFrequency(replacementCandidate);

      if (replacementCandidateFrequency == replacementFrequency) {
        return replacementCandidate.size();
      }

      endIndex++;
      startIndex++;
    }

    throw new NucleobaseReplacementNotPossibleException();
  }
}
