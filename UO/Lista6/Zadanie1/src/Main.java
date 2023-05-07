// Main.java
public class Main {
    public static void main(String[] args) {
        Husky pies1 = new Husky("Max");
        Chihuahua pies2 = new Chihuahua("Bella");
        Delfin delfin = new Delfin("Flipper");

        System.out.println(pies1);
        pies1.oddychaj();
        pies1.chodz();
        pies1.wydajDzwiek();

        System.out.println("\n" + pies2);
        pies2.oddychaj();
        pies2.chodz();
        pies2.wydajDzwiek();

        System.out.println("\n" + delfin.getNazwa());
        delfin.oddychaj();
        delfin.wydajDzwiek();
    }
}