package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinTextBox, repinTextBox;
    JButton change, back;
    String PinNumber;

    PinChange(String PinNumber) {
        this.PinNumber = PinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN:");
        text.setForeground(Color.WHITE);
        text.setBounds(250, 280, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);

        JLabel pinText = new JLabel("New PIN:");
        pinText.setForeground(Color.WHITE);
        pinText.setBounds(165, 320, 180, 25);
        pinText.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(pinText);

        pinTextBox = new JPasswordField();
        pinTextBox.setFont(new Font("Raleway", Font.BOLD, 25));
        pinTextBox.setBounds(330, 320, 180, 25);
        image.add(pinTextBox);

        JLabel repinText = new JLabel("Re-Enter New PIN:");
        repinText.setForeground(Color.WHITE);
        repinText.setBounds(165, 360, 180, 25);
        repinText.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repinText);

        repinTextBox = new JPasswordField();
        repinTextBox.setFont(new Font("Raleway", Font.BOLD, 25));
        repinTextBox.setBounds(330, 360, 180, 25);
        image.add(repinTextBox);

        change = new JButton("Change PIN");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {

            try {
                String newPin = pinTextBox.getText();
                String RePin = repinTextBox.getText();
                // New Pin is Not Equals To ReEntere Pin  this condition show
                if (!newPin.equals(RePin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN Does Not Match");
                    return;
                }
                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter PIN");
                    return;
                }
                if (RePin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please RE-Enter New PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "UPDATE bank SET pin='" + RePin + "'WHERE pin='" + PinNumber + "'";
                String query2 = "UPDATE login SET pin='" + RePin + "'WHERE pin='" + PinNumber + "'";
                String query3 = "UPDATE signupthree SET pin='" + RePin + "'WHERE pin='" + PinNumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                setVisible(false);
                new Transactions(RePin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(PinNumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
