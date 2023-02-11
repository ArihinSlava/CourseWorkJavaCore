package coursework.taskService;

import coursework.task.Task;
import java.util.*;

public class TaskService {

    private static final Map<Integer, Task> taskMap = new HashMap<>();

    private static final Collection<Task> removedTasks = new ArrayList<>();

    public Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public void add(Task task) {
        getTaskMap().put(task.getId(), task);
    }

    public void remove() {

    }

    public void listTaskMap() {
        for (Map.Entry<Integer, Task> taskMap : taskMap.entrySet()) {
            System.out.println(taskMap.getKey() + " " + taskMap.getValue());
        }
        }
    }





