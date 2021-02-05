package problems.impl;

import problems.exceptions.TransactionRolledbackException;

import java.util.Stack;

public class TransactionalStack<T> {
    private final Stack<T> stack = new Stack<>();
    private final Stack<TransactionEvent<T>> transactionEvents = new Stack<>();

    private static class TransactionEvent<E> {
        private enum Type {
            BEGIN,
            PUSH,
            POP
        }

        private final Type type;
        private final E value;

        public TransactionEvent(Type type, E value) {
            this.type = type;
            this.value = value;
        }
    }

    public void push(T value) {
        stack.push(value);

        if (!transactionEvents.isEmpty()) {
            transactionEvents.add(new TransactionEvent<>(TransactionEvent.Type.PUSH, value));
        }
    }

    public T pop() {
        validateNonEmptyStack();

        T value = stack.pop();

        if (!transactionEvents.isEmpty()) {
            transactionEvents.add(new TransactionEvent<>(TransactionEvent.Type.POP, value));
    }

        return value;
    }

    public int getSize() {
        return stack.size();
    }

    public T peek() {
        validateNonEmptyStack();

        return stack.peek();
    }

    public void begin() {
        transactionEvents.add(new TransactionEvent<>(TransactionEvent.Type.BEGIN, null));
    }

    public void commit() {
        while (!transactionEvents.empty()) {
            TransactionEvent<T> transactionEvent = transactionEvents.pop();
            if (transactionEvent.type == TransactionEvent.Type.BEGIN) {
                return;
            }
        }
    }

    public void rollback() {
        while (!transactionEvents.empty()) {
            TransactionEvent<T> transactionEvent = transactionEvents.pop();

            switch (transactionEvent.type) {
                case POP: {
                    stack.push(transactionEvent.value);
                    break;
                }

                case PUSH: {
                    validateNonEmptyStack();

                    stack.pop();
                    break;
                }

                case BEGIN: {
                    return;
                }

                default: {
                    throw new RuntimeException(String.format("Unknown event: {}", transactionEvent.type));
                }
            }
        }
    }

    private void validateNonEmptyStack() {
        if (stack.empty()) {
            rollback();
            throw new TransactionRolledbackException("Cannot execute action on an empty stack. Rolled back changes.");
        }
    }
}
