import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ObliczLiczbeDni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        System.out.print("Podaj pierwszą datę w formacie dd.MM.yyyy:");
        String data1String = scanner.nextLine();

        System.out.print("Podaj drugą datę w formacie dd.MM.yyyy:");
        String data2String = scanner.nextLine();

        try {
            Date data1 = dateFormat.parse(data1String);
            Date data2 = dateFormat.parse(data2String);

            long roznicaWms = data2.getTime() - data1.getTime();
            long dni = TimeUnit.DAYS.convert(roznicaWms, TimeUnit.MILLISECONDS);

            System.out.println("Liczba dni między datami to: " + dni);
        } catch (Exception e) {
            System.out.println("Nieprawidłowy format daty!");
        }
    }
}