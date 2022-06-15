import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task> {

    private ToDoList toDoList;
    private int cursor = 0;

    public ToDoListIterator(ToDoList toDoList){
        this.toDoList = toDoList;
    }

    @Override
    public boolean hasNext() {
        return cursor < toDoList.getTaskList().size();
    }

    @Override
    public Task next() {
        cursor++;
        return toDoList.getTaskList().get(cursor);
    }
}
