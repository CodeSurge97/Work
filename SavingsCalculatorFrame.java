/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Surge
 */
public class SavingsCalculatorFrame extends JFrame 
{
    private JTextField ratefield;
    private JTextField balfield;
    private JTextField yearfield;
    private JButton button;
    private JPanel panel;
    private BankAccount account;
    private JLabel rateLabel;
    private JLabel balLabel;
    private JLabel yearLabel;
    private TextArea result;
    
    public SavingsCalculatorFrame() {
        account = new BankAccount();
        CreateTextField();
        CreateButton();
        CreatePanel();
        setSize(300, 300);
    }

    private void CreateTextField() {
        rateLabel = new JLabel("Annual Rate: ");
        balLabel = new JLabel("Initial Balance:");
        yearLabel = new JLabel("Number of years:");
        balfield = new JTextField(10);
        ratefield = new JTextField(10);
        yearfield = new JTextField(10);
        result = new TextArea();
    }

    private void CreateButton() {
        button = new JButton("Calculate");
        class AddCalculateListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                double balance = Double.parseDouble(balfield.getText());
                double rate = Double.parseDouble(ratefield.getText());
                double years = Double.parseDouble(yearfield.getText());
                account = new BankAccount(balance);
                rate = rate 100;
             for (int i = 1; i
 {
                    
                }import javax.swing.JFrame;
    
}
