package problems.impl;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class TwoStackQueueTest {

    private final String firstValue = "firstValue";
    private final String secondValue = "secondValue";
    private final String thirdValue = "thirdValue";

    @Test
    public void itShouldEnqueueElement() {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        queue.enqueue(firstValue);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void itShouldEnqueueAndDequeueElements() {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        queue.enqueue(firstValue);
        queue.enqueue(secondValue);
        assertEquals(firstValue, queue.dequeue());
        assertEquals(secondValue, queue.dequeue());
    }

    @Test
    public void itShouldEnqueueAndDequeueElementsTwice() {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        queue.enqueue(firstValue);
        queue.enqueue(secondValue);
        assertEquals(firstValue, queue.dequeue());

        queue.enqueue(thirdValue);
        assertEquals(secondValue, queue.dequeue());
        assertEquals(thirdValue, queue.dequeue());
    }

    @Test
    public void itShouldThrowWhenDequeueingEmptyQueue() {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            // expected
        }
    }

    @Test
    public void itShouldEnqueueAndPeekElements() {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        queue.enqueue(firstValue);
        queue.enqueue(secondValue);
        assertEquals(firstValue, queue.peek());

        queue.dequeue();
        assertEquals(secondValue, queue.peek());
    }

    @Test
    public void itShouldEnqueueAndPeekElementsTwice() {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        queue.enqueue(firstValue);
        queue.enqueue(secondValue);
        assertEquals(firstValue, queue.peek());

        queue.dequeue();

        queue.enqueue(thirdValue);
        assertEquals(secondValue, queue.peek());

        queue.dequeue();
        assertEquals(thirdValue, queue.peek());
    }

    @Test
    public void itShouldThrowWhenPeekingEmptyQueue() {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        try {
            queue.peek();
        } catch (NoSuchElementException e) {
            // expected
        }
    }

    @Test
    public void itShouldBeEmptyForInstantiatedQueue() {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void itShouldBeEmptyAfterEnqueueingAndDequeueing() {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        queue.enqueue(firstValue);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}