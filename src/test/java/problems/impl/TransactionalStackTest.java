package problems.impl;

import org.junit.Test;
import problems.exceptions.TransactionRolledbackException;

import static org.junit.Assert.*;

public class TransactionalStackTest {
    private final String first = "first";
    private final String second = "second";

    @Test
    public void testInnerTransactionRollback() {
        TransactionalStack<String> stack = new TransactionalStack<>();
        stack.begin();
        stack.push(first);
        stack.begin();
        stack.push(second);
        stack.rollback();
        stack.commit();
        assertEquals(first, stack.peek());
    }

    @Test
    public void testRollback() {
        TransactionalStack<String> stack = new TransactionalStack<>();
        stack.push(first);
        stack.begin();
        stack.pop();
        stack.push(second);

        assertEquals(1, stack.getSize());
        assertEquals(second, stack.peek());

        stack.rollback();

        assertEquals(1, stack.getSize());
        assertEquals(first, stack.peek());
    }

    @Test
    public void testRollbackWhenPoppingOnEmptyStack() {
        TransactionalStack<String> stack = new TransactionalStack<>();
        stack.push(first);
        stack.push(second);
        try {
            stack.begin();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (TransactionRolledbackException e) {
            assertEquals(2, stack.getSize());
            assertEquals(second, stack.peek());
        }
    }

    @Test
    public void testCommit() {
        TransactionalStack<String> stack = new TransactionalStack<>();
        stack.begin();
        stack.push(first);
        stack.commit();
        assertEquals(1, stack.getSize());
        assertEquals(first, stack.peek());
    }
}