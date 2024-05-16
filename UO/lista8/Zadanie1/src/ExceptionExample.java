import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
        // Przykład ArithmeticException
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println("Wynik: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Błąd: Nie można dzielić przez zero.");
        }

        // Przykład NumberFormatException
        try {
            String numberStr = "ABC";
            int number = Integer.parseInt(numberStr);
            System.out.println("Wartość liczbowa: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Błąd: Niepoprawny format liczby.");
        }

        // Przykład ArrayIndexOutOfBoundsException
        try {
            int[] array = {1, 2, 3};
            int element = array[4];
            System.out.println("Element: " + element);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Błąd: Indeks tablicy poza zakresem.");
        }
    }
}
