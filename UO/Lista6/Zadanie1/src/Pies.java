public class Pies extends Zwierze implements Ssak, Ladowe{
    public Pies(String nazwa) {
        super(nazwa);
    }

    @Override
    public void chodz() {
        System.out.println("Pies chodzi.");
    }

    @Override
    public void oddychaj() {
        System.out.println("Pies oddycha.");
    }

    @Override
    public void wydajDzwiek() {
        System.out.println("Pies szczeka.");
    }

    @Override
    public String toString(){
        return "Pies o nazawie: " + getNazwa();
    }
}
