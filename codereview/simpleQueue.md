## Purpose

As I've never implemented a queue, I decided to create a very simple implementation using a linked list approach.

## Discussion

I create a singly linked list, using a `private` `Node` `class` that references some `data` and a `previous` `Node`,
that will be used in my `SimpleQueue` class.

When enqueuing data, I check to see if the linked list is empty or not (by checking to see if the `head` of the list is `null`).
If it's empty, point the `head` to a newly-created `Node` with the input data. If the list is not empty, I iterate through
the list until I reach the end (i.e. the `previous` `Node` is `null`) and then I insert a newly-created `Node`.

When dequeuing, I throw an `IllegalStateException` if the queue is empty. If the queue is not empty, I set the new head of
the queue to be the old head's `previous` value, and return the old head's `data` value.

## Implementation

<!-- language:lang-java --!>

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