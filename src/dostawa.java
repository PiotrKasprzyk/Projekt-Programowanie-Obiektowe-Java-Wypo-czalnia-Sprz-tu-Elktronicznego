import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class dostawa extends JFrame {

    public dostawa() {


        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://helium.mikorosa.pl:3306/wypozyczlnia_sprzetu_elektronicznego", "adminpiotrek", "H%nWX6XVf7d!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT DostawaID, Kurier, Odbiór_Osobisty FROM dostawa";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("DostawaID");
            tableModel.addColumn("Kurier");
            tableModel.addColumn("Odbiór_Osobisty");


            while (resultSet.next()) {
                int DostawaID = resultSet.getInt("DostawaID");
                String Kurier = resultSet.getString("Kurier");
                String Odbiór_Osobisty = resultSet.getString("Odbiór_Osobisty");
                tableModel.addRow(new Object[]{DostawaID, Kurier, Odbiór_Osobisty});
            }


            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        setTitle("Dane z tabeli 'Dostawa'");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new dostawa();
    }
}