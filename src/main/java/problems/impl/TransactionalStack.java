package problems.impl;

import problems.exceptions.TransactionRolledbackException;

import java.util.EmptyStackException;
import java.util.Stack;

public class TransactionalStack<T> {
    private final Stack<T> stack = new Stack<>();
    private final Stack<TransactionEvent<T>> transactionEvents = new Stack<>();
    private Stack<TransactionEvent<T>> rolledbackTransactionEvents = new Stack<>();


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

        if (!transactionEvents.isEmpty() && rolledbackTransactionEvents.empty()) {
            transactionEvents.add(new TransactionEvent<>(TransactionEvent.Type.PUSH, value));
        }
    }

    public T pop() {
        T value;

        try {
            value = stack.pop();
        } catch (EmptyStackException e) {
            if (transactionEvents.empty()) {
                throw e;
            }

            rollback();

            throw new TransactionRolledbackException("Cannot pop an empty stack. Rolled back changes.");
        }

        if (!transactionEvents.isEmpty() && rolledbackTransactionEvents.empty()) {
            transactionEvents.add(new TransactionEvent<>(TransactionEvent.Type.POP, value));
        }

        return value;
    }

    public int getSize() {
        return stack.size();
    }

    public T peek() {
        try {
            return stack.peek();
        } catch (EmptyStackException e) {
            if (transactionEvents.empty()) {
                throw e;
            }

            rollback();

            throw new TransactionRolledbackException("Cannot peek an empty stack. Rolled back changes.");
        }
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
            rolledbackTransactionEvents.push(transactionEvent);

            switch (transactionEvent.type) {
                case POP: {
                    push(transactionEvent.value);
                    break;
                }

                case PUSH: {
                    pop();
                    break;
                }

                default: {
                    return;
                }
            }
        }

        rolledbackTransactionEvents = new Stack<>();
    }
}
