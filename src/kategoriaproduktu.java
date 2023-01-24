import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class  kategoriaproduktu extends JFrame {

    public kategoriaproduktu () {


        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://helium.mikorosa.pl:3306/wypozyczlnia_sprzetu_elektronicznego", "adminpiotrek", "H%nWX6XVf7d!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String query = "SELECT KategoriaProduktuID, urządzenia_mobilne, akcesoria, urządzenia_domowe, Podzespoły_Komputerowe, Urządzenia_preferencyjne, TV_i_Audio FROM kategoria_produktu";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("KategoriaProduktuID");
            tableModel.addColumn("urządzenia_mobilne");
            tableModel.addColumn("akcesoria");
            tableModel.addColumn("urządzenia_domowe");
            tableModel.addColumn("Podzespoły_Komputerowe");
            tableModel.addColumn("Urządzenia_preferencyjne");
            tableModel.addColumn("TV_i_Audio");


            while (resultSet.next()) {
                int KategoriaProduktuID = resultSet.getInt("KategoriaProduktuID");
                String urządzenia_mobilne = resultSet.getString("urządzenia_mobilne");
                String akcesoria = resultSet.getString("akcesoria");
                String urządzenia_domowe = resultSet.getString("urządzenia_domowe");
                String Podzespoły_Komputerowe = resultSet.getString("Podzespoły_Komputerowe");
                String Urządzenia_preferencyjne = resultSet.getString("Urządzenia_preferencyjne");
                String TV_i_Audio = resultSet.getString("TV_i_Audio");


                tableModel.addRow(new Object[]{KategoriaProduktuID, urządzenia_mobilne, akcesoria,urządzenia_domowe,Podzespoły_Komputerowe,Urządzenia_preferencyjne,TV_i_Audio});
            }


            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setTitle("Kategoria produktu");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new kategoriaproduktu ();
    }
}