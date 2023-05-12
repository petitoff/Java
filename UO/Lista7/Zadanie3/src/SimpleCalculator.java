import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {

    private JFrame frame;
    private JTextField textField;
    private JLabel lastNumberLabel;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, equalButton, clearButton;
    private JPanel panel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private String currentNumber = "";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SimpleCalculator calculator = new SimpleCalculator();
                calculator.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SimpleCalculator() {
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(270, 400);
        frame.setResizable(false);

        textField = new JTextField();
        textField.setBounds(10, 10, 225, 50);
        textField.setEditable(false);

        lastNumberLabel = new JLabel("");
        lastNumberLabel.setBounds(10, 60, 225, 20);
        lastNumberLabel.setHorizontalAlignment(JLabel.RIGHT);

        panel = new JPanel();
        panel.setBounds(10, 90, 225, 250);
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(e -> {
                textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
                currentNumber += ((JButton) e.getSource()).getText();
                lastNumberLabel.setText("Ostatnia liczba: " + currentNumber);
            });
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        ActionListener operatorActionListener = new OperatorButtonListener();
        addButton.addActionListener(operatorActionListener);
        subButton.addActionListener(operatorActionListener);
        mulButton.addActionListener(operatorActionListener);
        divButton.addActionListener(operatorActionListener);
        equalButton.addActionListener(new EqualButtonListener());
        clearButton.addActionListener(e -> textField.setText(""));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.add(textField);
        frame.add(lastNumberLabel);
        frame.add(panel);

        frame.setLayout(null);
    }

    private class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num1 = Double.parseDouble(textField.getText());
            operator = ((JButton) e.getSource()).getText().charAt(0);
            textField.setText("");
            currentNumber = "";
        }
    }

    private class EqualButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            if (result % 1 == 0) {
                textField.setText(String.valueOf((int) result));
            } else {
                textField.setText(String.valueOf(result));
            }
            num1 = result;
            currentNumber = "";
        }
    }
}