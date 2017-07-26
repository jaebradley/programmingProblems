package problems.impl;

import java.util.Objects;

public class SinglyLinkedList<T> {

    public static class Node<E> {
        private final E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return this.data;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.data, this.next);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Node)) {
                return false;
            }

            Node node = (Node) obj;

            return Objects.equals(this.data, node.data) &&
                    Objects.equals(this.next, node.next);
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

    public Node<T> getHead() {
        return this.head;
    }

    public void add(T data) {
        this.addAtIndex(data, this.size);
    }

    public void remove() {
        this.removeAtIndex(this.size - 1);
    }

    public void addAtIndex(T data, int index) {
        if (index > this.size || index < 0) {
            throw new IllegalArgumentException("Invalid index value");
        }

        Node<T> currentNode = this.head;

        if (index == 0) {
            this.head = new Node<>(data, currentNode);
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            Node<T> nextNode = new Node<>(data, currentNode.getNext());
            currentNode.setNext(nextNode);
        }

        this.size++;
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Invalid index value");
        }

        Node<T> currentNode = this.head;

        if (index == 0) {
            this.head = currentNode.getNext();
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            currentNode.setNext(currentNode.getNext().getNext());
        }

        this.size--;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Invalid index value");
        }

        Node<T> currentNode = this.head;

        int count = 0;
        while (count < index) {
            currentNode = currentNode.getNext();
            count++;
        }

        return currentNode.getData();
    }

}