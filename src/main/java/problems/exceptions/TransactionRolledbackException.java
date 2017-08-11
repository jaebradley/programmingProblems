package problems.exceptions;

public class TransactionRolledbackException extends RuntimeException {
    public TransactionRolledbackException(final String message) {
        super(message);
    }
}
