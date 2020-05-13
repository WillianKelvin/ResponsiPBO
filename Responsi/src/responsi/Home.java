
package responsi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home extends JFrame{
    private Image image;
      
    JButton btnhome = new JButton(" Home ");
    JButton btngaji = new JButton(" Gaji ");
    JButton btnread = new JButton(" Data ");
    JButton btnpetunjuk = new JButton(" Petunjuk ");
    JButton btnadmin = new JButton(" ADMIN ");
    
    JLabel lapp = new JLabel("APLIKASI PERHITUNGAN GAJI PT.VETERAN JAYA");
    
    public Home(){
        image = new ImageIcon(getClass().getResource("bag.jpeg")).getImage();
         this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
         }
         });
         
        setTitle("Home");
        
        add(btnhome);
        add(btngaji);
        add(btnread);
        add(btnpetunjuk);
        add(btnadmin);
        add(lapp);
        
        
        setLayout(null); 
        
        btnhome.setBounds(10, 10, 120, 80);       
        btngaji.setBounds(10, 100, 120, 80);        
        btnread.setBounds(10, 190, 120, 80);        
        btnpetunjuk.setBounds(10, 280, 120, 80);                
        btnadmin.setBounds(500, 10, 120, 80);              
        lapp.setBounds(180, 480, 300, 25);
        
        setSize(650, 550); //ukuran layout
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
        btnadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ViewLogin login = new ViewLogin();
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
    }
    
}
