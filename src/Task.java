import java.util.Date;
import java.util.Objects;

public class Task implements Cloneable{
    private String description;
    private Date dueDate;

    public Task(String description, Date dueDate){
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, dueDate);
    }

    @Override
    public String toString(){
        return "(" + description + ", "  + ")";
    }

    @Override
    public Task clone(){
        return new Task(description, dueDate);
    }
}
