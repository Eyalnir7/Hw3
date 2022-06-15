import java.util.*;

public class ToDoListIterator implements Iterator<Task> {

    private final ArrayList<Task> taskList;
    private int cursor = 0;

    private void filterByDate(Date date){
        if(date == null)
            return;
        for(int i = 0; i<taskList.size(); i++){
            if(taskList.get(i).getDueDate().getTime()>date.getTime()){
                taskList.remove(i);
                i--;
            }
        }
    }

    private void sortTaskList(){
        Comparator<Task> compareByDate = Comparator.comparing(Task::getDueDate);
        Comparator<Task> compareByABC = Comparator.comparing(Task::getDescription);
        Comparator<Task> compareByRules = compareByDate.thenComparing(compareByABC);
        Collections.sort(taskList, compareByRules);
    }

    public ToDoListIterator(ToDoList toDoList){
        taskList = toDoList.clone().getTaskList();
        filterByDate(toDoList.getMaxDate());
        sortTaskList();
    }

    @Override
    public boolean hasNext() {
        return cursor < taskList.size();
    }

    @Override
    public Task next() {
        cursor++;
        return taskList.get(cursor);
    }
}
