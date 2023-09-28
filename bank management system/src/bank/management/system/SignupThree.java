package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String FormNo;

    SignupThree(String FormNo) {
        this.FormNo = FormNo;

        setLayout(null);
        JLabel title = new JLabel("Page 3: Account Details");
        title.setFont(new Font("Raleway", Font.BOLD, 22));
        title.setBounds(280, 40, 400, 40);
        add(title);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 140, 200, 40);
        add(accountType);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 250, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        // NOW WE HAVE TO DO GROUPING TO SELECT ONLY ONE RADIO BUTTON AMONG 4
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setBounds(100, 300, 200, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        add(card);

        JLabel cardNumb = new JLabel("XXXX-XXXX-XXXX-4747");
        cardNumb.setBounds(330, 300, 300, 30);
        cardNumb.setFont(new Font("Raleway", Font.BOLD, 22));
        add(cardNumb);

        JLabel cardDetail = new JLabel("Your 16 Digit card Number");
        cardDetail.setBounds(100, 330, 200, 30);
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        add(cardDetail);

        JLabel pin = new JLabel("PIN");
        pin.setBounds(100, 370, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pin);

        JLabel pinNumb = new JLabel("XXXX");
        pinNumb.setBounds(330, 370, 300, 30);
        pinNumb.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pinNumb);

        JLabel pinDetail = new JLabel("Your 4 Digit Password");
        pinDetail.setBounds(100, 400, 300, 30);
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        add(pinDetail);

        JLabel services = new JLabel("Services Required");
        services.setBounds(100, 450, 300, 30);
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statements");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I Hereby Declare That The Above Entered Details Are Correct To The Best Of My Knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Select an account type.");
            } else {
                Random random = new Random();
                String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
                String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

                String facility = "";
                if (c1.isSelected()) {
                    facility = facility + " ATM Card";
                }
                if (c2.isSelected()) {
                    facility = facility + " Internet Banking";
                }
                if (c3.isSelected()) {
                    facility = facility + " Mobile Banking";
                }
                if (c4.isSelected()) {
                    facility = facility + " Email & SMS Alerts";
                }
                if (c5.isSelected()) {
                    facility = facility + " Cheque Book";
                }
                if (c6.isSelected()) {
                    facility = facility + " E-Statements";
                }

                if (facility.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Select at least one service.");
                } else {
                    try {
                        Conn conn = new Conn();
                        String query1 = "INSERT INTO signupthree VALUES('" + FormNo + "','" + accountType + "','" + cardNumber + "','" + pinNumber + "','" + facility + "')";
                        String query2 = "INSERT INTO login VALUES('" + FormNo + "','" + cardNumber + "','" + pinNumber + "')";

                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);

                        JOptionPane.showMessageDialog(null, "CardNumber " + cardNumber + "\n Pin " + pinNumber);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        } else if (ae.getSource() == cancel) {
            // Handle cancel button action if needed
        }
    }

    public static void main(String args[]) {
        new SignupThree("");
    }
}
