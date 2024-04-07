import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton add, view, update, remove;

    Home() {


        setLayout(null);

        // background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Resourse/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        // heading
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(616, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(heading);

        // add button
        add = new JButton("Add Employees");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        // view button
        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        // update button
        update = new JButton("Update Employees");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);

        // remove button
        remove = new JButton("Remove Employees");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        // frame
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    // connect to other class and mySQL
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add){
            setVisible(false);
            new AddEmployee();

        }else if (ae.getSource() == view){
            setVisible(false);
            new ViewEmployee();

        }else if (ae.getSource() == update){
            setVisible(false);
            new ViewEmployee();
        }else {
            setVisible(false);
            new RemoveEmployee();
        }

    }




    public static void main(String[] args) {

        new Home();
    }
}
