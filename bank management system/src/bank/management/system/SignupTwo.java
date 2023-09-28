package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener {

    JLabel title, Religion, Category, Income, Educational, Occupation, PanNumber, AdharNumber, SeniorCitizen, ExisitingAccount;
    JTextField PanNumberBox, AdharNumberBox;
    JComboBox ReligionComboBox, CategoryComboBox, IncomeComboBox, EducatinalComboBox, OccupationComboBox;
    JButton nextButton;
    JRadioButton SeniorCitizenRadio, SeniorCitizenRadio2, ExisitingAccountRadio, ExisitingAccountRadio2;
    String FormNo;

    public SignupTwo(String FormNo) {

        this.FormNo = FormNo;

        title = new JLabel("Page 2: Additional Details");
        title.setBounds(300, 50, 600, 40);
        title.setFont(new Font("Railway", Font.BOLD, 20));
        add(title);

        Religion = new JLabel("Religion");
        Religion.setBounds(100, 140, 200, 30);
        Religion.setFont(new Font("Railway", Font.BOLD, 20));
        add(Religion);

        String ReligionValue[] = {"Hindu", "Sikh", "Muslim", "Cristian", "Other"};

        ReligionComboBox = new JComboBox(ReligionValue);
        ReligionComboBox.setBounds(300, 140, 400, 30);
        ReligionComboBox.setBackground(Color.WHITE);
        add(ReligionComboBox);

        Category = new JLabel("Category");
        Category.setBounds(100, 190, 200, 30);
        Category.setFont(new Font("Railway", Font.BOLD, 20));
        add(Category);

        String CategoryValue[] = {"General", "OBC", "SC", "ST", "Other"};

        CategoryComboBox = new JComboBox(CategoryValue);
        CategoryComboBox.setBounds(300, 190, 400, 30);
        CategoryComboBox.setBackground(Color.WHITE);
        add(CategoryComboBox);

        Income = new JLabel("Income");
        Income.setBounds(100, 240, 200, 30);
        Income.setFont(new Font("Railway", Font.BOLD, 20));
        add(Income);

        String IncomeValue[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};

        IncomeComboBox = new JComboBox(IncomeValue);
        IncomeComboBox.setBounds(300, 240, 400, 30);
        IncomeComboBox.setBackground(Color.WHITE);
        add(IncomeComboBox);

        Educational = new JLabel("Education");
        Educational.setBounds(100, 290, 200, 30);
        Educational.setFont(new Font("Railway", Font.BOLD, 20));
        add(Educational);

        String EducationalValue[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};

        EducatinalComboBox = new JComboBox(EducationalValue);
        EducatinalComboBox.setBounds(300, 290, 400, 30);
        EducatinalComboBox.setBackground(Color.WHITE);
        add(EducatinalComboBox);

        // JLabel Qualification = new JLabel("Qualification");
        // Qualification.setBounds(100, 340, 200, 30);
        // Qualification.setFont(new Font("Railway", Font.BOLD, 20));
        // add(Qualification);
        Occupation = new JLabel("Occupation");
        Occupation.setBounds(100, 340, 200, 30);
        Occupation.setFont(new Font("Railway", Font.BOLD, 20));
        add(Occupation);

        String OccupationValue[] = {"Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others"};

        OccupationComboBox = new JComboBox(OccupationValue);
        OccupationComboBox.setBounds(300, 340, 400, 30);
        OccupationComboBox.setBackground(Color.WHITE);
        add(OccupationComboBox);

        PanNumber = new JLabel("PAN Number");
        PanNumber.setBounds(100, 390, 200, 30);
        PanNumber.setFont(new Font("Railway", Font.BOLD, 20));
        add(PanNumber);

        PanNumberBox = new JTextField();
        PanNumberBox.setBounds(300, 390, 400, 30);
        PanNumberBox.setFont(new Font("Railway", Font.BOLD, 14));
        add(PanNumberBox);

        AdharNumber = new JLabel("Adhar Number");
        AdharNumber.setBounds(100, 440, 200, 30);
        AdharNumber.setFont(new Font("Railway", Font.BOLD, 20));
        add(AdharNumber);

        AdharNumberBox = new JTextField();
        AdharNumberBox.setBounds(300, 440, 400, 30);
        AdharNumberBox.setFont(new Font("Railway", Font.BOLD, 14));
        add(AdharNumberBox);

        SeniorCitizen = new JLabel("Senior Citizen");
        SeniorCitizen.setBounds(100, 490, 200, 30);
        SeniorCitizen.setFont(new Font("Railway", Font.BOLD, 20));
        add(SeniorCitizen);

        SeniorCitizenRadio = new JRadioButton("Yes");
        SeniorCitizenRadio.setBounds(300, 490, 100, 30);
        add(SeniorCitizenRadio);

        SeniorCitizenRadio2 = new JRadioButton("No");
        SeniorCitizenRadio2.setBounds(450, 490, 100, 30);
        add(SeniorCitizenRadio2);

        ButtonGroup OnlyCitizen = new ButtonGroup();
        OnlyCitizen.add(SeniorCitizenRadio);
        OnlyCitizen.add(SeniorCitizenRadio2);

        ExisitingAccount = new JLabel("Exisiting Account");
        ExisitingAccount.setBounds(100, 540, 200, 30);
        ExisitingAccount.setFont(new Font("Railway", Font.BOLD, 20));
        add(ExisitingAccount);

        ExisitingAccountRadio = new JRadioButton("Yes");
        ExisitingAccountRadio.setBounds(300, 540, 100, 30);
        add(ExisitingAccountRadio);

        ExisitingAccountRadio2 = new JRadioButton("No");
        ExisitingAccountRadio2.setBounds(450, 540, 100, 30);
        add(ExisitingAccountRadio2);

        ButtonGroup OnlyExisitingAccount = new ButtonGroup();
        OnlyExisitingAccount.add(ExisitingAccountRadio);
        OnlyExisitingAccount.add(ExisitingAccountRadio2);

        nextButton = new JButton("Next");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(615, 660, 80, 30);
        nextButton.addActionListener(this);

        add(nextButton);

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - 2");
        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String sReligion = (String) ReligionComboBox.getSelectedItem();
        String sCategory = (String) CategoryComboBox.getSelectedItem();
        String sIncome = (String) IncomeComboBox.getSelectedItem();
        String sEducational = (String) EducatinalComboBox.getSelectedItem();
        String sOcupational = (String) OccupationComboBox.getSelectedItem();

        String SeniorCitizen = null;
        if (SeniorCitizenRadio.isSelected()) {
            SeniorCitizen = "Yes";
        } else if (SeniorCitizenRadio2.isSelected()) {
            SeniorCitizen = "No";
        }

        String ExisitingAccount = null;
        if (ExisitingAccountRadio.isSelected()) {
            ExisitingAccount = "Yes";
        } else if (ExisitingAccountRadio2.isSelected()) {
            ExisitingAccount = "No";
        }

        String SAdharNumberBox = AdharNumberBox.getText();
        String SPanNumberBox = PanNumberBox.getText();

        try {
            Conn C = new Conn();
            String query = "INSERT INTO signuptwo VALUES('" + FormNo + "','" + sReligion + "', '" + sCategory + "',' " + sIncome
                    + " ',' " + sEducational + " ',' " + sOcupational + " ' ,' " + SPanNumberBox + " ',' " + SAdharNumberBox + " ',' " + SeniorCitizen
                    + " ',' " + ExisitingAccount + " ')";
            C.s.execute(query);

            setVisible(false);

            //Signup3
            new SignupThree(FormNo).setVisible(true);

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");

    }
}
