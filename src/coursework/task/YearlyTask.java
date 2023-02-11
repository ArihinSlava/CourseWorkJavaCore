package coursework.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class YearlyTask extends Task{

    public YearlyTask(String title, Type type, String dateTime, String description) {
        super(title, type, dateTime, description);
    }
    @Override
    public boolean appearsIn(LocalDate date) {
        Period period = Period.between(getDateTime().toLocalDate(), date);
        return period.getYears() >= 0 && period.getMonths() == 0 && period.getDays() == 0;
    }

    @Override
    public String toString() {
        return "Ежегодная задача " + "\n" +
                "id задачи: " + getId() + "\n" +
                "Тип задачи: " + getType() + "\n" +
                "Время задачи: " + getDateTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n" +
                "Наименование: " + getTitle() + "\n" +
                "Описание: " + getDescription() + "\n";
    }
}
