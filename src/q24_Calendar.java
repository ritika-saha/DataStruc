import java.util.Calendar;

public class q24_Calendar {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java q24_Calendar <month> <year>");
            return;
        }

        String monthName = args[0];
        int year = Integer.parseInt(args[1]);

        int month = getMonthNumber(monthName);

        if (month == -1) {
            System.out.println("Invalid month name");
            return;
        }

        printCalendar(month, year);
    }

    private static void printCalendar(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        // Print month and year
        System.out.println(getMonthName(month) + " " + year);

        // Print day names
        System.out.println("S  M  T  W  Th  F  S");

        // Determine the day of the week for the first day of the month
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);

        // Create a 2D array to store the calendar
        int[][] calendarArray = new int[6][7]; // Assuming a maximum of 6 weeks in a month

        int day = 1;

        // Fill in the calendar array
        for (int i = 0; i < calendarArray.length; i++) {
            for (int j = 0; j < calendarArray[i].length; j++) {
                if ((i == 0 && j < startDay - 1) || day > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    // Leave spaces for days before the first day and after the last day of the month
                    calendarArray[i][j] = -1;
                } else {
                    calendarArray[i][j] = day++;
                }
            }
        }

        // Print the calendar
        for (int i = 0; i < calendarArray.length; i++) {
            for (int j = 0; j < calendarArray[i].length; j++) {
                if (calendarArray[i][j] == -1) {
                    System.out.print("   "); // Print spaces for days not in the current month
                } else {
                    System.out.print(String.format("%2d ", calendarArray[i][j])); // Format day with 2 characters
                }
            }
            System.out.println(); // Move to the next line after each week
        }
    }

    private static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }

    private static int getMonthNumber(String monthName) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        for (int i = 0; i < monthNames.length; i++) {
            if (monthNames[i].equalsIgnoreCase(monthName)) {
                return i + 1;
            }
        }

        return -1; // Return -1 if the month name is not found
    }
}
