package problems.impl;

import problems.data.Node;
import problems.interfaces.LinkedList;

public class SinglyLinkedListImpl implements LinkedList {
  final Node head;
  int elementsCount;

  public SinglyLinkedListImpl(final Node head) {
    this.head = head;
    this.elementsCount = 0;
  }

  @Override
  public Node getHead() {
    return this.head;
  }

  @Override
  public int getElementsCount() {
    return this.elementsCount;
  }

  @Override
  public void add(final Object data) {
    Node currentNode = this.getHead();
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
    }

    currentNode.setNext(new Node(data, null));
    this.elementsCount++;
  }

  @Override
  public void addAtIndex(final Object data, final int index) {
    if (index > this.getElementsCount() || index < 0) {
      throw new RuntimeException("Invalid index value");
    }

    Node currentNode = this.getHead();
    Node nextNode = currentNode.getNext();
    int currentIndex = 0;
    while (currentNode.getNext() != null && currentIndex != index) {
      currentNode = currentNode.getNext();
      nextNode = currentNode.getNext();
      currentIndex++;
    }

    if (currentIndex == index) {
      Node nodeToInsert = new Node(data, nextNode);
      currentNode.setNext(nodeToInsert);
      return;
    }

    throw new RuntimeException("Invalid index value");
  }
}
