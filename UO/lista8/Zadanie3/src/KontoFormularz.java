import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KontoFormularz extends JFrame {
    private JTextField nickField, imieField, nazwiskoField, emailField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderGroup;

    public KontoFormularz() {
        setTitle("Formularz tworzenia konta w grze");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Nick:"));
        nickField = new JTextField();
        add(nickField);

        add(new JLabel("Imię:"));
        imieField = new JTextField();
        add(imieField);

        add(new JLabel("Nazwisko:"));
        nazwiskoField = new JTextField();
        add(nazwiskoField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Płeć:"));
        maleRadioButton = new JRadioButton("Mężczyzna");
        femaleRadioButton = new JRadioButton("Kobieta");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        add(genderPanel);

        JButton submitButton = new JButton("Zatwierdź");
        submitButton.addActionListener(e -> {
            try {
                validateForm();
                JOptionPane.showMessageDialog(null, "Formularz zatwierdzony!");
            } catch (KontoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(submitButton);
    }

    private void validateForm() throws KontoException {
        String nick = nickField.getText();
        String imie = imieField.getText();
        String nazwisko = nazwiskoField.getText();
        String email = emailField.getText();
        boolean isMale = maleRadioButton.isSelected();
        boolean isFemale = femaleRadioButton.isSelected();

        if (nick.length() < 6 || !nick.matches(".*\\d.*")) {
            throw new KontoException("Nick musi składać się z przynajmniej sześciu znaków i zawierać przynajmniej jedną cyfrę.");
        }

        if (!imie.matches("[A-Z][a-z]*")) {
            throw new KontoException("Imię musi zaczynać się z dużej litery i nie może zawierać znaków nie będących literami.");
        }

        if (!nazwisko.matches("[A-Z][a-z]*")) {
            throw new KontoException("Nazwisko musi zaczynać się z dużej litery i nie może zawierać znaków nie będących literami.");
        }

        if (!email.endsWith("@gra.pl")) {
            throw new KontoException("Email musi kończyć się na @gra.pl.");
        }

        if (!isMale && !isFemale) {
            throw new KontoException("Wybierz płeć.");
        }

        if (isMale && !(imie.endsWith("ek") || imie.endsWith("usz"))) {
            throw new KontoException("Imię nie odpowiada wybranej płci męskiej.");
        }

        if (isFemale && !(imie.endsWith("ta") || imie.endsWith("na"))) {
            throw new KontoException("Imię nie odpowiada wybranej płci żeńskiej.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new KontoFormularz().setVisible(true);
            }
        });
    }
}
