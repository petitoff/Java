import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbe naturalna n: ");
        int n = scanner.nextInt();

        // oblicz szerokość kolumny, zależną od największej liczby w tabeli
        int columnWidth = Integer.toString(n * n).length() + 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    System.out.printf("%" + columnWidth + "s", "");
                } else if (i == 0) {
                    System.out.printf("%" + columnWidth + "d", j);
                } else if (j == 0) {
                    System.out.printf("%" + columnWidth + "d", i);
                } else {
                    System.out.printf("%" + columnWidth + "d", i * j);
                }
            }
            System.out.println();
        }
    }
}