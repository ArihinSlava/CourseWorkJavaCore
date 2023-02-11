import coursework.exceptions.IncorrectArgumentException;
import coursework.exceptions.TaskNotFoundException;
import coursework.task.*;
import coursework.taskService.TaskService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

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
                            try {
                                inputTask(scanner);
                            } catch (IncorrectArgumentException e) {
                                System.out.println();
                                System.out.println(e.getMessage());
                                System.out.println();
                            }
                            break;
                        case 2:
                            try {
                                deleteTask(scanner);
                            } catch (IncorrectArgumentException e) {
                                System.out.println();
                                System.out.println(e.getMessage());
                                System.out.println();
                            }
                            break;
                        case 3:
                            try {
                                dateFormat(scanner);
                            } catch (IncorrectArgumentException e) {
                                System.out.println();
                                System.out.println(e.getMessage());
                                System.out.println();
                            }
                            break;
                        case 4:
                            listTaskMap();
                            break;
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

    public static void inputTask(Scanner scanner) throws IncorrectArgumentException {

        System.out.print("Введите название задачи: ");
        scanner.nextLine();
        String taskName = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.nextLine();
        System.out.print("Введите дату в формате [dd.MM.yyyy HH:mm]");
        String taskDate = scanner.nextLine();
        Type typeTask;
        label:
        while (true) {
            System.out.print("Выберите повторяемость задачи: ");
            System.out.print("1.Однократная 2.Ежедневная 3.Еженедельная 4. Ежемесячная 5.Ежегодная ");
            if (scanner.hasNextInt()) {
                int replayTask = scanner.nextInt();
                switch (replayTask) {
                    case 1:
                        typeTask = typeTask(scanner);
                        TaskService.add(new OneTimeTask(taskName, typeTask, taskDate, taskDescription));
                        break label;
                    case 2:
                        typeTask = typeTask(scanner);
                        TaskService.add(new DailyTask(taskName, typeTask, taskDate, taskDescription));
                    case 3:
                        typeTask = typeTask(scanner);
                        TaskService.add(new WeeklyTask(taskName, typeTask, taskDate, taskDescription));
                    case 4:
                        typeTask = typeTask(scanner);
                        TaskService.add(new MonthlyTask(taskName, typeTask, taskDate, taskDescription));
                    case 5:
                        typeTask = typeTask(scanner);
                        TaskService.add(new YearlyTask(taskName, typeTask, taskDate, taskDescription));
                        break label;
                    default:
                        System.out.println("Выберите пункт от 1 до 5");
                        break;
                }
            } else {
                scanner.next();
            }
        }
    }

    public static int checkId(Scanner scanner) throws IncorrectArgumentException {
        int intId;
        try {
            intId = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IncorrectArgumentException("Некорректный ввод");
        }
        return intId;
    }

    public static Type typeTask(Scanner scanner) throws IncorrectArgumentException {
        Type taskType;
        System.out.println("Выберите тип задачи: ");
        System.out.println("Личная , Рабочая ");
        String input = scanner.next();
        Type typeTask = (Objects.equals(input, "Личная")) ? Type.PERSONAL : (Objects.equals(input, "Рабочая")) ? Type.WORK : null;
        if (typeTask == null) {
            throw new IncorrectArgumentException("Некорректно указан тип задачи, добавьте задачу повторно");
        }
        return typeTask;
    }

    public static void deleteTask(Scanner scanner) throws IncorrectArgumentException  {
        int inputId = checkId(scanner);
        try {
            TaskService.removeTask(inputId);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dateFormat(Scanner scanner) throws IncorrectArgumentException {
        LocalDate date;
        try {
            scanner.nextLine();
            String string = scanner.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            date = LocalDate.parse(string, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            throw new IncorrectArgumentException("Некорректна введена дата");
        }
        try {
            TaskService.getAllByDate(date);
        } catch (TaskNotFoundException e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
    public static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n4. Показать все задачи\n0. Выход");
    }

    public static void listTaskMap() {
        TaskService.listTaskMap();
    }

}



