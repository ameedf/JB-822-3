package ameedf.jb8223.lectures.enums;

public enum DayOfWeek {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    private int dayNumber;

    DayOfWeek(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public static DayOfWeek getByDayNumber(int dayNumber) {
        DayOfWeek[] days = values();
        for (DayOfWeek day : days) {
            if (day.dayNumber == dayNumber) {
                return day;
            }
        }
        return null;
    }
}
