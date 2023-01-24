import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class kliencifinal extends JFrame {

    public kliencifinal() {

        // Utwórz połączenie z bazą danych
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://helium.mikorosa.pl:3306/wypozyczlnia_sprzetu_elektronicznego", "adminpiotrek", "H%nWX6XVf7d!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Zapytanie do pobrania danych z tabeli "Produkty"
        String query = "SELECT login,email,address,phone FROM users";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("login");
            tableModel.addColumn("email");
            tableModel.addColumn("address");
            tableModel.addColumn("phone");


            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");

                tableModel.addRow(new Object[]{login, email, address, phone});
            }

            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setTitle("Klienci");
        setSize(800, 500);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new kliencifinal();
    }
}