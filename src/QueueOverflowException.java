public class QueueOverflowException extends QueueException{
    /**
     * Creates an exception without any further explanation
     */
    public QueueOverflowException(){
    }

    /**
     * Creates an exception with an explanation
     * @param message    a string with explanation about the exception
     */
    public QueueOverflowException(String message) {
        super(message);
    }

    /**
     * Creates an exception with an explanation and the cause
     * @param message a string with explanation
     * @param cause a Throwable, what caused the exception
     */
    public QueueOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
