import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

/**
 * The todolist organizes the tasks the user has
 */
public class ToDoList implements TaskIterable, Cloneable{
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

    /**
     * Checks if the task already exists in the task list
     * @param task the task to check
     * @return whether the given task exists in the task list
     */
    private boolean exists(Task task){
        for(Task element: taskList){
            if(task.equals(element))
                return true;
        }
        return false;
    }

    /**
     * Adds a task to the task list if another task with the same description doesn't already exist
     * @param task    the task to insert
     * @throws TaskAlreadyExistsException  an exception that's caused because the task already exists
     */
    public void addTask(Task task) throws TaskAlreadyExistsException{
        for(Task element : taskList){
            if(Objects.equals(element.getDescription(), task.getDescription())){
                throw new TaskAlreadyExistsException();
            }
        }
        taskList.add(task);
    }

    @Override
    public String toString(){
        String str = "[";
        for(Task element: taskList){
            str += "(" + element.toString() + "), ";
        }
        str = str.substring(0, str.length() - 2);
        return str + "]";
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Creates a deep clone
     * @return deep copy of the task
     */
    @Override
    public ToDoList clone(){
        ToDoList cloned;
        try {
            cloned = (ToDoList) super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }
        cloned.setTaskList(new ArrayList<Task>());
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
        if(toDoList.getTaskList().size() != this.taskList.size()) return false;
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
        return new ToDoListIterator(this);
    }
}
