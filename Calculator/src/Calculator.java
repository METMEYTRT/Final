import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private Container container;
    private JLabel labelFirstNumber, labelSecondNumber, labelResult;
    private JTextField textFirstNumber, textSecondNumber, textResult;
    private JButton addButton, subButton, mulButton, divButton, modButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setBounds(300, 90, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        labelFirstNumber = new JLabel("First Number:");
        labelFirstNumber.setBounds(50, 30, 100, 30);
        container.add(labelFirstNumber);

        textFirstNumber = new JTextField();
        textFirstNumber.setBounds(150, 30, 200, 30);
        container.add(textFirstNumber);

        labelSecondNumber = new JLabel("Second Number:");
        labelSecondNumber.setBounds(50, 70, 100, 30);
        container.add(labelSecondNumber);

        textSecondNumber = new JTextField();
        textSecondNumber.setBounds(150, 70, 200, 30);
        container.add(textSecondNumber);

        labelResult = new JLabel("Result:");
        labelResult.setBounds(50, 110, 100, 30);
        container.add(labelResult);

        textResult = new JTextField();
        textResult.setBounds(150, 110, 200, 30);
        textResult.setEditable(false);
        container.add(textResult);


        addButton = createButton("+", 50, 160);
        subButton = createButton("-", 130, 160);
        mulButton = createButton("*", 210, 160);
        divButton = createButton("/", 290, 160);
        modButton = createButton("%", 50, 220);
        clearButton = createButton("Clear", 130, 220, 230, 50);
    }

    private JButton createButton(String text, int x, int y) {
        return createButton(text, x, y, 70, 50);
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.addActionListener(this);
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE); 
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        container.add(button);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(textFirstNumber.getText());
            double num2 = Double.parseDouble(textSecondNumber.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                result = num1 / num2;
            } else if (e.getSource() == modButton) {
                result = num1 % num2;
            } else if (e.getSource() == clearButton) {
                textFirstNumber.setText("");
                textSecondNumber.setText("");
                textResult.setText("");
                return;
            }

            textResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            textResult.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}
