public class Delfin extends Zwierze implements Ssak {
    public Delfin(String nazwa) {
        super(nazwa);
    }

    @Override
    public void oddychaj() {
        System.out.println("Delfin oddycha.");
    }

    @Override
    public void wydajDzwiek() {
        System.out.println("Delfin piszczy.");
    }
}