package problems.impl;

import org.junit.Test;
import problems.interfaces.NucleobaseFrequencyCounter;
import problems.models.Nucleobase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NucleobaseFrequencyCounterImplTest {
  private final NucleobaseFrequencyCounter nucleobaseFrequencyCounter = new NucleobaseFrequencyCounterImpl();

  @Test(expected = IllegalArgumentException.class)
  public void testNullNucleobases() {
    nucleobaseFrequencyCounter.countNucleobaseFrequency(null);
  }

  @Test
  public void testEmptyNucleobases() {
    assertEquals(nucleobaseFrequencyCounter.countNucleobaseFrequency(new ArrayList<>()), new HashMap<Nucleobase, Long>());
  }

  @Test
  public void testNucleobases() {
    final ArrayList<Nucleobase> nucleobases = new ArrayList<>(Arrays.asList(Nucleobase.GUANINE, Nucleobase.ADENINE, Nucleobase.THYMINE, Nucleobase.GUANINE));
    final Map<Nucleobase, Long> expectedNucleobaseFrequency = new HashMap<>();
    expectedNucleobaseFrequency.put(Nucleobase.GUANINE, 2L);
    expectedNucleobaseFrequency.put(Nucleobase.ADENINE, 1L);
    expectedNucleobaseFrequency.put(Nucleobase.THYMINE, 1L);
    assertEquals(nucleobaseFrequencyCounter.countNucleobaseFrequency(nucleobases), expectedNucleobaseFrequency);
  }
}