import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JTextField tfusername;
    JTextField tfpassword;

    login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        // password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        // login button
        JButton login = new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Resourse/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        // frame
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            conn c = new conn();
            String query = "select * from login where username = '"+username+"'and password = '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid! You need to hack it! Good Luck!");
                setVisible(false);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        new login();
    }
}
