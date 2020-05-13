
package responsi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Model {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi";   
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;       
    
    public Model(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    

    
    public String[][] read() {      
        try{
            int jmldata = 0;           
            String data[][] = new String[getBanyakData()][10];   
            String query = "Select * from `pegawai`";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()) {
                data[jmldata][0] = resultset.getString("id");
                data[jmldata][1] = resultset.getString("nama");
                data[jmldata][2] = resultset.getString("posisi");
                data[jmldata][3] = resultset.getString("gaji_pokok");
                data[jmldata][4] = resultset.getString("jam_lembur");
                data[jmldata][5] = resultset.getString("tunjangan");
                data[jmldata][6] = resultset.getString("total");
                jmldata = jmldata+1;
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
        
    public void updateGaji(String id, String nama, String posisi, String alamat, String nohp, String gajipokok, String jamlembur, String tunjangan, String pajak, String total) {
        try {
            String query = "UPDATE `pegawai` SET nama = '"+nama+"',posisi = "+posisi+",alamat = '"+alamat+"',no_hp = '"+nohp+"',gaji_pokok = "+gajipokok+", jam_lembur = '"+jamlembur+"', tunjangan = '"+tunjangan+"', pajak = '"+pajak+"', total = '"+total+"' WHERE id = '"+id+"' ";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil diupdate");
            JOptionPane.showMessageDialog(null, "Data Berhasil di-update");
        }catch(Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
        
        public void deleteGaji(String id){
            try{
                String query = "DELETE FROM `pegawai` WHERE id = "+id+"";
                statement = (Statement)koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            }catch(SQLException sql) {
                System.out.println(sql.getMessage());
            }
        }
}
