import java.util.LinkedList;
import java.util.Queue;

class WeekDay {
    private String day;
    private String date;

    public WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }
}

class Week {
    private Queue<WeekDay> days;

    public Week() {
        this.days = new LinkedList<>();
    }

    public void addDay(WeekDay day) {
        days.offer(day);
    }

    public Queue<WeekDay> getDays() {
        return days;
    }
}

public class q25_CalendarWithQueue {

    public static void main(String[] args) {
        // Create a sample week
        Week week = createSampleWeek();

        // Display the calendar
        displayCalendar(week);
    }

    private static Week createSampleWeek() {
        Week week = new Week();

        // Sample days of the week
        String[] weekDays = {"S", "M", "T", "W", "Th", "F", "S"};

        // Sample dates for each day
        String[] dates = {"", "1", "2", "3", "", "5", "6"};

        for (int i = 0; i < weekDays.length; i++) {
            WeekDay day = new WeekDay(weekDays[i], dates[i]);
            week.addDay(day);
        }

        return week;
    }

    private static void displayCalendar(Week week) {
        Queue<WeekDay> days = week.getDays();

        // Print day names
        System.out.println("Day  Date");
        System.out.println("-----------------");

        // Display each day with its date
        while (!days.isEmpty()) {
            WeekDay day = days.poll();
            System.out.println(day.getDay() + "    " + day.getDate());
        }
    }
}

