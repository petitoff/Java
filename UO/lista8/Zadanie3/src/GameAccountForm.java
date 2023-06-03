import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameAccountForm {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Formularz tworzenia konta");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GameAccountPanel());
            frame.setSize(500, 350);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

class GameAccountPanel extends JPanel {
    private final JTextField nickField;
    private final JRadioButton maleRadioButton;
    private final JRadioButton femaleRadioButton;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField emailField;
    private final JButton submitButton;
    private final JLabel errorLabel;

    public GameAccountPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nickField = new JTextField(20);
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        emailField = new JTextField(20);

        maleRadioButton = new JRadioButton("Mężczyzna");
        femaleRadioButton = new JRadioButton("Kobieta");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        submitButton = new JButton("Zatwierdź");
        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);

        JScrollPane errorScrollPane = new JScrollPane(errorLabel);
        errorScrollPane.setPreferredSize(new Dimension(350, 50));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateForm();
                    errorLabel.setForeground(Color.GREEN);
                    errorLabel.setText("Formularz zatwierdzony!");
                } catch (Exception ex) {
                    errorLabel.setForeground(Color.RED);
                    errorLabel.setText(ex.getMessage());
                }
            }
        });

        add(new JLabel("Nick:"));
        add(nickField);
        add(new JLabel("Imię:"));
        add(firstNameField);
        add(new JLabel("Nazwisko:"));
        add(lastNameField);
        add(new JLabel("E-mail (@gra.pl):"));
        add(emailField);
        add(new JLabel("Płeć:"));
        add(maleRadioButton);
        add(femaleRadioButton);
        add(submitButton);
        add(errorScrollPane);
    }

    private void validateForm() throws Exception {
        // Weryfikacja nicku
        String nick = nickField.getText();
        if (nick.length() < 6 || !nick.matches(".*\\d+.*")) {
            throw new Exception("Nick musi zawierać przynajmniej 6 znaków, w tym jedną cyfrę.");
        }

        // Weryfikacja imienia
        String firstName = firstNameField.getText();
        if (!firstName.matches("^[A-Z][a-z]*$")) {
            throw new Exception("Imię musi zaczynać się z dużej litery i nie może zawierać znaków niebędącymi literami.");
        }

        // Weryfikacja nazwiska
        String lastName = lastNameField.getText();
        if (!lastName.matches("^[A-Z][a-z]*$")) {
            throw new Exception("Nazwisko musi zaczynać się z dużej litery i nie może zawierać znaków niebędącymi literami.");
        }

        // Weryfikacja e-maila
        String email = emailField.getText();
        if (!email.matches("^[\\w\\.-]+@gra\\.pl$")) {
            throw new Exception("E-mail musi kończyć się na '@gra.pl'.");
        }

        // Weryfikacja płci
        if (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected()) {
            throw new Exception("Proszę wybrać płeć.");
        }

        if (firstName.matches(".*(?:ek|usz)$")) {
            if (!maleRadioButton.isSelected()) {
                throw new Exception("Na podstawie imienia sądzimy, że jesteś mężczyzną. Proszę wybrać właściwą płeć.");
            }
        } else if (firstName.matches(".*(?:ta|na)$")) {
            if (!femaleRadioButton.isSelected()) {
                throw new Exception("Na podstawie imienia sądzimy, że jesteś kobietą. Proszę wybrać właściwą płeć.");
            }
        } else {
            throw new Exception("Imię musi kończyć się na '-ek', '-usz' dla mężczyzn lub '-ta', '-na' dla kobiet.");
        }
    }
}