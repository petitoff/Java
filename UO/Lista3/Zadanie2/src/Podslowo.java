import java.util.Scanner;

public class Podslowo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj pierwsze słowo: ");
        String s1 = scanner.nextLine();

        System.out.print("Podaj drugie słowo: ");
        String s2 = scanner.nextLine();

        if (czyPodslowo(s1, s2)) {
            System.out.println(s1 + " jest podsłowem " + s2);
        } else {
            System.out.println(s1 + " nie jest podsłowem " + s2);
        }
    }

    public static boolean czyPodslowo(String slowo, String podslowo) {
        // Sprawdzenie, czy podslowo jest dłuższe niż slowo. Jeśli tak, to nie może być jego podciągiem.
        if (podslowo.length() > slowo.length()) {
            return false;
        }

        // Przeszukujemy każdy możliwy początek podciągu w slowo.
        for (int i = 0; i <= slowo.length() - podslowo.length(); i++) {
            int j;
            // Dla każdego początku porównujemy znaki jeden po drugim.
            for (j = 0; j < podslowo.length(); j++) {
                if (slowo.charAt(i + j) != podslowo.charAt(j)) {
                    break;
                }
            }
            // Jeśli doszliśmy do końca podslowo bez przerwania pętli,
            // oznacza to, że znaleźliśmy pełne dopasowanie.
            if (j == podslowo.length()) {
                return true;
            }
        }

        // Jeśli nie znaleziono dopasowania, zwracamy false.
        return false;
    }

    public static boolean isSubstringContained(String substring, String string) {
        int substringLength = substring.length();
        int stringLength = string.length();
        for (int i = 0; i <= stringLength - substringLength; i++) {
            int j;
            for (j = 0; j < substringLength; j++) {
                if (string.charAt(i + j) != substring.charAt(j)) {
                    break;
                }
            }
            if (j == substringLength) {
                return true;
            }
        }
        return false;
    }

}