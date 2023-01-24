import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logowanie extends JFrame implements ActionListener {


    JLabel lblUsername, lblPassword;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnLogin, btnCancel;

    public logowanie() {

        setTitle("Login");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        setLayout(new GridLayout(3, 2));


        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");


        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);


        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(btnLogin);
        add(btnCancel);


        setVisible(true);
    }

    public static void main(String[] args) {
        new logowanie();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {

            String username = txtUsername.getText();
            char[] password = txtPassword.getPassword();


            if (username.equals("admin") && new String(password).equals("password")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
        } else if (e.getSource() == btnCancel) {
            System.exit(0);
        }
    }
}