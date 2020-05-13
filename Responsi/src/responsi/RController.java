
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class RController {
    Model model;
    Read read;
    Update update;
    String dataterpilih;
    int baris, kolom;
    
    public RController(final Model model, final Read read) {
        this.model = model;
        this.read = read;
        
        
        read.btnshow.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(model.getBanyakData()!= 0){
                    String datatransaksi[][]= model.read();
                    read.tabel.setModel((new JTable(datatransaksi, read.namakolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                }
            }
        });
       
        read.tabel.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            int baris = read.tabel.getSelectedRow();
            int kolom = read.tabel.getSelectedColumn();     
            
                    dataterpilih = read.tabel.getValueAt(baris, 0).toString();
                    String nama = read.tabel.getValueAt(baris, 1).toString();
                    String posisi = read.tabel.getValueAt(baris, 2).toString();
                    String gajipokok = read.tabel.getValueAt(baris, 3).toString();
                    String jamlembur = read.tabel.getValueAt(baris, 4).toString();
                    String tunjangan = read.tabel.getValueAt(baris, 5).toString();
                    String pajak = read.tabel.getValueAt(baris, 6).toString();
                    String total = read.tabel.getValueAt(baris, 7).toString();
                    
                update.fnmpeg.setText(nama);
                update.cmbposisi.setSelectedItem(posisi);
                update.fgajipokok.setText(gajipokok);
                update.fjamlembur.setText(jamlembur);
                update.ftunjangan.setText(tunjangan);
                update.fpajak.setText(pajak);
                update.ftotgaji.setText(total);
             
        }
    });

       read.tabel.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            baris = read.tabel.getSelectedRow();
            kolom = read.tabel.getSelectedColumn();   
            
        }
    });
    
       read.btndelete.addActionListener(new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    String dataterpilih = read.tabel.getValueAt(baris, 0).toString();
            int input = JOptionPane.showConfirmDialog(null, "Apa anda ingin menghapus "+dataterpilih+"?", "Pilih Opsi...", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(input == 0 ) {
                model.deleteGaji(dataterpilih);
               
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
            });
    }
}
