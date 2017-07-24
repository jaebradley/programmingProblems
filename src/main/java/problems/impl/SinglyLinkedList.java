package problems.impl;

public class SinglyLinkedList {

    public class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    Node tail = null;
    int size = 0;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public Node getTail() {
        return tail;
    }

    public void add(Object data) {
        Node newNext = new Node(data, null);

        if (this.isEmpty()) {
            this.tail = newNext;
        } else {
            Node currentNode = this.getTail();
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNext);
        }

        this.size++;
    }

    public void remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Unable to remove element from empty list");
        }

        Node previousNode = this.getTail();
        Node currentNode = previousNode.getNext();

        while (currentNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        previousNode.setNext(null);
        this.size--;
    }

    public void addAtIndex(Object data, int index) {
        if (index > this.getSize() || index < 0) {
            throw new IllegalArgumentException("Invalid index value");
        }

        Node currentNode = this.getTail();
        int currentIndex = 0;
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            Node nodeToInsert = new Node(data, null);
        }

        if (currentIndex == index) {
            Node nodeToInsert = new Node(data, nextNode);
            currentNode.setNext(nodeToInsert);
            this.size++;
        }
    }

}