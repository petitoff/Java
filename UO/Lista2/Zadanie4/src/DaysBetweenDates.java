import java.util.Scanner;

public class DaysBetweenDates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj pierwszą datę w formacie DD-MM-YYYY: ");
        String date1Str = scanner.next();
        System.out.print("Podaj drugą datę w formacie DD-MM-YYYY: ");
        String date2Str = scanner.next();

        int day1 = Integer.parseInt(date1Str.substring(0, 2));
        int month1 = Integer.parseInt(date1Str.substring(3, 5));
        int year1 = Integer.parseInt(date1Str.substring(6, 10));

        int day2 = Integer.parseInt(date2Str.substring(0, 2));
        int month2 = Integer.parseInt(date2Str.substring(3, 5));
        int year2 = Integer.parseInt(date2Str.substring(6, 10));

        int diff = daysBetweenDates(day1, month1, year1, day2, month2, year2);

        System.out.println("Liczba dni między dwiema datami to: " + diff);
    }

    public static int daysBetweenDates(int day1, int month1, int year1, int day2, int month2, int year2) {
        int days1 = countDays(year1, month1, day1);
        int days2 = countDays(year2, month2, day2);

        return Math.abs(days2 - days1);
    }

    private static int countDays(int year, int month, int day) {
        int days = 0;

        for (int i = 1; i < year; i++) {
            if (isLeapYear(i)) {
                days += 366;
            } else {
                days += 365;
            }
        }

        for (int i = 1; i < month; i++) {
            days += getDaysInMonth(year, i);
        }

        days += day;

        return days;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }

    private static int getDaysInMonth(int year, int month) {
        int days;

        if (month == 2) {
            if (isLeapYear(year)) {
                days = 29;
            } else {
                days = 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else {
            days = 31;
        }

        return days;
    }
}
