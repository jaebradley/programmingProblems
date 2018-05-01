## Purpose

I've never implemented a `DoublyLinkedList` and thought it would be a good data structure exercise. I tried using outside
resources as little as possible. I also tried to keep things as simple as possible

## Discussion

The `DoublyLinkedList` is made up of a `Node` `head`, a `Node` `tail`, and an `int` `length`. I did not genericize the
API to keep things simple - the API only deals with `int` values.

The API is

* `getHead` - gets the `Node` at the `head` of the linked list in `O(1)`
* `getTail` - gets the `Node` at the `tail` of the linked list in `O(1)`
* `getLength` - gets the `length` of the linked list in `O(1)`
* `isEmpty` - convenience method; returns `true` if `length` is `0` and `false` otherwise in `O(1)`
* `insertAtHead` - adds the input value at the `head` of the linked list in `O(1)`
* `insertAtTail` - adds the input value at the `tail` of the linked list in `O(1)`
* `insertAt` - adds the input value at some index in the linked list in `O(n)`
* `removeFirstOccurrence` - removes the first occurrence of the input value (if it exists in list) in `O(n)`
* `removeAt` - removes the node at the specified index in the linked list in `O(n)`
* `removeHead` - removes the node at the `head` of the linked list in `O(1)`
* `removeTail` - removes the node at the `tail` of the linked list in `O(1)`

Things I can improve:

* When inserting at / removing at a particular index, I could speed up execution time by picking to start
  at the beginning or end of the list based on which the index is closest to
* I tried adding a bunch of test cases, but I could have easily missed a case
* Is my API sane / reasonable / did I miss implementing any obvious methods?

## Implementation

<!-- language:lang-java --!>

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