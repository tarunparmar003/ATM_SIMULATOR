package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    Long random;
    JTextField NameBox, FnameBox, EmailBox, AddressBox, CityBox, StateBox, PinCodeBox;
    JButton Next;
    JRadioButton Male, Female, Married, UnMarried, Others;
    JDateChooser dobChooser;

    public SignupOne() {
        setTitle("SignupOne Page");
        setLayout(null);
        Random rand = new Random();
        random = (Math.abs((rand.nextInt() % 9000L + 100L)));

        JLabel FormNo = new JLabel("APPLICATION NO. " + random);
        FormNo.setFont(new Font("Railway", Font.BOLD, 40));
        FormNo.setBounds(200, 20, 600, 40);
        add(FormNo);

        JLabel PersonDetails = new JLabel("Page No 1: Personal Details");
        PersonDetails.setFont(new Font("Railway", Font.BOLD, 20));
        PersonDetails.setBounds(300, 50, 400, 40);
        add(PersonDetails);

        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("Railway", Font.BOLD, 20));
        Name.setBounds(100, 140, 100, 30);
        add(Name);

        NameBox = new JTextField();
        NameBox.setBounds(300, 140, 400, 30);
        NameBox.setFont(new Font("Railway", Font.BOLD, 14));
        add(NameBox);

        JLabel Fname = new JLabel("Father's Name:");
        Fname.setBounds(100, 190, 200, 30);
        Fname.setFont(new Font("Railway", Font.BOLD, 20));
        add(Fname);

        FnameBox = new JTextField();
        FnameBox.setBounds(300, 190, 400, 30);
        FnameBox.setFont(new Font("Railway", Font.BOLD, 14));
        add(FnameBox);

        JLabel Dob = new JLabel("Date Of Birth:");
        Dob.setBounds(100, 240, 200, 30);
        Dob.setFont(new Font("Railway", Font.BOLD, 20));
        add(Dob);

        dobChooser = new JDateChooser();
        dobChooser.setForeground(Color.WHITE);
        dobChooser.setBounds(300, 240, 200, 30);
        add(dobChooser);

        JLabel Gender = new JLabel("Gender:");
        Gender.setBounds(100, 290, 200, 30);
        Gender.setFont(new Font("Railway", Font.BOLD, 20));
        add(Gender);

        Male = new JRadioButton("Male");
        Male.setBounds(300, 290, 100, 30);
        add(Male);

        Female = new JRadioButton("Female");
        Female.setBounds(450, 290, 100, 30);
        add(Female);

        Others = new JRadioButton("Others");
        Others.setBounds(600, 290, 100, 30);
        add(Others);

        // GROUPING BUTTON BECAUSE WE HAVE TO SELECT ONE RADIO AT ONE TIME
        ButtonGroup GenderGroup = new ButtonGroup();
        GenderGroup.add(Male);
        GenderGroup.add(Female);
        GenderGroup.add(Others);

        JLabel Email = new JLabel("Email Address:");
        Email.setBounds(100, 340, 200, 30);
        Email.setFont(new Font("Railway", Font.BOLD, 20));
        add(Email);

        EmailBox = new JTextField();
        EmailBox.setBounds(300, 340, 400, 30);
        EmailBox.setFont(new Font("Railway", Font.BOLD, 14));
        add(EmailBox);

        JLabel Marital = new JLabel("Marital Status:");
        Marital.setBounds(100, 390, 200, 30);
        Marital.setFont(new Font("Railway", Font.BOLD, 20));
        add(Marital);

        Married = new JRadioButton("Married");
        Married.setBounds(300, 390, 100, 30);
        add(Married);
        UnMarried = new JRadioButton("Unmarried");
        UnMarried.setBounds(450, 390, 100, 30);
        add(UnMarried);

        // GROUPING BUTTON BECAUSE WE HAVE TO SELECT ONE RADIO AT ONE TIME
        ButtonGroup shadi = new ButtonGroup();
        shadi.add(Married);
        shadi.add(UnMarried);

        JLabel Address = new JLabel("Address:");
        Address.setBounds(100, 440, 200, 30);
        Address.setFont(new Font("Railway", Font.BOLD, 20));
        add(Address);

        AddressBox = new JTextField();
        AddressBox.setBounds(300, 440, 400, 30);
        AddressBox.setFont(new Font("Railway", Font.BOLD, 14));
        add(AddressBox);

        JLabel City = new JLabel("City:");
        City.setBounds(100, 490, 200, 30);
        City.setFont(new Font("Railway", Font.BOLD, 20));
        add(City);

        CityBox = new JTextField();
        CityBox.setBounds(300, 490, 400, 30);
        CityBox.setFont(new Font("Railway", Font.BOLD, 14));
        add(CityBox);

        JLabel State = new JLabel("State:");
        State.setBounds(100, 540, 200, 30);
        State.setFont(new Font("Railway", Font.BOLD, 20));
        add(State);

        StateBox = new JTextField();
        StateBox.setBounds(300, 540, 400, 30);
        StateBox.setFont(new Font("Railway", Font.BOLD, 14));
        add(StateBox);

        JLabel Pincode = new JLabel("Pin Code");
        Pincode.setBounds(100, 590, 200, 30);
        Pincode.setFont(new Font("Railway", Font.BOLD, 20));
        add(Pincode);

        PinCodeBox = new JTextField();
        PinCodeBox.setBounds(300, 590, 400, 30);
        PinCodeBox.setFont(new Font("Railway", Font.BOLD, 14));
        add(PinCodeBox);

        Next = new JButton("Next");
        Next.setBounds(620, 660, 80, 30);
        Next.setFont(new Font("Railway", Font.BOLD, 14));
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        add(Next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String FormNo = "" + random; // in the database, I want to convert the form no Long to String
        String Name = NameBox.getText();
        String Fname = FnameBox.getText();

        // Get the date of birth from the JDateChooser
        Date dobDate = dobChooser.getDate();
        String Dob = "";
        if (dobDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Dob = sdf.format(dobDate);
        }

        String Gender = null;
        if (Male.isSelected()) {
            Gender = "Male";
        } else if (Female.isSelected()) {
            Gender = "Female";
        }
        String Email = EmailBox.getText();
        String Marital = null;
        if (Married.isSelected()) {
            Marital = "Married";
        } else if (UnMarried.isSelected()) {
            Marital = "Unmarried";
        }
        String Address = AddressBox.getText();
        String City = CityBox.getText();
        String State = StateBox.getText();
        String Pincode = PinCodeBox.getText();

        try {
            if (Name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (Fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father Name is Required");
            } else if (Dob.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Date Of Birth");
            } else if (Gender == null) {
                JOptionPane.showMessageDialog(null, "Please Select Gender");
            } else if (Marital == null) {
                JOptionPane.showMessageDialog(null, "Please Select Marital Status");
            } else if (Address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required");
            } else if (City.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required");
            } else if (State.equals("")) {
                JOptionPane.showMessageDialog(null, "State is Required");
            } else if (Pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signup VALUES('" + FormNo + "','" + Name + "', '" + Fname + "',' " + Dob
                        + " ',' " + Gender + " ',' " + Email + " ' ,' " + Marital + " ',' " + Address + " ',' " + City
                        + " ',' " + Pincode + " ')";
                c.s.executeUpdate(query);
                new SignupTwo(FormNo).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
