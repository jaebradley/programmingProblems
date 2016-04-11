package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.SubstringsGenerator;

import java.util.*;

public class SubstringsGeneratorImplTest {

  private final SubstringsGenerator substringsGenerator = new SubstringsGeneratorImpl();
  private final String test = "JAE";
  private final String empty = "   ";
  final Set<String> expectedLengthOneSubstrings = new HashSet<>(
          Arrays.asList("J", "A", "E")
  );
  final Set<String> expectedLengthTwoSubstrings = new HashSet<>(
          Arrays.asList("JA", "AE")
  );
  final Set<String> expectedLengthThreeSubstrings = new HashSet<>(
          Arrays.asList("JAE")
  );

  final Set<String> expectedLengthOneEmptySubstrings = new HashSet<>(
          Arrays.asList(" ")
  );
  final Set<String> expectedLengthTwoEmptySubstrings = new HashSet<>(
          Arrays.asList("  ")
  );
  final Set<String> expectedLengthThreeEmptySubstrings = new HashSet<>(
          Arrays.asList("   ")
  );

  @Test
  public void itShouldGenerateSubstringsForNonNegativeLength() {
    Assert.assertEquals(substringsGenerator.generateSubstrings("", 0), new HashSet<String>());
    Assert.assertEquals(substringsGenerator.generateSubstrings(test, 0), new HashSet<String>());

    Assert.assertEquals(substringsGenerator.generateSubstrings(test, 1), expectedLengthOneSubstrings);
    Assert.assertEquals(substringsGenerator.generateSubstrings(test, 2), expectedLengthTwoSubstrings);
    Assert.assertEquals(substringsGenerator.generateSubstrings(test, 3), expectedLengthThreeSubstrings);

    Assert.assertEquals(substringsGenerator.generateSubstrings(empty, 1), expectedLengthOneEmptySubstrings);
    Assert.assertEquals(substringsGenerator.generateSubstrings(empty, 2), expectedLengthTwoEmptySubstrings);
    Assert.assertEquals(substringsGenerator.generateSubstrings(empty, 3), expectedLengthThreeEmptySubstrings);
  }

  @Test
  public void itShouldThrowExceptions() {
    try {
      substringsGenerator.generateSubstrings(test, test.length() + 1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      substringsGenerator.generateSubstrings(test, -1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void itShouldGenerateLengthSortedSubstrings() {
    Assert.assertEquals(substringsGenerator.generateLengthSortedSubstrings(""), new HashMap<>());
    final Map<Integer, Set<String>> lengthSortedSubstrings = new HashMap<>();
    lengthSortedSubstrings.put(1, expectedLengthOneSubstrings);
    lengthSortedSubstrings.put(2, expectedLengthTwoSubstrings);
    lengthSortedSubstrings.put(3, expectedLengthThreeSubstrings);
    Assert.assertEquals(substringsGenerator.generateLengthSortedSubstrings(test), lengthSortedSubstrings);

    final Map<Integer, Set<String>> lengthSortedSubstringsEmpty = new HashMap<>();
    lengthSortedSubstringsEmpty.put(1, expectedLengthOneEmptySubstrings);
    lengthSortedSubstringsEmpty.put(2, expectedLengthTwoEmptySubstrings);
    lengthSortedSubstringsEmpty.put(3, expectedLengthThreeEmptySubstrings);
    Assert.assertEquals(substringsGenerator.generateLengthSortedSubstrings(empty), lengthSortedSubstringsEmpty);
  }

}