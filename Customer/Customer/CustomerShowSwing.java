import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerShowSwing extends JFrame {

    private JLabel idLabel, lastNameLabel, firstNameLabel, phoneLabel;
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton previousButton, nextButton;
    private int currentCustomerIndex = 0;

    private String[][] customerData = {
            {"1", "Chenda", "Sovisal", "092888999"},
            {"2", "Kom", "Lina", "092000999"},
            {"3", "Chan", "Seyha", "092777666"}
    };
    public CustomerShowSwing() {
        setTitle("Customer Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);
        setLocationRelativeTo(null);

        idLabel = new JLabel("ID:");
        idField = new JTextField(10);
        idField.setEditable(false);

        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(10);
        lastNameField.setEditable(false);

        firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(10);
        firstNameField.setEditable(false);

        phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField(10);
        phoneField.setEditable(false);


        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");

        JPanel contentPane = new JPanel(new GridLayout(5, 2, 10, 10));
        contentPane.add(idLabel);
        contentPane.add(idField);
        contentPane.add(lastNameLabel);
        contentPane.add(lastNameField);
        contentPane.add(firstNameLabel);
        contentPane.add(firstNameField);
        contentPane.add(phoneLabel);
        contentPane.add(phoneField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        contentPane.add(buttonPanel);

        add(contentPane);

        displayCustomer(currentCustomerIndex);

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousCustomer();
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextCustomer();
            }
        });
    }

    private void displayCustomer(int index) {
        idField.setText(customerData[index][0]);
        lastNameField.setText(customerData[index][1]);
        firstNameField.setText(customerData[index][2]);
        phoneField.setText(customerData[index][3]);
    }

    private void previousCustomer() {
        if (currentCustomerIndex > 0) {
            currentCustomerIndex--;
            displayCustomer(currentCustomerIndex);
        }
    }
    private void nextCustomer() {
        if (currentCustomerIndex < customerData.length - 1) {
            currentCustomerIndex++;
            displayCustomer(currentCustomerIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerShowSwing().setVisible(true);
            }
        });
    }
}