package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.impl.DoublyLinkedList.*;

public class DoublyLinkedListTest {

    @Test
    public void insertAtHead() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(1);
        assertEquals(1, list.getLength());
        Node head = list.getHead();
        assertEquals(1, head.getValue());
        assertNull(head.getNext());
        assertNull(head.getPrevious());
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void insertAtHeadTwice() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(2);
        list.insertAtHead(1);
        assertEquals(2, list.getLength());
        assertEquals(1, list.getHead().getValue());
        assertEquals(2, list.getTail().getValue());
    }

    @Test
    public void insertAtTail() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtTail(1);
        assertEquals(1, list.getLength());
        Node head = list.getHead();
        assertEquals(1, head.getValue());
        assertNull(head.getNext());
        assertNull(head.getPrevious());
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void insertAtTailTwice() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        assertEquals(2, list.getLength());
        assertEquals(1, list.getHead().getValue());
        assertEquals(2, list.getTail().getValue());
    }

    @Test
    public void insertAtZero() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAt(1, 0);
        assertEquals(1, list.getLength());
        Node head = list.getHead();
        assertEquals(1, head.getValue());
        assertNull(head.getNext());
        assertNull(head.getPrevious());
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void insertAtIndexAtEndOfList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAt(1, 0);
        assertEquals(1, list.getLength());
        Node head = list.getHead();
        assertEquals(1, head.getValue());
        assertNull(head.getNext());
        assertNull(head.getPrevious());
        assertEquals(list.getHead(), list.getTail());
        list.insertAt(2, 1);
        assertEquals(2, list.getLength());
        assertEquals(1, list.getHead().getValue());
        assertEquals(2, list.getTail().getValue());
    }

    @Test
    public void insertAtOneThrows() {
        DoublyLinkedList list = new DoublyLinkedList();
        try {
            list.insertAt(1, 1);
        } catch (Exception e) {
            // expected
            return;
        }
        fail();
    }

    @Test
    public void insertAtNegativeIndexThrows() {
        DoublyLinkedList list = new DoublyLinkedList();
        try {
            list.insertAt(1, -1);
        } catch (Exception e) {
            // expected
            return;
        }
        fail();
    }

    @Test
    public void isEmpty() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void isNotEmpty() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void removeFirstOccurrenceEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertTrue(list.isEmpty());
        list.removeFirstOccurrence(1);
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeFirstOccurrenceRemovesElement() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(1);
        assertFalse(list.isEmpty());
        list.removeFirstOccurrence(1);
        assertTrue(list.isEmpty());
        assertNull(list.getHead());
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void removesOnlyFirstOccurrenceLeavesOthers() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(1);
        assertFalse(list.isEmpty());
        list.removeFirstOccurrence(1);
        assertFalse(list.isEmpty());
        assertEquals(2, list.getLength());
        assertEquals(2, list.getHead().getValue());
        assertEquals(1, list.getTail().getValue());
    }

    @Test
    public void removeAtForEmptyListThrows() {
        DoublyLinkedList list = new DoublyLinkedList();
        try {
            list.removeAt(0);
        } catch (Exception e) {
            // expected
            return;
        }

        fail();
    }

    @Test
    public void removeAtNegativeIndexThrows() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(1);
        try {
            list.removeAt(-1);
        } catch (Exception e) {
            // expected
            return;
        }

        fail();
    }

    @Test
    public void removeAtZeroForSingleElementList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(1);
        assertEquals(1, list.getLength());
        assertEquals(1, list.getHead().getValue());
        assertEquals(list.getHead(), list.getTail());
        list.removeAt(0);
        assertEquals(0, list.getLength());
        assertNull(list.getHead());
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void removeHeadForSingleElementList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(1);
        list.removeHead();
        assertEquals(0, list.getLength());
        assertNull(list.getHead());
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void removeHeadForTwoElementList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.removeHead();
        assertEquals(1, list.getLength());
        assertEquals(2, list.getHead().getValue());
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void removeTailForSingleElementList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(1);
        list.removeTail();
        assertEquals(0, list.getLength());
        assertNull(list.getHead());
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void removeTailForTwoElementList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.removeTail();
        assertEquals(1, list.getLength());
        assertEquals(1, list.getHead().getValue());
        assertEquals(list.getHead(), list.getTail());
    }
}