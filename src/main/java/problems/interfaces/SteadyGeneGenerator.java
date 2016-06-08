package problems.interfaces;

import problems.exceptions.NucleobaseReplacementNotPossibleException;
import problems.models.Nucleobase;

import java.util.List;
import java.util.Map;

public interface SteadyGeneGenerator {
  boolean isReplacementPossible(final List<Nucleobase> nucleobases);

  boolean isSteady(final List<Nucleobase> nucleobases);

  Map<Nucleobase, Long> createNucleobaseReplacementFrequency(final List<Nucleobase> nucleobases) throws NucleobaseReplacementNotPossibleException;

  long identifyReplacementLength(final List<Nucleobase> nucleobases) throws NucleobaseReplacementNotPossibleException;
}
