package bank.management.system;

//import bank.management.system.Conn;
//import bank.management.system.SignupOne;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener {

    JLabel CardNo, Pin;
    JButton login, Signup, Clear;
    JTextField CardnoBox;
    JPasswordField PinBox;

    Login() {
        setTitle("AUTOMATIC TELLER MACHINE LOGIN PAGE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Label = new JLabel(i3);
        Label.setBounds(45, 10, 100, 100);
        add(Label);

        JLabel Text = new JLabel("--- WELCOME TO ATM ---");
        Text.setFont(new Font("Osward", Font.BOLD, 30));
        Text.setBounds(200, 40, 400, 40);
        add(Text);

        CardNo = new JLabel("Card No:");
        CardNo.setFont(new Font("Railway", Font.BOLD, 28));
        CardNo.setBounds(150, 150, 150, 30);
        add(CardNo);

        CardnoBox = new JTextField();
        CardnoBox.setBounds(300, 150, 250, 30);
        CardnoBox.setFont(new Font("Arial", Font.BOLD, 14));
        add(CardnoBox);

        Pin = new JLabel("PIN");
        Pin.setFont(new Font("Railway", Font.BOLD, 28));
        Pin.setBounds(150, 220, 400, 30);
        add(Pin);

        PinBox = new JPasswordField();
        PinBox.setBounds(300, 220, 250, 30);
        add(PinBox);
        // BUTTON SIGN IN
        login = new JButton("LOG IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        // BUTTON CLEAR
        Clear = new JButton("CLEAR");
        Clear.setBounds(450, 300, 100, 30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
        add(Clear);
        // SIGN UP
        Signup = new JButton("SIGN UP");
        Signup.setBounds(300, 350, 250, 30);
        Signup.setBackground(Color.BLACK);
        Signup.setForeground(Color.WHITE);
        Signup.addActionListener(this);
        add(Signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setVisible(true);
        setLocation(330, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Clear) {
            CardnoBox.setText("");
            PinBox.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String CardNumber = CardnoBox.getText();
            String PinNumber = PinBox.getText();
            String query = "SELECT * FROM login WHERE CardNumber = '" + CardNumber + "' AND pin = '" + PinNumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(PinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == Signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();

    }

}
