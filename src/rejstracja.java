import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class rejstracja extends JFrame {
    private JTextField loginField, emailField, birthdateField, addressField, phoneField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private Connection connection;

    public rejstracja() {
        super("User Registration");
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Username:"));
        panel.add(loginField = new JTextField(20));
        panel.add(new JLabel("Password:"));
        panel.add(passwordField = new JPasswordField(20));
        panel.add(new JLabel("Email:"));
        panel.add(emailField = new JTextField(20));
        panel.add(new JLabel("Birthdate:"));
        panel.add(birthdateField = new JTextField(20));
        panel.add(new JLabel("Address:"));
        panel.add(addressField = new JTextField(20));
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField = new JTextField(20));

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(registerButton = new JButton("Register"));
        add(buttonPanel, BorderLayout.SOUTH);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://helium.mikorosa.pl:3306/wypozyczlnia_sprzetu_elektronicznego", "adminpiotrek", "H%nWX6XVf7d!");
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO users (login, password, email, birthdate, address, phone) VALUES (?, ?, ?, ?, ?, ?)");
                    statement.setString(1, loginField.getText());
                    statement.setString(2, new String(passwordField.getPassword()));
                    statement.setString(3, emailField.getText());
                    statement.setString(4, birthdateField.getText());
                    statement.setString(5, addressField.getText());
                    statement.setString(6, phoneField.getText());
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(rejstracja.this, "User registered successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rejstracja.this, "Error registering user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rejstracja.this, "Error closing connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new rejstracja();
    }
}