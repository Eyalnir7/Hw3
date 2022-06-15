import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> taskList;
    public ToDoList(){
        taskList = new ArrayList<Task>();
    }

    private boolean exists(Task task){
        for(Task t: taskList){
            if(task.equals(t))
                return true;
        }
        return false;
    }

    public void AddTask(Task task){
        if(exists(task))
            //throw exception
        taskList.add(task);
    }
}
