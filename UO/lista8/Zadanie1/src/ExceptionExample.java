import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionExample {

    public static void main(String[] args) {
        try {
            // Przykład 1: FileNotFoundException
//            File file = new File("nonexistent_file.txt");
            File file = new File("C:\\Users\\petit\\Desktop\\repos\\Java\\UO\\lista8\\Zadanie1\\src\\example.txt");
            Scanner scanner = new Scanner(file);


            // Przykład 2: IOException
            throw new IOException("An I/O error occurred.");

        } catch (FileNotFoundException e) {
            System.out.println("Przykład 1: FileNotFoundException");
            System.out.println("Nie można znaleźć pliku: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Przykład 2: IOException");
            System.out.println("Wystąpił błąd wejścia/wyjścia: " + e.getMessage());
        }

        try {
            // Przykład 3: NullPointerException
            String nullString = null;
            System.out.println(nullString.length());

        } catch (NullPointerException e) {
            System.out.println("Przykład 3: NullPointerException");
            System.out.println("Próba odwołania się do obiektu, który ma wartość null: " + e.getMessage());
        }
    }
}