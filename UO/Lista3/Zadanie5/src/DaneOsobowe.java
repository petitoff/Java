import java.util.Scanner;

public class DaneOsobowe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj dane osobowe (wiek, data urodzenia w formacie dd.MM.rrrr, PESEL, imię i nazwisko lub imiona i nazwisko):");
        String daneOsobowe = scanner.nextLine();

        if (czyWiek(daneOsobowe)) {
            int wiek = Integer.parseInt(daneOsobowe);
            int rokUrodzenia = obliczRokUrodzenia(wiek);
            System.out.println("Rok urodzenia: " + rokUrodzenia);
        } else if (czyDataUrodzenia(daneOsobowe)) {
            String dataUrodzenia = daneOsobowe;
            String[] czesciDaty = dataUrodzenia.split("\\.");
            int dzien = Integer.parseInt(czesciDaty[0]);
            int miesiac = Integer.parseInt(czesciDaty[1]);
            int rok = Integer.parseInt(czesciDaty[2]);
            System.out.println("Urodzony/a " + dzien + "." + miesiac + "." + rok + " roku");
        } else if (czyPESEL(daneOsobowe)) {
            String pesel = daneOsobowe;
            String plec = (Integer.parseInt(pesel.substring(9, 10)) % 2 == 0) ? "Kobieta" : "Mężczyzna";
            String dataUrodzenia = pesel.substring(4, 6) + "." + pesel.substring(2, 4) + "." + ((pesel.charAt(0) < '2') ? "19" : "20") + pesel.substring(0, 2);
            System.out.println("PESEL: " + pesel);
            System.out.println("Płeć: " + plec);
            System.out.println("Data urodzenia: " + dataUrodzenia);
        } else if (czyImieNazwisko(daneOsobowe)) {
            String imieNazwisko = daneOsobowe;
            String[] czesci = imieNazwisko.split(" ");
            if (czesci.length == 2) {
                String imie = czesci[0];
                String nazwisko = czesci[1];
                System.out.println("Imię: " + imie);
                System.out.println("Nazwisko: " + nazwisko);
            } else if (czesci.length == 3) {
                String imie1 = czesci[0];
                String imie2 = czesci[1];
                String nazwisko = czesci[2];
                System.out.println("Pierwsze imię: " + imie1);
                System.out.println("Drugie imię: " + imie2);
                System.out.println("Nazwisko: " + nazwisko);
            }
        } else {
            System.out.println("Nieznany format danych osobowych.");
        }
    }

    private static boolean czyWiek(String daneOsobowe) {
        try {
            Integer.parseInt(daneOsobowe);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int obliczRokUrodzenia(int wiek) {
        int aktualnyRok = java.time.Year.now().getValue();
        return aktualnyRok - wiek;
    }

    private static boolean czyDataUrodzenia(String daneOsobowe) {
        return daneOsobowe.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    private static boolean czyPESEL(String daneOsobowe) {
        return daneOsobowe.matches("\\d{11}");
    }

    private static boolean czyImieNazwisko(String daneOsobowe) {
        return daneOsobowe.matches("([a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+(\\s[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+){1,2})");
    }
}