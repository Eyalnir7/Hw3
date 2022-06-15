import java.util.ArrayList;
import java.util.Objects;

public class ToDoList {
    private ArrayList<Task> taskList;

    public ToDoList(){
        taskList = new ArrayList<Task>();
    }

    private boolean exists(Task task){
        for(Task element: taskList){
            if(task.equals(element))
                return true;
        }
        return false;
    }

    public void addTask(Task task) throws TaskAlreadyExistsException{
        if(exists(task))
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
}
