## Purpose

Implement a [`Stack`](https://en.wikipedia.org/wiki/Stack_(abstract_data_type)) with `push`, `pop`, and `peek` methods.

* The `push` method should add an element to the "top" of the `Stack`.
* The `pop` method should remove the "top" element from the `Stack`.
* The `peek` method should return the "top" element of the `Stack`.

## Approach

I decided to create a `Node` class to represent the elements in a `Stack`. The `Node` class would have a `data` field
and a `previous` field that would reference another `Node`. By having this `previous` field one can "chain" `Node`s together.

For my `Stack` class, I decided to set the `head` (i.e. the `Node` at the "top" of the `Stack`) value to `null` on initialization.
I also decided to throw `Exception`s when calling `peek` or `pop` for an empty `Stack` (i.e. when the `head` value is `null`).

I could see an argument to not throw `Exception`s but rather return `null` for `peek` or nothing for `pop` (since it's `void`).
However, `null` is a valid value for an `Object`, and since a `Stack` is made up of `Object`s, I think returning
`null` when calling `peek` for an empty `Stack` could be confusing.


<!-- language: lang-java -->

    public class Node<T> {
      T data;
      Node<T> previous;

      public Node(T data, Node<T> previous) {
        this.data = data;
        this.previous = previous;
      }

      public T getData() {
        return data;
      }

      public Node<T> getPrevious() {
        return previous;
      }
    }

    public class Stack<T> {
      Node<T> head = null;

      public Stack() {
      }

      public T peek() {
        if (this.head == null) {
          throw new RuntimeException("Unable to peek element for an empty stack");
        }

        return this.head.getData();
      }

      public void push(T data) {
        this.head = new Node<>(data, this.head);
      }

      public void pop() {
        if (this.head == null) {
          throw new RuntimeException("Unable to remove element from an empty stack");
        }

        this.head = this.head.getPrevious();
      }
