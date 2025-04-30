package be.thomasmore.familieplanner.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarService {

    public List<List<LocalDate>> generateWeeksForMonth(YearMonth yearMonth) {
        List<List<LocalDate>> weeks = new ArrayList<>();
        List<LocalDate> week = new ArrayList<>();

        LocalDate first = yearMonth.atDay(1);
        LocalDate last = yearMonth.atEndOfMonth();

        LocalDate current = first.with(java.time.DayOfWeek.SUNDAY);
        while (!current.isAfter(last.with(java.time.DayOfWeek.SATURDAY))) {
            week.add(current);
            if (week.size() == 7) {
                weeks.add(week);
                week = new ArrayList<>();
            }
            current = current.plusDays(1);
        }

        return weeks;
    }
}
