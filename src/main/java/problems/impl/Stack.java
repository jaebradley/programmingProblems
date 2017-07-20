package problems.impl;

import problems.models.Node;

public class Stack<T> {
  Node<T> head = null;

  public Stack() {
  }

  public Node<T> peek() {
    return this.head;
  }

  public void push(T data) {
    this.head = new Node<>(data, this.head);
  }

  public void pop() {
    if (this.head == null) {
      throw new RuntimeException("Unable to remove element from an empty stack");
    }

    this.head = this.head.getPrevious();
  }
}
