import java.util.Scanner;
import java.util.TimeZone;

public class TimeDifferenceCalculator {
    public static void main(String[] args) {
        // Ustawienia stref czasowych i daty
        TimeZone timeZone1 = TimeZone.getTimeZone("Europe/Warsaw");
        TimeZone timeZone2 = TimeZone.getTimeZone("America/New_York");
        int year = 2023;
        int month = 4;
        int day = 16;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj godzinę w strefie " + timeZone1.getID() + " (HH:mm):");
        String time1Str = scanner.nextLine();
        System.out.print("Podaj godzinę w strefie " + timeZone2.getID() + " (HH:mm):");
        String time2Str = scanner.nextLine();

        // Parsowanie godzin i minut
        int hour1 = Integer.parseInt(String.format("%02d", Integer.parseInt(time1Str.split(":")[0])));
        int minute1 = Integer.parseInt(time1Str.split(":")[1]);
        int hour2 = Integer.parseInt(String.format("%02d", Integer.parseInt(time2Str.split(":")[0])));
        int minute2 = Integer.parseInt(time2Str.split(":")[1]);

        // Obliczanie różnicy czasu w ms
        long millis1 = timeZone1.getOffset(0L) + timeZone1.getDSTSavings();
        long millis2 = timeZone2.getOffset(0L) + timeZone2.getDSTSavings();
        long diffMillis = Math.abs(millis1 - millis2);

        // Konwersja do godzin
        double diffHours = (double) diffMillis / (60 * 60 * 1000);

        System.out.println("Różnica czasu między " + timeZone1.getID() + " a " + timeZone2.getID() +
                " wynosi " + diffHours + " godzin.");
    }
}
