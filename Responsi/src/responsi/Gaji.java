
package responsi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gaji extends JFrame {
    
    JLabel lidpeg = new JLabel("ID Pegawai");
    JLabel lnmpeg = new JLabel("Nama");
    JLabel lposisi = new JLabel("Posisi");
    JLabel lalamat = new JLabel("Alamat");
    JLabel lnohp = new JLabel("No HP");
    JLabel lgajipokok = new JLabel("Gaji Pokok");
    JLabel ljamlembur = new JLabel("Jam Lembur");
    JLabel ltunjangan = new JLabel("Tunjangan");
    JLabel lpajak = new JLabel("Pajak");
    JLabel ltotgaji = new JLabel("Total Gaji");
    
    JTextField fidpeg = new JTextField();    
    JTextField fnmpeg = new JTextField();  
    JTextField falamat = new JTextField();  
    JTextField fnohp = new JTextField(); 
    JTextField fgajipokok = new JTextField();
    JTextField fjamlembur = new JTextField();
    JTextField ftunjangan = new JTextField();
    JTextField fpajak = new JTextField();
    JTextField ftotgaji = new JTextField();
    
    String[] posisi =
            {"Direktur", "Manager", "Programmer","Surveyor"};
    JComboBox cmbposisi = new JComboBox(posisi); 
    
    JButton btnhitung = new JButton(" HITUNG ");
    JButton btnsimpan = new JButton(" SIMPAN ");
    
    private Image image;
    
    JButton btnhome = new JButton(" Home ");
    JButton btngaji = new JButton(" Gaji ");
    JButton btnread = new JButton(" Data ");
    JButton btnpetunjuk = new JButton(" Petunjuk ");
    JButton btnadmin = new JButton(" Admin ");
    
    JLabel lapp = new JLabel("APLIKASI PERHITUNGAN GAJI PT.VETERAN JAYA");
    
    public Gaji(){
        image = new ImageIcon(getClass().getResource("bag.jpeg")).getImage();
         this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
         }
         });
         
        setTitle("Gaji");
        
        
        setLayout(null);
        add(btnhome);
        add(btngaji);
        add(btnread);
        add(btnpetunjuk);
        add(lidpeg);
        add(fidpeg);
        add(lnmpeg);
        add(fnmpeg);
        add(lposisi);
        add(cmbposisi);
        add(lalamat);
        add(falamat);
        add(lnohp);
        add(fnohp);
        add(lgajipokok);
        add(fgajipokok);
        add(ljamlembur);
        add(fjamlembur);
        add(ltunjangan);
        add(ftunjangan);
        add(lpajak);
        add(fpajak);
        add(ltotgaji);
        add(ftotgaji);
        add(btnhitung);
        add(btnsimpan);
        add(btnadmin);
        add(lapp);
        
        
        btnhome.setBounds(10, 10, 120, 80);        
        btngaji.setBounds(10, 100, 120, 80);        
        btnread.setBounds(10, 190, 120, 80);       
        btnpetunjuk.setBounds(10, 280, 120, 80);         
        
        lidpeg.setBounds(150, 50, 100, 20);       
        fidpeg.setBounds(250, 50, 200, 20);                
        lnmpeg.setBounds(150, 80, 100, 20);       
        fnmpeg.setBounds(250, 80, 200, 20);              
        lposisi.setBounds(150, 110, 100, 20);       
        cmbposisi.setBounds(250, 110, 200, 20);               
        lalamat.setBounds(150, 140, 100, 20);       
        falamat.setBounds(250, 140, 300, 20);               
        lnohp.setBounds(150, 170, 100, 20);       
        fnohp.setBounds(250, 170, 200, 20);                
        lgajipokok.setBounds(150, 200, 100, 20);       
        fgajipokok.setBounds(250, 200, 200, 20);              
        ljamlembur.setBounds(150, 230, 100, 20);        
        fjamlembur.setBounds(250, 230, 200, 20);               
        ltunjangan.setBounds(150, 260, 100, 20);       
        ftunjangan.setBounds(250, 260, 200, 20);      
        lpajak.setBounds(150, 290, 100, 20);        
        fpajak.setBounds(250, 290, 200, 20);      
        ltotgaji.setBounds(150, 320, 100, 20);     
        ftotgaji.setBounds(250, 320, 200, 20);
        
        
        btnhitung.setBounds(500, 190, 120, 80);      
        btnsimpan.setBounds(500, 290, 120, 80);      
        btnadmin.setBounds(500, 10, 120, 80);
            
        lapp.setBounds(180, 480, 300, 25);
        
        setSize(650, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
