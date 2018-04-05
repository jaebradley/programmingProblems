package problems.impl;

import org.junit.Test;
import problems.impl.LinkedListReverser.ListNode;

import static org.junit.Assert.*;

public class LinkedListReverserTest {

    @Test
    public void nullForEmptyLinkedList() {
        assertNull(LinkedListReverser.reverse(null));
    }

    @Test
    public void headForSingleValueList() {
        ListNode head = new ListNode(0);

        assertEquals(head, LinkedListReverser.reverse(head));
    }

    @Test
    public void reverseValues() {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = one;
        one.next = two;
        two.next = three;

        ListNode reversed = LinkedListReverser.reverse(head);

        assertEquals(3, reversed.val);
        assertEquals(2, reversed.next.val);
        assertEquals(1, reversed.next.next.val);
        assertEquals(0, reversed.next.next.next.val);
        assertNull(reversed.next.next.next.next);
    }
}