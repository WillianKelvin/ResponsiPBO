
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class GajiController {
    GajiModel model;
    Gaji gaji;
    String dataterpilih;
    int baris, kolom;
    
    public GajiController(final GajiModel model, final Gaji gaji) {
        this.model = model;
        this.gaji = gaji;
        
        
        gaji.btnsimpan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gaji.getid().equals("")
                        ||gaji.getnama().equals("")
                        ||gaji.getposisi().equals("")
                        ||gaji.getalamat().equals("")
                        ||gaji.getnohp().equals("")
                        ||gaji.getgajipokok().equals("")
                        ||gaji.getjamlembur().equals("")
                        ||gaji.gettunjangan().equals("")
                        ||gaji.getpajak().equals("")
                        ||gaji.gettotal().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
                } else {
                    String id = gaji.getid();
                    String nama = gaji.getnama();
                    String posisi = gaji.getposisi();
                    String alamat = gaji.getalamat();
                    String nohp = gaji.getnohp();
                    String gajipokok = gaji.getgajipokok();
                    String jamlembur = gaji.getjamlembur();
                    String tunjangan = gaji.gettunjangan();
                    String pajak = gaji.getpajak();
                    String total = gaji.gettotal();       
                    model.insertGaji(id, nama, posisi, alamat, nohp, gajipokok, jamlembur, tunjangan, pajak, total);
                    
                    
                }
            }
        });
    }
}
