public class TaskAlreadyExistsException extends Exception{
    public TaskAlreadyExistsException() {
    }

    public TaskAlreadyExistsException(String message) {
        super(message);
    }

    public TaskAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
