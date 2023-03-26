import java.util.Scanner;

public class BitChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę do zmiany trzeciego bitu: ");
        int a = Integer.parseInt(scanner.next());

        int numberChanged = ChangeThirdBitToTheOppositeOne(a);

        System.out.println("Wartość po zamianie trzeciego bitu: " + numberChanged);
    }

    public static int ChangeThirdBitToTheOppositeOne(int number){
        // Użyj operatora XOR do zamiany trzeciego bitu na przeciwny
        return number ^ (1 << 2);
    }
}


