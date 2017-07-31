package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleStackTest {

  @Test
  public void itShouldThrowWhenPeekingEmptyStack() {
    final SimpleStack<Integer> stack = new SimpleStack<>();
    try {
      stack.peek();
    } catch (Exception e) {
      // expected
    }
  }

  @Test
  public void itShouldUpdateHeadAfterPushing() {
    final Integer value = 1;
    final SimpleStack<Integer> stack = new SimpleStack<>();
    stack.push(value);
    assertEquals(value, stack.peek());
  }

  @Test
  public void itShouldThrowWhenPoppingEmptyStack() {
    final SimpleStack<Integer> stack = new SimpleStack<>();
    try {
      stack.pop();
    } catch (Exception e) {
      // expected
    }
  }

  @Test
  public void itShouldRemoveHeadWhenPopping() {
    final Integer value = 1;
    final SimpleStack<Integer> stack = new SimpleStack<>();
    stack.push(value);

    assertEquals(value, stack.peek());

    stack.pop();
  }
}