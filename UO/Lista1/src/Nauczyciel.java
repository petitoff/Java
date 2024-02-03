import java.util.Scanner;

public class Nauczyciel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String imie = PrintAndGetResponse(scanner, "Podaj imię");
        Uczen.numerKursu = Integer.parseInt(PrintAndGetResponse(scanner, "Podaj numer kursu: "));
        int rok = Integer.parseInt(PrintAndGetResponse(scanner, "Podaj rok: "));
        int ocena = Integer.parseInt(PrintAndGetResponse(scanner, "Ocena: "));
        String ulubionyKolor = PrintAndGetResponse(scanner, "Podaj ulubiony kolor");

        Uczen uczen = new Uczen(imie, ocena, ulubionyKolor, rok);
        uczen.printAllProperty();

        scanner.close();
    }

    public static String PrintAndGetResponse(Scanner scanner, String ask) {
        System.out.print(ask + ": ");
        return scanner.nextLine();
    }
}