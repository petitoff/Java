import java.util.Scanner;

public class Podslowo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj pierwsze słowo: ");
        String s1 = scanner.nextLine();

        System.out.print("Podaj drugie słowo: ");
        String s2 = scanner.nextLine();

        if (isSubstring(s1, s2)) {
            System.out.println(s1 + " jest podsłowem " + s2);
        } else {
            System.out.println(s1 + " nie jest podsłowem " + s2);
        }
    }

    public static boolean isStringContained(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (s2.charAt(i + j) != s1.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return true;
            }
        }
        return false;
    }
}