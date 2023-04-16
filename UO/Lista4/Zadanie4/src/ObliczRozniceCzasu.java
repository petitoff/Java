import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ObliczRozniceCzasu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Strefa czasowa: Europe/Warsaw");
        System.out.print("Podaj godzinę dla strefy 1: ");
        int godziny1 = scanner.nextInt();

        System.out.print("Podaj minuty dla strefy 1: ");
        int minuty1 = scanner.nextInt();

        System.out.println("Strefa czasowa: America/New_York");
        System.out.print("Podaj godzinę dla strefy 2: ");
        int godziny2 = scanner.nextInt();

        System.out.print("Podaj minuty dla strefy 2: ");
        int minuty2 = scanner.nextInt();

        ZoneId strefa1 = ZoneId.of("Europe/Warsaw");
        ZoneId strefa2 = ZoneId.of("America/New_York");
        LocalDate data = LocalDate.of(2022, 2, 12);

        ZonedDateTime dateTime1 = ZonedDateTime.of(data, LocalTime.of(godziny1, minuty1), strefa1);
        ZonedDateTime dateTime2 = ZonedDateTime.of(data, LocalTime.of(godziny2, minuty2), strefa2);

        long roznicaGodzin = ChronoUnit.HOURS.between(dateTime1, dateTime2);

        System.out.println("Różnica czasu między " + strefa1.getId() + " a " + strefa2.getId() +
                " dla godzin " + godziny1 + ":" + minuty1 + " i " + godziny2 + ":" + minuty2 +
                " wynosi " + roznicaGodzin + " godzin");
    }
}