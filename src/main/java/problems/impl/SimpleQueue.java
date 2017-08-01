package problems.impl;

/**
 * https://codereview.stackexchange.com/questions/171699/simple-queue-implementation/171710#171710
 * @param <T>
 */

public class SimpleQueue<T> {
    private Node<T> head;
    private Node<T> tail;

    private class Node<E> {
        private final E data;
        private Node<E> previous;

        public Node(E data, Node<E> previous) {
            this.data = data;
            this.previous = previous;
        }
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public void enqueue(T data) {
        Node<T> nodeToInsert = new Node<>(data, null);

        if (isEmpty()) {
            this.head = nodeToInsert;
        } else {
            this.tail.previous = nodeToInsert;
        }

        this.tail = nodeToInsert;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Unable to dequeue from empty queue");
        }

        Node<T> currentNode = this.head;
        this.head = currentNode.previous;

        return currentNode.data;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Unable to peek empty queue");
        }

        return this.head.data;
    }
}
