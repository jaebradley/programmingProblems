package problems.impl;

/**
 * Very basic singly linked list implementation
 *
 * https://codereview.stackexchange.com/questions/171268/basic-singly-linked-list-implementation
 *
 * @param <T>
 */

public class SinglyLinkedList<T> {

    private static class Node<E> {
        private final E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public void add(T data) {
        this.addAtIndex(data, this.size);
    }

    public void remove() {
        this.removeAtIndex(this.size - 1);
    }

    public void addAtIndex(T data, int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Invalid index value: {}", index));
        }

        Node<T> currentNode = this.head;

        if (index == 0) {
            this.head = new Node<>(data, currentNode);
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            currentNode.next = new Node<>(data, currentNode.next);
        }

        this.size++;
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Invalid index value: {}", index));
        }

        Node<T> currentNode = this.head;

        if (index == 0) {
            this.head = currentNode.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            currentNode.next = (currentNode.next.next);
        }

        this.size--;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Invalid index value: {}", index));
        }

        Node<T> currentNode = this.head;

        int count = 0;
        while (count < index) {
            currentNode = currentNode.next;
            count++;
        }

        return currentNode.data;
    }

}