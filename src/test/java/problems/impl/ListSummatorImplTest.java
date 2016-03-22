package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.ListSummator;

public class ListSummatorImplTest {

  private final ListSummator listSummator = new ListSummatorImpl();

  @Test
  public void itShouldSumSuccessfully() {
    final List<Integer> emptyList = new ArrayList<>();
    final List<Integer> nonEmptyList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    Assert.assertEquals(listSummator.sumList(emptyList), 0);
    Assert.assertEquals(listSummator.sumList(nonEmptyList), 10);
  }
}
