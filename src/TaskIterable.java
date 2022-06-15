import java.util.Date;
import java.util.Iterator;

public interface TaskIterable extends Iterable<Task> {
    public void setScanningDueDate(Date date);
}
