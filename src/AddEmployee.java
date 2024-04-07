import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

    // global declare
    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfemail, tfid;
    JComboBox cbeducation, tfdesignation;
    JDateChooser dcdob;
    JLabel lblid;
    JButton add, back;




    AddEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // heading
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        // employee name
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        // father name
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        // date of birth
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);

        // salary
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        // address
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        // phone
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        // email
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        // education
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        String courses[] = {"Primary", "School", "High-School", "A-Level", "O-Level", "Pre-University", "Bachelor's", "Master's", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150, 30);
        add(cbeducation);

        // designation
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        String designation[] = {"Software Engineer", "Web Developer", "App Developer", "Designer", "Game Developer", "Hacker", "Data Scientists", "Cyber Security Analyst", "Computer Networking Analyst", "Machine Learning Engineer"};
        tfdesignation = new JComboBox(designation);
        tfdesignation.setBackground(Color.WHITE);
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);

        // id number
        JLabel labelid = new JLabel("ID No");
        labelid.setBounds(400, 350, 150, 30);
        labelid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelid);

        tfid = new JTextField();
        tfid.setBounds(600, 350, 150, 30);
        add(tfid);

        // employee random id
        JLabel labelemId = new JLabel("Employee ID");
        labelemId.setBounds(50, 400, 150, 30);
        labelemId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemId);

        lblid = new JLabel("" + number);
        lblid.setBounds(200, 400, 150, 30);
        lblid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblid);

        // add button
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        // back button
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);


        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = (String) tfdesignation.getSelectedItem();
            String id = tfid.getText();
            String empId = lblid.getText();

            try{
                conn con = new conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+id+"', '"+empId+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully");
                setVisible(false);
                new Home();

            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
            new Home();
        }
    }


    public static void main(String[] args){

        new AddEmployee();
    }
}
