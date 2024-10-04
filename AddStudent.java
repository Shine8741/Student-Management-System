package university.management.system;

//import com.toedter.calendar.JDateChooser;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {

    JTextField textName,textfather,textAddress,textPhone,textemail,textM10,textM12,textAadhar;
    JLabel empText;
    JDateChooser cdob;
    JComboBox courseBox, departmentBox;
    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9L) + 1L);

    AddStudent(){

        getContentPane().setBackground(new Color(250,220,110));

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(170,150,150,25);
        add(textName);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        textfather = new JTextField();
        textfather.setBounds(550,150,150,25);
        add(textfather);

        JLabel empID = new JLabel("Roll no.");
        empID.setBounds(50,200,200,30);
        empID.setFont(new Font("serif",Font.BOLD,20));
        add(empID);

        empText = new JLabel("10"+f4);
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(550,200,150,25);
        add(cdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,25);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(170,250,150,25);
        add(textAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,200,25);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(550,250,150,25);
        add(textPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(170,300,150,25);
        add(textemail);

        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400,300,200,25);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(550,300,150,25);
        add(textM10);

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50,350,200,25);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(170,350,150,25);
        add(textM12);

        JLabel AadharNo = new JLabel("Aadhar Number");
        AadharNo.setBounds(400,350,200,30);
        AadharNo.setFont(new Font("serif",Font.BOLD,20));
        add(AadharNo);

        textAadhar = new JTextField();
        textAadhar.setBounds(550,350,150,25);
        add(textAadhar);

        JLabel Qualification = new JLabel("Course");
        Qualification.setBounds(50,400,200,25);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        String course[] = {"B.Tech/B.E.","BBA","BCA","BSC","MSC","MBA","MCA","MCom","MA","BA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(170,400,150,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        JLabel Department = new JLabel("Branch");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        String department[] = {"CMPN","ETRX","EXTC","BIOMED","IT"};
        departmentBox = new JComboBox(department);
        departmentBox.setBounds(550,400,150,30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        submit = new JButton("Submit");
        submit.setBounds(250,500,120,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String name = textName.getText();
            String fname = textfather.getText();
            String empid = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String aadhar = textAadhar.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();
            try{
                String q = "insert into student values('"+name+"', '"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+department+"')";
//                String q = "insert into student values('"+Name+"', '"+Father_name+"','"+Rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
                Conn c =new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Inserted");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
