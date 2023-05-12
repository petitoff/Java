import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FormularzPESEL {

    private JFrame frame;
    private JPanel panel;
    private JTextField imieTextField, nazwiskoTextField, peselTextField;
    private JButton submitButton;
    private JLabel resultLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FormularzPESEL formularz = new FormularzPESEL();
                formularz.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FormularzPESEL() {
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Formularz PESEL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        imieTextField = createHintTextField("Imię");
        nazwiskoTextField = createHintTextField("Nazwisko");
        peselTextField = createHintTextField("Numer PESEL");
        peselTextField.setToolTipText("Wprowadź 11-cyfrowy numer PESEL");

        submitButton = new JButton("Zatwierdź");
        submitButton.addActionListener(e -> {
            String imie = imieTextField.getText();
            String nazwisko = nazwiskoTextField.getText();
            String pesel = peselTextField.getText();

            if (containsOnlyLetters(imie) || containsOnlyLetters(nazwisko)) {
                resultLabel.setText("Imię i nazwisko mogą zawierać tylko litery");
            } else if (isValidPESEL(pesel)) {
                resultLabel.setText("<html>Imię: " + imie + "<br/>Nazwisko: " + nazwisko + "<br/>PESEL: " + pesel + "</html>");
            } else {
                resultLabel.setText("Nieprawidłowy numer PESEL");
            }
        });

        resultLabel = new JLabel();
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        panel.add(new JLabel("Imię:"));
        panel.add(imieTextField);
        panel.add(new JLabel("Nazwisko:"));
        panel.add(nazwiskoTextField);
        panel.add(new JLabel("PESEL:"));
        panel.add(peselTextField);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        frame.add(panel, BorderLayout.NORTH);
        frame.add(submitButton, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);
    }

    private JTextField createHintTextField(String hint) {
        JTextField textField = new JTextField(hint);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(hint)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(hint);
                }
            }
        });

        return textField;
    }

    private boolean containsOnlyLetters(String text) {
        return !text.chars().allMatch(Character::isLetter);
    }

    private boolean isValidPESEL(String pesel) {
        if (pesel == null || pesel.length() != 11) {
            return false;
        }

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int digit = Character.getNumericValue(pesel.charAt(i));
            sum += digit * weights[i];
        }

        int lastDigit = Character.getNumericValue(pesel.charAt(10));
        int checkSum = 10 - (sum % 10);

        if (checkSum == 10) {
            checkSum = 0;
        }

        return checkSum == lastDigit;
    }
}