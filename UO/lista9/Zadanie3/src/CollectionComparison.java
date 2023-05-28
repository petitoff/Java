import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionComparison {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        int numberOfElements = 100000;

        // Dodawanie elementów
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList - czas dodawania: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList - czas dodawania: " + (endTime - startTime) + " ms");

        // Usuwanie elementów
        startTime = System.currentTimeMillis();
        for (int i = numberOfElements - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList - czas usuwania: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for (int i = numberOfElements - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList - czas usuwania: " + (endTime - startTime) + " ms");
    }
}