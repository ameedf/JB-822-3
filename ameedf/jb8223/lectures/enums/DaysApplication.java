package ameedf.jb8223.lectures.enums;

import java.util.Scanner;

public class DaysApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day number: ");
        final int dayNumber = scanner.nextInt();
        final DayOfWeek day = DayOfWeek.getByDayNumber(dayNumber);
        System.out.println("The day of the week is " + day);

        // REPLACE the day number with day short name (sun, mon, ...)
    }
}
