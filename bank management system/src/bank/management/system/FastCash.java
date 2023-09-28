package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton  fastCash1, fastCash2, fastCash3, fastCash4, fastCash5, fastCash6, back;
    String PinNumber;

    public FastCash(String PinNumber) {
        this.PinNumber = PinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.BOLD, 15));
        image.add(text);

        fastCash1 = new JButton("Rs 100");
        fastCash1.setBounds(170, 415, 150, 30);
        image.add(fastCash1);
        fastCash1.addActionListener(this);

        fastCash2 = new JButton("Rs 500");
        fastCash2.setBounds(355, 415, 150, 30);
        image.add(fastCash2);
        fastCash2.addActionListener(this);

        fastCash3 = new JButton("Rs 1000");
        fastCash3.setBounds(170, 450, 150, 30);
        image.add(fastCash3);
        fastCash3.addActionListener(this);

        fastCash4 = new JButton("Rs 2000");
        fastCash4.setBounds(355, 450, 150, 30);
        image.add(fastCash4);
        fastCash4.addActionListener(this);

        fastCash5 = new JButton("Rs 5000");
        fastCash5.setBounds(170, 485, 150, 30);
        image.add(fastCash5);
        fastCash5.addActionListener(this);

        fastCash6 = new JButton("Rs 10000");
        fastCash6.setBounds(355, 485, 150, 30);
        image.add(fastCash6);
        fastCash6.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        back.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(PinNumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);//Rs 500
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin ='" + PinNumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));//CONVET INT INTO STRING
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() == back && balance < Integer.parseInt(rs.getString("amount"))) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String Query = "INSERT INTO bank VALUES('" + PinNumber + "','" + date + "','Withdrwal','" + amount + "')";
                conn.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null, "Rs" + amount + "Debited Sucessfully");
                setVisible(false);
                new Transactions(PinNumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
