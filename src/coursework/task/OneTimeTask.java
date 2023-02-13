package coursework.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class OneTimeTask extends Task{


    public OneTimeTask(String title, Type type, String dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return Objects.equals(getDateTime().toLocalDate(), date);
    }

    @Override
    public String toString() {
        return "Однократная задача " + "\n" +
                "id задачи: " + getId() + "\n" +
                "Тип задачи: " + getType() + "\n" +
                "Время задачи: " + getDateTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n" +
                "Наименование: " + getTitle() + "\n" +
                "Описание: " + getDescription() + "\n";
    }
}
