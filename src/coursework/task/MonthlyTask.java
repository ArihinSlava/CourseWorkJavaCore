package coursework.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MonthlyTask extends Task{

    public MonthlyTask(String title, Type type, String dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateTime().toLocalDate().getDayOfMonth() == date.getDayOfMonth();
    }

    @Override
    public String toString() {
        return "Ежемесячная задача: " + "\n" +
                "id задачи: " + getId() + "\n" +
                "Тип задачи: " + getType() + "\n" +
                "Время задачи: " + getDateTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n" +
                "Наименование: " + getTitle() + "\n" +
                "Описание: " + getDescription() + "\n";
    }
}
