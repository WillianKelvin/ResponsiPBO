
package responsi;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Petunjuk extends JFrame{
    private Image image;
     
    JLabel gaji = new JLabel("Klik tombol gaji untuk menghitung gaji anda");
    JLabel read = new JLabel("Klik tombol read untuk memastikan data sudah masuk");
    JButton btnhome = new JButton(" HOME ");
    
    JLabel lapp = new JLabel("APLIKASI PERHITUNGAN GAJI PT.VETERAN JAYA");
    
    public Petunjuk(){
        image = new ImageIcon(getClass().getResource("bag.jpeg")).getImage();
         this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
         }
         });
         
        setTitle("Petunjuk");
        setDefaultCloseOperation(3);
        setSize(650, 550);
        
        setLayout(null);
        add(gaji);
        gaji.setFont(new Font("times new roman", Font.PLAIN, 14));
        gaji.setBounds(130, 150, 400, 50);
        add(read);
        read.setFont(new Font("times new roman", Font.PLAIN, 14));
        read.setBounds(100, 200, 400, 50);
        add(btnhome);
        btnhome.setBounds(250, 300, 80, 50);
        
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
        
    }
    
}
