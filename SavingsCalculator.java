
/**
 * Title: Savings Calculator
 * Semester: COP3337 – Summer 2017
 *
 * @author Serge Metellus
 *
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
 *
 * This program contains several textfield, a textArea; a button and a control 
 * panel to change the balance of a savings account after a given number of years. 
 * It also contains a bar chart to show a visual of the balance after each year.
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.ui.RefineryUtilities;


/**
 * Class creates a frame that calculates the balance of a Savings Account after a 
 * given number of years
 * @author Surge
 */
public class SavingsCalculator extends JFrame
{
    
    //fields declartion
    private JTextField Balance;
    private JTextField Rate;
    private JTextField Years;
    private JTextArea Area;
    private static final int FWidth = 700;
    private static final int Height = 250;
    

    /**
     * class that calculates the values
     */
    public SavingsCalculator()
    {
        setSize(FWidth, Height);
        add(Panel());
        
    }
    
    /**
     * Creates the panel
     */
    private JPanel Panel()
    {
        
        //variable declaration
        final int FWidth = 10;
        final int AWidth = 20;
        final int AHeight = 10;
        // creating text fields
        Balance = new JTextField(FWidth);
        Rate = new JTextField(FWidth);
        Years = new JTextField(FWidth);
        Area = new JTextArea(AHeight, AWidth);
        Area.setEditable(false);
        JPanel panel = new JPanel();

        // labeling all the text fields and adding to the frame
        panel.add(new JLabel(" Initial Balance "));
        panel.add(Balance);
        panel.add(new JLabel(" Annual Rate "));
        panel.add(Rate);
        panel.add(new JLabel(" Number of Years "));
        panel.add (Years);
        panel.add(Button());
        panel.add(newButton());
        panel.add (new JScrollPane(Area));
        return panel;
        
    }
    
    /**
     * button operation when button is clicked
     */
    private JButton newButton()
    {
    JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                System.exit(0); 
            }
        });
        return cancel;
    }
    
    /**
     * button operation when button is clicked
     */
    private JButton Button()
    {
        JButton calculateButton = new JButton("Calculate");
        
        class ButtonListener implements ActionListener
        {
            
            //actions performed when button is clicked
            @Override
            public void actionPerformed(ActionEvent event)
            {
                double balance = Double.parseDouble(Balance.getText());
                double initialbalance = balance;
                double rate = Double.parseDouble(Rate.getText());
                int nyears = Integer.parseInt (Years.getText());
                double[][] balance1 = new double[1][nyears];
                for (int year = 0; year <= nyears-1; year++)
                {
                    //calculates the interest
                    double interest = balance * rate /100;
                    balance = balance + interest;
                    balance1[0][year] = balance;
                    Area.append( balance + "\n");
                    
                }
               final BarChart chart = new BarChart("Balance Chart", balance1, initialbalance);
               chart.pack();
               RefineryUtilities.centerFrameOnScreen(chart);
               chart.setVisible(true);
                
            }
        }
        ActionListener listener = new ButtonListener();
        calculateButton.addActionListener(listener);
        return calculateButton;
    }
    
    /**
     * Makes the frame visible
     * @param args
     */
    public static void main(String[] args) 
    {
        JFrame frame = new SavingsCalculator();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SavingsCalculator");
        frame.setVisible(true);
        
         

      
    }
}

