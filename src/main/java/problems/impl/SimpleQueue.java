package problems.impl;

public class SimpleQueue<T> {
    private Node<T> head;

    private class Node<E> {
        private final E data;
        private Node<E> previous;

        public Node(E data, Node<E> previous) {
            this.data = data;
            this.previous = previous;
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(T data) {
        Node<T> currentNode = this.head;
        Node<T> nodeToInsert = new Node<>(data, null);

        if (this.isEmpty()) {
            this.head = nodeToInsert;
        } else {
            while (currentNode.previous != null) {
                currentNode = currentNode.previous;
            }

            currentNode.previous = nodeToInsert;
        }
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
