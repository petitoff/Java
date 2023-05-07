public abstract class Zwierze {
    private String nazwa;

    public Zwierze(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public abstract void wydajDzwiek();
}
