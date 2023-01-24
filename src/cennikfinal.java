import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class cennikfinal extends JFrame {

    public cennikfinal() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cennik");
        setSize(500, 500);


        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columns = {"CennikID", "ID_KategoriaProduktu", "CzasWynajęcia", "Cena", "ID_Dostawa"};
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://helium.mikorosa.pl:3306/wypozyczlnia_sprzetu_elektronicznego", "adminpiotrek", "H%nWX6XVf7d!");

            String sql = "SELECT CennikID,ID_KategoriaProduktu,CzasWynajęcia,Cena,ID_Dostawa FROM Cennik";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int cennikID = rs.getInt("CennikID");
                int idKategoriaProduktu = rs.getInt("ID_KategoriaProduktu");
                int czasWynajęcia = rs.getInt("CzasWynajęcia");
                int cena = rs.getInt("Cena");
                int idDostawa = rs.getInt("ID_Dostawa");
                model.addRow(new Object[] {cennikID, idKategoriaProduktu, czasWynajęcia, cena, idDostawa});
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        JScrollPane pane = new JScrollPane(table);
        add(pane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new cennikfinal();
    }
}