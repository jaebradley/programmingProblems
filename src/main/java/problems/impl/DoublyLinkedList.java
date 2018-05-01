package problems.impl;

public class DoublyLinkedList {
    public static class Node {
        private Node previous;
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getPrevious() {
            return previous;
        }

        public Node getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void insertAtHead(int value) {
        insertNode(null, new Node(value), head);
    }

    public void insertAtTail(int value) {
        insertNode(tail, new Node(value), null);
    }

    public void insertAt(int value, int index) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("index of " + index + " is out of bounds");
        }

        Node node = new Node(value);
        Node previousNode = null;
        Node currentNodeAtIndex = head;
        for (int i = 0; i < index; i++) {
            previousNode = currentNodeAtIndex;
            currentNodeAtIndex = currentNodeAtIndex.next;
        }
        insertNode(previousNode, node, currentNodeAtIndex);
    }

    public void removeFirstOccurrence(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                removeNode(currentNode);
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public void removeAt(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("index of " + index + " is out of bounds");
        }

        Node currentNodeAtIndex = head;
        for (int i = 0; i < index; i++) {
            currentNodeAtIndex = currentNodeAtIndex.next;
        }

        removeNode(currentNodeAtIndex);
    }

    public void removeHead() {
        removeNode(head);
    }

    public void removeTail() {
        removeNode(tail);
    }

    private void removeNode(Node node) {
        if (node.previous == null) {
            head = node.next;
        }

        if (node.next == null) {
            tail = node.previous;
        }

        if (node.previous != null) {
            node.previous.next = node.next;
        }

        if (node.next != null) {
            node.next.previous = node.previous;
        }

        length--;
    }

    private void insertNode(Node nodeBefore, Node node, Node nodeAfter) {
        node.next = nodeAfter;
        node.previous = nodeBefore;

        if (nodeBefore == null) {
            head = node;
        }

        if (nodeAfter == null) {
            tail = node;
        }

        if (nodeBefore != null) {
            nodeBefore.next = node;
        }

        if (nodeAfter != null) {
            nodeAfter.previous = node;
        }

        length++;
    }
}
