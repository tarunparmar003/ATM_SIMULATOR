package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String PinNumber) {

        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet Rs = conn.s.executeQuery("SELECT * FROM login WHERE pin='" + PinNumber + "'");

            while (Rs.next()) {
                card.setText("Card Number:" + Rs.getString("CardNumber").substring(0, 4) + "XXXXXXXX" + Rs.getString("CardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            int balanc = 0;

            ResultSet Rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin='" + PinNumber + "'");

            while (Rs.next()) {
                mini.setText(mini.getText() + "<html>" + Rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + Rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + Rs.getString("amount") + "<br><br><html>");
                if (Rs.getString("type").equals("Deposit")) {
                    balanc += Integer.parseInt(Rs.getString("amount"));//CONVET INT INTO STRING
                } else {
                    balanc -= Integer.parseInt(Rs.getString("amount"));

                }

            }
            balance.setText("Your Current Account Blance Rs " + balanc);
        } catch (Exception e) {
            System.out.println(e);
        }

        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(500, 100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String args[]) {
        new MiniStatement("");
    }
}
