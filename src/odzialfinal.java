import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class odzialfinal extends JFrame {

    public odzialfinal() {


        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://helium.mikorosa.pl:3306/wypozyczlnia_sprzetu_elektronicznego", "adminpiotrek", "H%nWX6XVf7d!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String query = "SELECT OdziałID, Miejscowść, numer_telefonu, Adres, Adres_EMail FROM Odział";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("OdziałID");
            tableModel.addColumn("Miejscowść");
            tableModel.addColumn("Numer telefonu");
            tableModel.addColumn("Adres");
            tableModel.addColumn("Adres e-mail");


            while (resultSet.next()) {
                int OdziałID = resultSet.getInt("OdziałID");
                String Miejscowść = resultSet.getString("Miejscowść");
                String numer_telefonu = resultSet.getString("numer_telefonu");
                String Adres = resultSet.getString("Adres");
                String Adres_EMail = resultSet.getString("Adres_EMail");
                tableModel.addRow(new Object[]{OdziałID, Miejscowść, numer_telefonu, Adres, Adres_EMail});
            }


            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        setTitle("Dane z tabeli 'Odział'");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new odzialfinal();
    }
}