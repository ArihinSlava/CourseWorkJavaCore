import coursework.task.Task;
import coursework.task.Type;
import coursework.taskService.TaskService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static final String DATE_FORMATTER = "dd.MM.yyyy";
    private static TaskService taskService = new TaskService();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            // todo: обрабатываем пункт меню 2
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3
                            break;
                        case 4:
                            listTaskMap();
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    public static void inputTask(Scanner scanner) {
        Type type;
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();

        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();

        System.out.print("Введите название задачи: " +
                "\n1. work" +
                "\n2. personal" + "\n");
        String taskTypeString = scanner.next();
        int taskTypeInt = Integer.parseInt(taskTypeString);
        if (taskTypeInt == 1) {
            type = Type.WORK;
        } else if (taskTypeInt == 2) {
            type = Type.PERSONAL;
        } else {
            System.out.println("Невозможно определить тип задачи");
            type = Type.PERSONAL;
        }

        System.out.print("Введите дату в формате дд.ММ.гггг: ");
        String date = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDate parse = LocalDate.parse(date, formatter);



    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n4. Получить список всех задач\n0. Выход");
    }
    private static void listTaskMap() {
        taskService.listTaskMap();
    }



}



