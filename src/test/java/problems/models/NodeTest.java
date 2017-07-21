package problems.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
  final int data = 1;
  final Node<Integer> previous = null;
  final Node<Integer> node = new Node<>(data, previous);

  @Test
  public void itShouldReturnAValidNodeInstance() {
    assertEquals(Integer.valueOf(data), node.data);
    assertNull(node.previous);
  }

  @Test
  public void itShouldReturnData() {
    assertEquals(Integer.valueOf(data), node.getData());
  }

  @Test
  public void itShouldReturnPrevious() {
    assertNull(node.getPrevious());
  }
}