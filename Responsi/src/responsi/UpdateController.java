
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateController {
  
    UpdateModel model;
    Update update;
    String dataterpilih;
    int baris, kolom;
    
    public UpdateController(final UpdateModel model, final Update update) {
        this.model = model;
        this.update = update;
        
        
        update.btnupdate.addActionListener(new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String id = dataterpilih;
                    String nama = update.getnama();
                    String posisi = update.getposisi();
                    String alamat = update.getalamat();
                    String nohp = update.getnohp();
                    String updatepokok = update.getgajipokok();
                    String jamlembur = update.getjamlembur();
                    String tunjangan = update.gettunjangan();
                    String pajak = update.getpajak();
                    String total = update.gettotal();
                    
                    model.updateGaji(id, nama, posisi, alamat, nohp, updatepokok, jamlembur, tunjangan, pajak, total);
                    }
            });

    }
}
