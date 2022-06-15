import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

public class ToDoList implements TaskIterable{
    private ArrayList<Task> taskList;
    private Date maxDate;

    public Date getMaxDate() {
        return maxDate;
    }

    public ToDoList(){
        taskList = new ArrayList<Task>();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    private boolean exists(Task task){
        for(Task element: taskList){
            if(task.equals(element))
                return true;
        }
        return false;
    }

    public void addTask(Task task) throws TaskAlreadyExistsException{
        boolean descriptionExists = false;
        for(Task element : taskList){
            if(element.getDescription() == task.getDescription()){
                descriptionExists = true;
                break;
            }
        }
        if(descriptionExists)
            throw new TaskAlreadyExistsException();
        taskList.add(task);
    }

    @Override
    public String toString(){
        String str = "[";
        for(Task element: taskList){
            str += element.toString();
        }
        return str + "]";
    }

    @Override
    public ToDoList clone(){
        ToDoList cloned;
        try {
            cloned = (ToDoList) super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }
        for(Task element: taskList){
            try {
                cloned.addTask(element.clone());
            }catch(TaskAlreadyExistsException e){
                return null;
            }
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoList toDoList = (ToDoList) o;
        for(Task element: toDoList)
        {
            if(!exists(element))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for(Task element: taskList){
            hash += element.hashCode();
        }
        return Objects.hash(taskList);
    }

    @Override
    public void setScanningDueDate(Date date) {
        maxDate = date;
    }

    @Override
    public Iterator<Task> iterator() {
        return null;
    }
}
