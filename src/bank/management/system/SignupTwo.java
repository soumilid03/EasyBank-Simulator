package bank.management.system;

import java.awt.*;
import javax.swing.*;  
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    long random;
    JTextField  panTextField, aadharTextField;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    JComboBox religion, category, income, education, occupation;
    String formno;
  
    
    SignupTwo(String formno){
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("New Account Application Form - PAGE 2");
        
        
        JLabel additionalnalDetails =  new JLabel("Page 2: Additional Details");
        additionalnalDetails.setFont(new Font("Calibri", Font.BOLD, 22));
        additionalnalDetails.setBounds(290, 80, 400, 30);
        add(additionalnalDetails);
        
        JLabel rel =  new JLabel("Religion :");
        rel.setFont(new Font("Calibri", Font.BOLD, 20));
        rel.setBounds(100, 140, 100, 30);
        add(rel);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        religion.setForeground(Color.black);
        add(religion);
               
        JLabel categ =  new JLabel("Category :");
        categ.setFont(new Font("Calibri", Font.BOLD, 20));
        categ.setBounds(100, 190, 200, 30);
        add(categ);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        category.setForeground(Color.black);
        add(category);
        
        JLabel inc=  new JLabel("Income :");
        inc.setFont(new Font("Calibri", Font.BOLD, 20));
        inc.setBounds(100, 240, 200, 30);
        add(inc);
        
        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        income.setForeground(Color.black);
        add(income);
        
        JLabel edu =  new JLabel("Educational");
        edu.setFont(new Font("Calibri", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);
        
       
        JLabel qual =  new JLabel("Qualification :");
        qual.setFont(new Font("Calibri", Font.BOLD, 20));
        qual.setBounds(100, 315, 200, 30);
        add(qual);
        
        String eduValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "others"};
        education = new JComboBox(eduValues);
        education.setBounds(300, 310, 400, 30);
        education.setBackground(Color.WHITE);
        education.setForeground(Color.black);
        add(education);
        
        JLabel occ =  new JLabel("Occupation :");
        occ.setFont(new Font("Calibri", Font.BOLD, 20));
        occ.setBounds(100, 390, 200, 30);
        add(occ);
        
        String occValues[] = {"Salaried", "Self-employed", "Business", "Retired", "Student", "Others"};
        occupation = new JComboBox(occValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        occupation.setForeground(Color.black);
        add(occupation);
                     
        JLabel pan =  new JLabel("PAN Number :");
        pan.setFont(new Font("Calibri", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        JLabel aadhar =  new JLabel("Aadhar Number :");
        aadhar.setFont(new Font("Calibri", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);
        
        JLabel sencit =  new JLabel("Senior Citizen :");
        sencit.setFont(new Font("Calibri", Font.BOLD, 20));
        sencit.setBounds(100, 540, 200, 30);
        add(sencit);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.decode("#F0FFF2"));
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.decode("#F0FFF2"));
        add(sno);
                
        ButtonGroup scgrp = new ButtonGroup();
        scgrp.add(syes);
        scgrp.add(sno);
        
        JLabel exacc =  new JLabel("Exixting Account :");
        exacc.setFont(new Font("Calibri", Font.BOLD, 20));
        exacc.setBounds(100, 590, 200, 30);
        add(exacc);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.decode("#F0FFF2"));
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.decode("#F0FFF2"));
        add(eno);
                
        ButtonGroup exgrp = new ButtonGroup();
        exgrp.add(eyes);
        exgrp.add(eno);
        
        next = new JButton("Next");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.decode("#3D9BFF"));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.decode("#F0FFF2"));
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        } 
        else if(eno.isSelected()){
            existingaccount = "No";
        }
        
        
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        
        
        try{
            
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                // Signup three class object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }
        catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]){
        new SignupTwo("");
        
    }
    
}