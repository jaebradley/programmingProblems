package problems.impl;

import java.util.NoSuchElementException;
import java.util.Stack;

public class TwoStackQueue<T> {
    private final Stack<T> input = new Stack<>();
    private final Stack<T> output = new Stack<>();

    public void enqueue(T data) {
        input.add(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Unable to dequeue on empty queue");
        }

        transfer();

        return output.pop();
    }

    public boolean isEmpty() {
        return input.empty() && output.empty();
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Unable to peek on empty queue");
        }

        transfer();

        return output.peek();
    }

    private void transfer() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
    }
}
