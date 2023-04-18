import java.util.Scanner;
import java.util.TimeZone;

public class TimeDifferenceCalculator {
    public static void main(String[] args) {
        // Ustawienia stref czasowych i daty
        TimeZone timeZone1 = TimeZone.getTimeZone("Europe/Warsaw");
        TimeZone timeZone2 = TimeZone.getTimeZone("America/New_York");

        // Obliczanie różnicy czasu w ms
        long millis1 = timeZone1.getRawOffset() + timeZone1.getDSTSavings();
        long millis2 = timeZone2.getRawOffset() + timeZone2.getDSTSavings();
        long diffMillis = Math.abs(millis1 - millis2);

        // Konwersja do godzin
        double diffHours = (double)diffMillis / (60 * 60 * 1000);

        System.out.println("Różnica czasu między " + timeZone1.getID() + " a " + timeZone2.getID() +
                " wynosi " + diffHours + " godzin.");
    }
}
