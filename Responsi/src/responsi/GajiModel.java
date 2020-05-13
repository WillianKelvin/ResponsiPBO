
package responsi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class GajiModel {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;    
    
    public GajiModel(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    

    public void insertGaji(String id, String nama, String posisi, String alamat, String nohp, String gajipokok, String jamlembur, String tunjangan, String pajak, String total) {
        try{
            String query = "INSERT INTO `pegawai`(`id`,`nama`,`posisi`,`alamat`,`no_hp`,`gaji_pokok`, `jam_lembur`, `tunjangan`, `pajak`, `total`) VALUES ('"+id+"', '"+nama+"','"+posisi+"','"+alamat+"','"+nohp+"','"+gajipokok+"', '"+jamlembur+"', '"+tunjangan+"', '"+pajak+"', '"+total+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);          
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch(Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    
    public String[][] readGaji() {     
        try{
            int jmldata = 0;       
            String data[][] = new String[getBanyakData()][10];   
            String query = "Select * from `pegawai`";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()) {
                data[jmldata][0] = resultset.getString("id");
                data[jmldata][1] = resultset.getString("nama");
                data[jmldata][2] = resultset.getString("posisi");
                data[jmldata][3] = resultset.getString("alamat");
                data[jmldata][4] = resultset.getString("no_hp");
                data[jmldata][5] = resultset.getString("gaji_pokok");
                data[jmldata][6] = resultset.getString("jam_lembur");
                data[jmldata][7] = resultset.getString("tunjangan");
                data[jmldata][8] = resultset.getString("pajak");
                data[jmldata][9] = resultset.getString("total");
                jmldata = jmldata+1;
            }
            return data;
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String[][] searchGaji(String cari) {
        try{
            int jmldata = 0;
            String query = "SELECT * FROM `pegawai` where nama like '%"+cari+"%'";
            ResultSet resultset = statement.executeQuery(query);
            
            String data[][] = new String[getBanyakData()][10];
            while(resultset.next()) {
                data[jmldata][0] = resultset.getString("id");
                data[jmldata][1] = resultset.getString("nama");
                data[jmldata][2] = resultset.getString("posisi");
                data[jmldata][3] = resultset.getString("alamat");
                data[jmldata][4] = resultset.getString("no_hp");
                data[jmldata][5] = resultset.getString("gaji_pokok");
                data[jmldata][6] = resultset.getString("jam_lembur");
                data[jmldata][7] = resultset.getString("tunjangan");
                data[jmldata][8] = resultset.getString("pajak");
                data[jmldata][9] = resultset.getString("total");
                jmldata++;
            }
            return data;
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
        public int getBanyakData() {
            int jmldata = 0;
            try{
                statement = (Statement)koneksi.createStatement();
                String query = "Select * from `pegawai`";
                ResultSet resultset = statement.executeQuery(query);
                while(resultset.next()) {
                    jmldata++;
                }
                return jmldata;
            } catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return 0;
            }
        }
    
}
