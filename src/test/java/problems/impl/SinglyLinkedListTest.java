package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    private String first = "first";
    private String second = "second";
    private String third = "third";

    @Test
    public void testConstructor() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.getHead());
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }

    @Test
    public void itShouldThrowWhenAddingValueToOutOfBoundsIndexValue() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        try {
            list.addAtIndex(first, 1);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void itShouldThrowWhenAddingValueToNegativeIndex() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        try {
            list.addAtIndex(first, -1);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void itShouldAddAtIndex() {
        SinglyLinkedList.Node<String> expected = new SinglyLinkedList.Node<>(first, null);
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addAtIndex(first, 0);
        assertFalse(list.isEmpty());
        assertEquals(1, list.getSize());
        assertEquals(expected, list.getHead());
    }

    @Test
    public void itShouldAddAtSameIndexTwice() {
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<>(first, null);
        SinglyLinkedList.Node<String> expected = new SinglyLinkedList.Node<>(second, secondNode);
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addAtIndex(first, 0);
        list.addAtIndex(second, 0);
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(expected, list.getHead());
    }

    @Test
    public void itShouldAddAtLastIndex() {
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<>(second, null);
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<>(first, secondNode);
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addAtIndex(first, 0);
        list.addAtIndex(second, 1);
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(firstNode, list.getHead());
    }

    @Test
    public void itShouldAddANodeBetweenTwoNodes() {
        SinglyLinkedList.Node<String> thirdNode = new SinglyLinkedList.Node<>(third, null);
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<>(second, thirdNode);
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<>(first, secondNode);
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addAtIndex(first, 0);
        list.addAtIndex(third, 1);
        list.addAtIndex(second, 1);
        assertFalse(list.isEmpty());
        assertEquals(3, list.getSize());
        assertEquals(firstNode, list.getHead());
    }

    @Test
    public void itShouldFetchValue() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addAtIndex(first, 0);
        list.addAtIndex(second, 1);
        assertEquals(second, list.get(1));
    }

    @Test
    public void itShouldThrowWhenFetchingAnOutOfBoundsIndexValue() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        try {
            list.get(1);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void itShouldThrowWhenFetchingANegativeIndexValue() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        try {
            list.get(-1);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void itShouldThrowWhenRemovingFromEmptyList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        try {
            list.removeAtIndex(0);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void itShouldThrowWhenRemovingFromNegativeIndex() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        try {
            list.removeAtIndex(-1);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void itShouldRemoveValueFromList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addAtIndex(first, 0);
        list.removeAtIndex(0);

        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
    }

    @Test
    public void itShouldRemoveNodeBetweenTwoNodes() {
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<>(third, null);
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<>(first, secondNode);

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addAtIndex(first, 0);
        list.addAtIndex(second, 1);
        list.addAtIndex(third, 2);

        list.removeAtIndex(1);

        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(firstNode, list.getHead());
    }

    @Test
    public void itShouldRemoveLastNode() {
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<>(second, null);
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<>(first, secondNode);

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addAtIndex(first, 0);
        list.addAtIndex(second, 1);
        list.addAtIndex(third, 2);

        list.removeAtIndex(2);

        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(firstNode, list.getHead());
    }
}