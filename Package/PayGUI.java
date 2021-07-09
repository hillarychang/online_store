package Package;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Queue;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *  Creates a GUI for the features of the Transactions class
 *  Processes the transactions for each customer in the queue
 *
 *  @author Ryan
 *  @version May 16, 2021
 */
public class PayGUI implements ActionListener
{
    //~ Fields ................................................................
    private JFrame frame;
    private JLabel label, change, amountDue;
    private JPanel panel;
    private JButton pay, nextCustomer;
    private NumberFormat dollarFormat;
    private double remaining;
    private JTextField amountPayed;
    private Queue<Customer> checkoutLine;
    private Customer myCustomer;
    private ItemStock myStock;

    /**
     * Create a new PayGUI object that processes the transactions
     * @param customerList is a Queue of all the customers ready for checkout
     * @param itmStk is an ItemStock of all the items
     */
    //~ Constructors ..........................................................
    PayGUI(Queue<Customer> customerList, ItemStock itmStk)
    {
        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        checkoutLine = customerList;
        myStock = itmStk;
        if (checkoutLine.isEmpty())
        {
            frame.dispose();
            return;
        }
        myCustomer = checkoutLine.remove();
        Transactions t = new Transactions(myCustomer, myStock);
        double totalPrice = t.pay();
        label = new JLabel("Checkout Customer ID: " + myCustomer.getID());
        change = new JLabel("");
        dollarFormat = new DecimalFormat("#0.00");
        remaining = totalPrice;
        amountDue = new JLabel("Amount Due: " + dollarFormat.format(remaining));
        amountPayed = new JTextField(20);
        pay = new JButton("Pay");
        pay.addActionListener(this);
        amountPayed.setBounds(100, 20, 165, 25);
        nextCustomer = new JButton("Next Customer");
        nextCustomer.addActionListener(this);
        panel.add(label, BorderLayout.CENTER);
        panel.add(amountDue);
        panel.add(amountPayed);
        panel.add(change);
        panel.add(pay);
        panel.add(nextCustomer);
        nextCustomer.setVisible(false);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    /**
     * Performs the actions of the JButtons
     * @param e is the ActionEvent
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Customer paying option
        if (e.getSource() == pay)
        {
            double temp;
            if (amountPayed.getText() == null)
            {
                temp = 0;
            }
            else
            {
                temp = Double.valueOf(amountPayed.getText());
            }

            double amount = Double.valueOf(amountDue.getText().substring(12));
            if (temp == amount)
            {
                change.setText("Change: 0.00");
                amountDue.setText("Amount Due: 0.00");
                nextCustomer.setVisible(true);
            }
            else if (temp > amount)
            {
                change.setText("Change: " + dollarFormat.format(temp - amount));
                amountDue.setText("Amount Due: 0.00");
                nextCustomer.setVisible(true);
            }
            else if (temp < amount)
            {
                amountDue.setText("Amount Due: " + dollarFormat.format(amount - temp));
            }
        }
        //queues next customer
        if (e.getSource() == nextCustomer)
        {
            frame.dispose();
            if (!checkoutLine.isEmpty())
            {
                PayGUI pGUI = new PayGUI(checkoutLine, myStock);
            }
        }
    }


}
