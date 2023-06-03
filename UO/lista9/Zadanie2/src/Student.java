import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
    private final int rocznik;
    private final String nazwisko;
    private final double srednia;

    public Student(int rocznik, String nazwisko, double srednia) {
        this.rocznik = rocznik;
        this.nazwisko = nazwisko;
        this.srednia = srednia;
    }

    public static void main(String[] args) {
        List<Student> listaStudentow = new ArrayList<>();
        listaStudentow.add(new Student(2020, "Kowalski", 4.5));
        listaStudentow.add(new Student(2021, "Nowak", 3.8));
        listaStudentow.add(new Student(2020, "Zielinski", 4.5));
        listaStudentow.add(new Student(2020, "Kowalski", 4.0));

        Collections.sort(listaStudentow);

        for (Student student : listaStudentow) {
            System.out.println(student);
        }
    }

    public int getRocznik() {
        return rocznik;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getSrednia() {
        return srednia;
    }

    @Override
    public int compareTo(Student o) {
        int rocznikComparison = Integer.compare(this.rocznik, o.rocznik);
        if (rocznikComparison != 0) {
            return rocznikComparison;
        }

        int sredniaComparison = Double.compare(this.srednia, o.srednia);
        if (sredniaComparison != 0) {
            return sredniaComparison;
        }

        return this.nazwisko.compareTo(o.nazwisko);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rocznik=" + rocznik +
                ", srednia=" + srednia + '\'' +
                ", nazwisko='" + nazwisko +
                '}';
    }
}