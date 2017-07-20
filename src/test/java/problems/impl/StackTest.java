package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
  @Test
  public void itShouldReturnHeadWhenPeeking() {
    final Stack<Integer> stack = new Stack<>();
    assertNull(stack.peek());
  }

  @Test
  public void itShouldUpdateHeadAfterPushing() {
    final Integer value = 1;
    final Stack<Integer> stack = new Stack<>();
    stack.push(value);
    assertEquals(value, stack.peek().getData());
    assertNull(stack.peek().getPrevious());
  }

  @Test
  public void itShouldThrowWhenPoppingEmptyStack() {
    final Stack<Integer> stack = new Stack<>();
    try {
      stack.pop();
    } catch (Exception e) {
      // expected
    }
  }

  @Test
  public void itShouldRemoveHeadWhenPopping() {
    final Integer value = 1;
    final Stack<Integer> stack = new Stack<>();
    stack.push(value);

    assertEquals(value, stack.peek().getData());
    assertNull(stack.peek().getPrevious());

    stack.pop();
    assertNull(stack.peek());
  }
}