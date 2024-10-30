import javax.swing.*;
import java.awt.*;

public class SimpleCalculator extends JFrame {
    private JTextField inputField1;
    private JTextField inputField2;
    private JLabel resultLabel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Components
        inputField1 = new JTextField(8);
        inputField2 = new JTextField(8);
        resultLabel = new JLabel("Result: ");
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("÷");

        // Layout
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Number 1: "), gbc);
        gbc.gridx = 1;
        add(inputField1, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Number 2: "), gbc);
        gbc.gridx = 1;
        add(inputField2, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(addButton, gbc);
        gbc.gridx = 1;
        add(subtractButton, gbc);
        gbc.gridx = 0; gbc.gridy = 3;
        add(multiplyButton, gbc);
        gbc.gridx = 1;
        add(divideButton, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(resultLabel, gbc);

        // Event listeners with lambda expressions
        addButton.addActionListener(e -> performCalculation('+'));
        subtractButton.addActionListener(e -> performCalculation('-'));
        multiplyButton.addActionListener(e -> performCalculation('*'));
        divideButton.addActionListener(e -> performCalculation('/'));
    }

    private void performCalculation(char operator) {
        try {
            double number1 = Double.parseDouble(inputField1.getText());
            double number2 = Double.parseDouble(inputField2.getText());
            double result = 0;

            switch (operator) {
                case '+': result = number1 + number2; break;
                case '-': result = number1 - number2; break;
                case '*': result = number1 * number2; break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        resultLabel.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}
