package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("Calibri", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Calibri", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        withdraw = new JButton("Withdrawl");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    int withdrawAmount = Integer.parseInt(number);

                    if (withdrawAmount <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid amount greater than zero.");
                        return;
                    }

                    Conn conn = new Conn();

                    // Fetch the current balance
                    String queryBalance = "SELECT * FROM bank WHERE pin = '" + pinnumber + "'";
                    ResultSet rs = conn.s.executeQuery(queryBalance);
                    int balance = 0;

                    while (rs.next()) {
                        if (rs.getString("type").equalsIgnoreCase("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else if (rs.getString("type").equalsIgnoreCase("Withdraw") && balance>withdrawAmount) {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    // Check if the balance is sufficient
                    if (balance < withdrawAmount) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance!");
                        return; // Stop further execution
                    }

                    // Perform the withdrawal and update the database
                    String queryWithdraw = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Withdraw', '" + withdrawAmount + "')";
                    conn.s.executeUpdate(queryWithdraw);

                    JOptionPane.showMessageDialog(null, "Rs " + withdrawAmount + " debited successfully!");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid amount entered. Please enter a valid number.");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }
}
