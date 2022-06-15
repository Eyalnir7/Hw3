import java.util.*;

/**
 * The iterator for ToDoList.
 * scans the list from the newest task to the oldest
 * and if two tasks have the same date it scans them
 * by alphabetical order of their descriptions.
 * It only scans tasks with dates before the max date (a variable in toDoList)
 * if max date is null, it scans the whole list
 */
public class ToDoListIterator implements Iterator<Task> {

    private final ArrayList<Task> taskList;
    private int cursor = 0;

    /**
     * filter tasks with date after max date
     * @param date the max date
     */
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

    /**
     * sorts the tasks as explained above (in the class description)
     */
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
        return taskList.get(cursor++);
    }
}
