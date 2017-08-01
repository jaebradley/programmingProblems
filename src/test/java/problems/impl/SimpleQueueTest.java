package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleQueueTest {
    String first = "first";
    String second = "second";

    @Test
    public void itShouldEnqueue() {
        SimpleQueue<String> queue = new SimpleQueue<>();
        queue.enqueue(first);
        assertFalse(queue.isEmpty());
        assertEquals(first, queue.peek());
    }

    @Test
    public void itShouldEnqueueAndDequeue() {
        SimpleQueue<String> queue = new SimpleQueue<>();
        queue.enqueue(first);
        queue.enqueue(second);

        assertEquals(first, queue.peek());

        queue.dequeue();

        assertEquals(second, queue.peek());

        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void itShouldThrowWhenPeekingEmptyQueue() {
        SimpleQueue<String> queue = new SimpleQueue<>();
        try {
            queue.peek();
        } catch (IllegalStateException e) {
            // expected
        }
    }

    @Test
    public void itShouldThrowWhenDequeueingEmptyQueue() {
        SimpleQueue<String> queue = new SimpleQueue<>();
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            // expected
        }
    }
}