package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JButton withdraw, back;
    JTextField amount;
    String Pincode;

    Withdrawl(String Pincode) {

        this.Pincode = Pincode;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter The Amount You Want To Withdraw:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == withdraw) {

            String amountTake = amount.getText();
            Date date = new Date();
            if (amountTake.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "INSERT INTO bank VALUES('" + Pincode + "','" + date + "','Wthdrawl','" + amountTake + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amountTake + "Withdraw Successfully");
                    setVisible(false);
                    new Transactions(Pincode).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);

                }
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(Pincode).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Withdrawl("");
    }

}
