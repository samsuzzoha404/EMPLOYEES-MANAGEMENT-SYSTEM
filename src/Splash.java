import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    Splash() {

        // for frame
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // start heading
        JLabel heading = new JLabel("EMPLOYEES MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 57));
        heading.setForeground(Color.RED);
        add(heading);

        // for image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Resourse/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        // for button
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.white);
        clickhere.setForeground(Color.BLACK);
        clickhere.addActionListener(this);
        image.add(clickhere);

        // frame measurement
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);

        // for dipper
        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(700);
            }catch (Exception e){

            }
            heading.setVisible(true);
            try {
                Thread.sleep(700);
            }catch (Exception e){

            }
        }
    }

    // connect to login panel
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new login();

    }

    public static void main(String args[]){

        new Splash();
    }
}
