## Purpose
I recently came across this interview question
> Implement a queue with 2 `Stack`s. Your queue should have an `enqueue` and a `dequeue` function.
Assume you already have a `Stack` implementation

## Discussion
The way I thought about this problem is that one `Stack` would keep track of the input elements (i.e. what's been enqueued)
and at some point, this `Stack` would transfer its elements to the second `Stack`.

By `pop`ping the results of the first `Stack` onto the the second `Stack`, the second `Stack` now represents the elements, ordered
by when they were first inputted into the queue.

By `pop`ping off this second `Stack`, elements are now dequeued in the order that they were enqueued.

What happens in the case where some elements are enqueued, an element is dequeued, and then a bunch of elements are enqueued?
When does the transferring of elements from the first `Stack` to the second take place?

In order to preserve the order of elements, the transfer of elements doesn't take place until the second `Stack` is empty.
Thus, when dequeueing, first check that the second `Stack` is empty. If it isn't, then transfer the elements from the first `Stack`
to the second.

For example, take the case where `1`, `2`, and `3` are enqueued.
1. The first `Stack` looks like this: `| 1 | 2 | 3|`.
2. The second `Stack` is empty.
3. When `dequeue` is called, `3`, `2`, and `1` are popped off the first `Stack` in that order.
4. Now the first `Stack` is empty
5. The second `Stack` looks like `| 3 | 2 | 1 |`.
6. Since `dequeue` was called, we `pop` the second `Stack` (bye bye `1`) and now it looks like `| 3 | 2 |`.
7. Now suppose `4` is enqueued.
8. The first `Stack` is no longer empty - it looks like: `| 4 |`.
9. Now suppose `dequeue` is called again - we can't immediately transfer `4` from the first `Stack` to the second since
   the second `Stack` would look like `| 3 | 2 | 4 |`.
10. Thus, we have to wait until all elements have been popped off the second `Stack` to transfer the elements from the first `Stack`.


## Implementation

<!-- language: lang-java --!>

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