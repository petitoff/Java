import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj wiek, datę urodzenia w formacie dd.MM.rrrr, PESEL, imię nazwisko lub imię1 imię2 nazwisko: ");
        String userInput = scanner.nextLine();

        if (isAge(userInput)) {
            int age = Integer.parseInt(userInput);
            int birthYear = LocalDate.now().getYear() - age;
            System.out.println("Rok urodzenia: " + birthYear);
        } else if (isBirthDate(userInput)) {
            LocalDate birthDate = LocalDate.parse(userInput, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            String formattedBirthDate = birthDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy 'roku'"));
            System.out.println("Urodziłeś/łaś się " + formattedBirthDate);
        } else if (isPesel(userInput)) {
            String pesel = userInput;
            LocalDate birthDate = getBirthDateFromPesel(pesel);
            String genderStr = pesel.charAt(9) % 2 == 0 ? "kobieta" : "mężczyzna";
            System.out.println("PESEL: " + pesel);
            System.out.println("Data urodzenia: " + birthDate);
            System.out.println("Płeć: " + genderStr);
        } else if (isFullName(userInput)) {
            String[] names = userInput.split("\\s+|-");
            if (names.length >= 2) {
                String firstName = names[0];
                String lastName = names[names.length - 1];
                String middleName = "";
                for (int i = 1; i < names.length - 1; i++) {
                    middleName += names[i] + " ";
                }
                System.out.println("Imię: " + firstName);
                System.out.println("Drugie imię: " + middleName.trim());
                System.out.println("Nazwisko: " + lastName);
            }
        } else {
            System.out.println("Nie rozpoznano podanej wartości.");
        }
    }

    private static boolean isAge(String input) {
        try {
            if (input.length() == 11) {
                return false;
            }

            int age = Integer.parseInt(input);
            return age > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBirthDate(String input) {
        try {
            LocalDate.parse(input, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isPesel(String input) {
        return input.matches("^\\d{11}$");
    }

    private static boolean isFullName(String input) {
        return input.matches("^[A-Za-ząćęłńóśźżĄĆĘŁŃÓŚŹŻ]+(\\s+[A-Za-ząćęłńóśźżĄĆĘŁŃÓŚŹŻ]+)+$");
    }

    private static LocalDate getBirthDateFromPesel(String pesel) {
        int year = Integer.parseInt(pesel.substring(0, 2));
        int month = Integer.parseInt(pesel.substring(2, 4));
        int day = Integer.parseInt(pesel.substring(4, 6));
        if (month > 80) {
            month -= 80;
            year += 2000;
        } else if (month > 60) {
            month -= 60;
            year += 2200;
        } else if (month > 40) {
            month -= 40;
            year += 2100;
        } else if (month > 20) {
            month -= 20;
            year += 2000;
        } else {
            year += 1900;
        }
        return LocalDate.of(year, month, day);
    }
}