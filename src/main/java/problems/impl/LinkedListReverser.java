package problems.impl;

public class LinkedListReverser {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next;

        while (current.next != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        current.next = previous;
        return current;
    }
}
