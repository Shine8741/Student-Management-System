package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/about.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,0,300,200);
        add(img);

        JLabel heading = new JLabel("<html> Vidyalankar Institute <br/> of Technology</html>");
        heading.setBounds(60,40,300,130);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);

        JLabel name1 = new JLabel("Student Management System");
        name1.setBounds(60,220,550,40);
        name1.setFont(new Font("Tahoma", Font.BOLD,30));
        add(name1);

        JLabel name = new JLabel("A project by Uday Amballa");
        name.setBounds(60,260,550,40);
        name.setFont(new Font("Tahoma", Font.BOLD,30));
        add(name);

        JLabel contact = new JLabel("amballauday@gmail.com");
        contact.setBounds(70,340,550,40);
        contact.setFont(new Font("Tahoma", Font.BOLD,30));
        add(contact);

        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(new Color(70,100,255));
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new About();
    }
}
