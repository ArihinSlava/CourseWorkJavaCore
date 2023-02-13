package coursework.taskService;


import coursework.exceptions.TaskNotFoundException;
import coursework.task.Task;

import java.time.LocalDate;
import java.util.*;


public class TaskService {

    private static final Map<Integer, Task> hashTask = new HashMap<>();

    public static void add(Task task) {
        hashTask.put(task.getId(), task);
        System.out.println("Задача создана: " + task);
        }

    public static void removeTask(int id) throws TaskNotFoundException {
        if (hashTask.values().removeIf(i -> i.getId() == id)) {
            System.out.println("Задача с номером: " + id + " Удалена");
        } else {
            throw new TaskNotFoundException("Данные id не найдены");
        }
    }

    public static void getAllByDate(LocalDate date) throws TaskNotFoundException {
        for (Map.Entry<Integer, Task> hashTask : hashTask.entrySet()) {
            LocalDate taskDate = hashTask.getValue().getDateTime().toLocalDate();
            if (taskDate.equals(date) || hashTask.getValue().appearsIn(date)) {
                System.out.println(hashTask.getKey() + " " + hashTask.getValue());
            } else {
                throw new TaskNotFoundException("За текущий день задач не обнаружено");
            }
        }
    }

    public static void listTaskMap() {
        System.out.println("Актульный список задач: ");
        for (Map.Entry<Integer, Task> hashTask : hashTask.entrySet())
            System.out.println(hashTask.getKey() + " " + hashTask.getValue());
    }


    }





