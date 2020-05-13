
package responsi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Read extends JFrame{
    private Image image;   
    JButton btnhome = new JButton(" HOME ");
    JButton btngaji = new JButton(" GAJI ");
    JButton btnread = new JButton(" READ ");
    JButton btnpetunjuk = new JButton(" PETUNJUK ");
    JButton btnadmin = new JButton(" ADMIN ");
    
    JButton btndelete = new JButton(" DELETE ");
    JButton btnupdate = new JButton(" UPDATE ");
    JButton btnshow = new JButton(" SHOW ");
    
    JLabel lapp = new JLabel("APLIKASI PERHITUNGAN GAJI PT.VETERAN JAYA");
    
    JTable tabel;
    DefaultTableModel tablemodel;
    JScrollPane scrollpane;
    Object namakolom[] = {"ID", "Nama", "Posisi", "Gaji Pokok", "Jam Lembur", "Tunjangan", "Total Gaji"};    
    public Read(){
        image = new ImageIcon(getClass().getResource("bag.jpeg")).getImage();
         this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
         }
         });
         
        setTitle("READ");
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
        
        add(btnadmin);
        btnadmin.setBounds(500, 10, 120, 80);
        
        add(btnshow);
        btnshow.setBounds(100, 400, 120, 80);
        add(btndelete);
        btndelete.setBounds(230, 400, 120, 80);
        add(btnupdate);
        btnupdate.setBounds(360, 400, 120, 80);
        
        add(lapp);
        lapp.setBounds(180, 480, 300, 25);
        
        tablemodel = new DefaultTableModel (namakolom,0);
        tabel = new JTable(tablemodel);
        scrollpane = new JScrollPane(tabel);

        add(scrollpane);
        scrollpane.setBounds(150, 100, 450, 270);
        scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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
        
    }
    
}
