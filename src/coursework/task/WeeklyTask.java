package coursework.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, Type type, String dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        long daysBetween = ChronoUnit.DAYS.between(getDateTime().toLocalDate(), date);
        return (daysBetween >= 0 && daysBetween % 7 == 0);
    }

    @Override
    public String toString() {
        return "Еженедельная задача " + "\n" +
                "id задачи: " + getId() + "\n" +
                "Тип задачи: " + getType() + "\n" +
                "Время задачи: " + getDateTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n" +
                "Наименование: " + getTitle() + "\n" +
                "Описание: " + getDescription() + "\n";
    }
}
