package problems.impl;

import org.junit.Test;
import problems.data.Node;

import static org.junit.Assert.*;

public class SinglyLinkedListImplTest {

  @Test
  public void testConstructor() {
    SinglyLinkedListImpl singlyLinkedList = new SinglyLinkedListImpl();
    assertNull(singlyLinkedList.getHead());
    assertNull(singlyLinkedList.getTail());
    assertEquals(singlyLinkedList.getElementsCount(), 0);
    assertEquals(singlyLinkedList.head, singlyLinkedList.getHead());
    assertEquals(singlyLinkedList.elementsCount, singlyLinkedList.getElementsCount());
    assertEquals(singlyLinkedList.tail, singlyLinkedList.getTail());
  }

  @Test
  public void testAdd() {
    String firstData = "first";
    int secondData = 2;
    Node firstDataNode = new Node(firstData, null);

    SinglyLinkedListImpl singlyLinkedList = new SinglyLinkedListImpl();
    singlyLinkedList.add(firstData);

    assertNotNull(singlyLinkedList.getHead());
    assertEquals(singlyLinkedList.getElementsCount(), 1);
    assertEquals(singlyLinkedList.getHead().getNext(), firstDataNode.getNext());
    assertEquals(singlyLinkedList.getHead().getData(), firstDataNode.getData());
    assertEquals(singlyLinkedList.getTail().getNext(), firstDataNode.getNext());
    assertEquals(singlyLinkedList.getTail().getData(), firstDataNode.getData());

    Node secondDataNode = new Node(secondData, null);
    Node updatedFirstDataNode = new Node(firstData, secondDataNode);

    singlyLinkedList.add(secondData);
    assertEquals(singlyLinkedList.getElementsCount(), 2);
    assertEquals(singlyLinkedList.getHead().getNext().getData(), secondDataNode.getData());
    assertEquals(singlyLinkedList.getHead().getNext().getNext(), secondDataNode.getNext());
    assertEquals(singlyLinkedList.getHead().getData(), updatedFirstDataNode.getData());
    assertEquals(singlyLinkedList.getTail().getNext(), secondDataNode.getNext());
    assertEquals(singlyLinkedList.getTail().getData(), secondDataNode.getData());
  }
}