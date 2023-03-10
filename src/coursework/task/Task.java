package coursework.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task  {

    private static int idGenerator = 0;
    private String title;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String description;


    public Task(String title, Type type, LocalDateTime dateTime, String description) {
        this.title = title;
        this.type = type;
        this.id = idGenerator++;
        this.dateTime = dateTime;
        this.description = description;
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
        return "Task{" +
                "title='" + getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: " + getDateTime() +
                "\n Type of task: " + getType().getType();

    }
}


