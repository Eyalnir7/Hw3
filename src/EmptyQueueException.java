public class EmptyQueueException extends QueueException{
    public EmptyQueueException(){
    }

    public EmptyQueueException(String message) {
        super(message);
    }

    public EmptyQueueException(String message, Throwable cause) {
        super(message, cause);
    }
}
