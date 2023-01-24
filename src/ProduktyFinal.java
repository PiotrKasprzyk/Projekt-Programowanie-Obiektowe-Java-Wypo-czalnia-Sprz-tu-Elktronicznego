import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ProduktyFinal extends JFrame {

    public ProduktyFinal() {


        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://helium.mikorosa.pl:3306/wypozyczlnia_sprzetu_elektronicznego", "adminpiotrek", "H%nWX6XVf7d!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String query = "SELECT ProduktyID, Nazwa, Kod_seryjny, Model, Dostepnosci, ID_cennik, ID_KategoriaProduktu FROM Produkty";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("ProduktyID");
            tableModel.addColumn("Nazwa");
            tableModel.addColumn("Kod_seryjny");
            tableModel.addColumn("Model");
            tableModel.addColumn("Dostepnosci");
            tableModel.addColumn("ID_cennik");
            tableModel.addColumn("ID_KategoriaProduktu");


            while (resultSet.next()) {
                int ProduktyID = resultSet.getInt("ProduktyID");
                String Nazwa = resultSet.getString("Nazwa");
                String Kod_seryjny = resultSet.getString("Kod_seryjny");
                String Model = resultSet.getString("Model");
                String Dostepnosci = resultSet.getString("Dostepnosci");
                int ID_cennik = resultSet.getInt("ID_cennik");
                int ID_KategoriaProduktu = resultSet.getInt("ID_KategoriaProduktu");
                tableModel.addRow(new Object[]{ProduktyID, Nazwa, Kod_seryjny, Model, Dostepnosci, ID_cennik, ID_KategoriaProduktu});
            }

            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setTitle("Produkty");
        setSize(800, 500);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ProduktyFinal();
    }
}