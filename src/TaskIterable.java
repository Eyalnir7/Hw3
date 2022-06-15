import java.util.Date;
import java.util.Iterator;

/**
 * Points out that the implementing classes are task iterable
 */
public interface TaskIterable extends Iterable<Task> {
    /**
     * sets the latest due date to check when looking for tasks
     * @param date the date to use
     */
    public void setScanningDueDate(Date date);
}
