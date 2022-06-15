public class TaskAlreadyExistsException extends RuntimeException{
    /**
     * Creates an exception without any further explanation
     */
    public TaskAlreadyExistsException() {
    }

    /**
     * Creates an exception with an explanation
     * @param message    a string with explanation about the exception
     */
    public TaskAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * Creates an exception with an explanation and the cause
     * @param message a string with explanation
     * @param cause a Throwable, what caused the exception
     */
    public TaskAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
