
package responsi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Update extends JFrame {
    
    JLabel lidpeg = new JLabel("ID Pegawai");
    JTextField fidpeg = new JTextField();
    
    JLabel lnmpeg = new JLabel("Nama");
    JTextField fnmpeg = new JTextField();
    
    JLabel lposisi = new JLabel("Posisi");
    String[] posisi =
            {"Direktur", "Manager", "Programmer"};
    JComboBox cmbposisi = new JComboBox(posisi);
    
    JLabel lalamat = new JLabel("Alamat");
    JTextField falamat = new JTextField();
    
    JLabel lnohp = new JLabel("No HP");
    JTextField fnohp = new JTextField();
    
    JLabel lgajipokok = new JLabel("Gaji Pokok");
    JTextField fgajipokok = new JTextField();
    
    JLabel ljamlembur = new JLabel("Jam Lembur");
    JTextField fjamlembur = new JTextField();
    
    JLabel ltunjangan = new JLabel("Tunjangan");
    JTextField ftunjangan = new JTextField();
    
    JLabel lpajak = new JLabel("Pajak");
    JTextField fpajak = new JTextField();
    
    JLabel ltotgaji = new JLabel("Total Gaji");
    JTextField ftotgaji = new JTextField();
    
    JButton btnhitung = new JButton(" HITUNG ");
    JButton btnupdate = new JButton(" SIMPAN ");
    
    private Image image;
    
    
    JButton btnhome = new JButton(" HOME ");
    JButton btngaji = new JButton(" GAJI ");
    JButton btnread = new JButton(" READ ");
    JButton btnpetunjuk = new JButton(" PETUNJUK ");
    JButton btnadmin = new JButton(" ADMIN ");
    
    JLabel lapp = new JLabel("APLIKASI PERHITUNGAN GAJI PT.VETERAN JAYA");
    
    public Update(){
        image = new ImageIcon(getClass().getResource("backgroundd.jpg")).getImage();
         this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
         }
         });
         
        setTitle("Gaji");
        setDefaultCloseOperation(3);
        setSize(650, 550);
        
        setLayout(null);
        add(btnhome);
        btnhome.setBounds(10, 10, 120, 80);
        add(btngaji);
        btngaji.setBounds(10, 100, 120, 80);
        add(btnread);
        btnread.setBounds(10, 190, 120, 80);
        add(btnpetunjuk);
        btnpetunjuk.setBounds(10, 280, 120, 80);
        
        add(lidpeg);
        lidpeg.setBounds(150, 50, 100, 20);
        add(fidpeg);
        fidpeg.setBounds(250, 50, 200, 20);
        
        
        add(lnmpeg);
        lnmpeg.setBounds(150, 80, 100, 20);
        add(fnmpeg);
        fnmpeg.setBounds(250, 80, 200, 20);
        
        add(lposisi);
        lposisi.setBounds(150, 110, 100, 20);
        add(cmbposisi);
        cmbposisi.setBounds(250, 110, 200, 20);
        
        add(lalamat);
        lalamat.setBounds(150, 140, 100, 20);
        add(falamat);
        falamat.setBounds(250, 140, 300, 20);
        
        add(lnohp);
        lnohp.setBounds(150, 170, 100, 20);
        add(fnohp);
        fnohp.setBounds(250, 170, 200, 20);
        
        add(lgajipokok);
        lgajipokok.setBounds(150, 200, 100, 20);
        add(fgajipokok);
        fgajipokok.setBounds(250, 200, 200, 20);
        
        add(ljamlembur);
        ljamlembur.setBounds(150, 230, 100, 20);
        add(fjamlembur);
        fjamlembur.setBounds(250, 230, 200, 20);
        
        add(ltunjangan);
        ltunjangan.setBounds(150, 260, 100, 20);
        add(ftunjangan);
        ftunjangan.setBounds(250, 260, 200, 20);
        
        add(lpajak);
        lpajak.setBounds(150, 290, 100, 20);
        add(fpajak);
        fpajak.setBounds(250, 290, 200, 20);
        
        add(ltotgaji);
        ltotgaji.setBounds(150, 320, 100, 20);
        add(ftotgaji);
        ftotgaji.setBounds(250, 320, 200, 20);
        
        add(btnhitung);
        btnhitung.setBounds(500, 190, 120, 80);
        add(btnupdate);
        btnupdate.setBounds(500, 290, 120, 80);
        add(btnadmin);
        btnadmin.setBounds(500, 10, 120, 80);
        
        add(lapp);
        lapp.setBounds(180, 480, 300, 25);
        
        setVisible(true);
        
        
        btnhome.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Home home = new Home();
                dispose();
            }
        });
        
        
        btngaji.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MGaji gaji = new MGaji();
                dispose();
            }
        });
        
        
        btnread.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MRead read = new MRead();
                dispose();
            }
        });
        
        btnpetunjuk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Petunjuk petunjuk = new Petunjuk();
                dispose();
            }
        });
        
        btnadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ViewLogin login = new ViewLogin();
                dispose();
            }
        });
        
        
        btnhitung.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int jamlembur = Integer.parseInt(fjamlembur.getText());
                int tunjangan = jamlembur * 15000;
                String stunjangan = Integer.toString(tunjangan);
                ftunjangan.setText(stunjangan);
                
                int gajipokok = Integer.parseInt(fgajipokok.getText());
                int pajak = gajipokok/100*1;
                String spajak = Integer.toString(pajak);
                fpajak.setText(spajak);
                
                int total = gajipokok + tunjangan - pajak;
                String stotal = Integer.toString(total);
                ftotgaji.setText(stotal);
            }
        });
        
        
    }
    
     
    public String getid(){
       return fidpeg.getText();
    }
    public String getnama(){
       return fnmpeg.getText();
    }
    public String getposisi(){
       return (String) cmbposisi.getSelectedItem();
    }
    public String getalamat(){
       return falamat.getText();
    }
    public String getnohp(){
       return fnohp.getText();
    }
    public String getgajipokok(){
       return fgajipokok.getText();
    }
    public String getjamlembur(){
        return fjamlembur.getText();
    }
    public String gettunjangan(){
        return ftunjangan.getText();
    }
    public String getpajak(){
        return fpajak.getText();
    }
    public String gettotal(){
        return ftotgaji.getText();
    }
}
