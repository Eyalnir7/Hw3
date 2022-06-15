import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.*;

public class ToDoList {
    private ArrayList<Task> taskList;


    public ToDoList(){
        taskList = new ArrayList<Task>();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
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
        Comparator<Task> compareByDate = Comparator.comparing(Task::getDueDate);
        Comparator<Task> compareByABC = Comparator.comparing(Task::getDescription);
        Comparator<Task> compareByRules = compareByDate.thenComparing(compareByABC);
        Collections.sort(AlgebrosTaskList, compareByRules);
    }



    @Override
    public String toString(){
        String str = "[";
        for(Task element: taskList){
            str += element.toString() + ", ";
        }
        str = str.substring(0, str.length() - 2);
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
