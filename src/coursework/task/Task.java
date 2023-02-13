package coursework.task;

import coursework.exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Task  {

    private static int idGenerator = 0;
    private String title;
    private final Type type;
    private final int id;
    private LocalDateTime dateTime;
    private String description;


    public Task(String title, Type type, String dateTime, String description) {
        this.title = title;
        this.type = type;
        this.id = idGenerator++;
        this.description = description;
        try {
            setDateTime(dateTime);
        } catch (IncorrectArgumentException e) {
            System.out.println();
            System.out.println(e.getMessage());
        }

    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }



    public void setDateTime(String dateTime) throws IncorrectArgumentException {
        boolean check = true;
        try {
            this.dateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        } catch (DateTimeParseException e) {
            check = false;
        }
        if (!check) {
            throw new IncorrectArgumentException("Неккоректно указана дата добавьте задачу повторно");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract boolean appearsIn(LocalDate date);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return "id задачи" + id + "\n" +
                "Тип задачи: " + type + "\n" +
                "Время задачи: " + dateTime.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n" +
                "Наименование: " + title + "\n" +
                "Описание: " + description + "\n";

    }
}


