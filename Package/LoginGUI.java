package Package;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *  Create a GUI for the login features of the Store
 *  Functions include creating both new employees and customers and logging in
 *  employees and customers
 *
 *  @author Ryan
 *  @version May 11, 2021
 */
public class LoginGUI implements ActionListener
{
    private JLabel label, text, temp;
    private JFrame frame, ceFrame, newCEFrame;
    private JPanel panel;
    private JButton cButton, eButton, newCustomer, newEmployee,
                    cLogin, eLogin, yesButton, noButton, nextB;
    private Store myStore;
    private Item apple, banana, orange, milk, orangeJ, popcorn;
    private ItemStock myStock;
    private JTextField idText;
    private int id;


    /**
     * Create a new LoginGUI object.
     * @param store is a Store object
     */
    public LoginGUI(Store store) {

        myStore = store;
        myStock = myStore.getStock();
        apple = new Item(1, 30, 4.00);
        banana = new Item(10, 55, 1.50);
        orange = new Item(37, 10, 3.99);
        milk = new Item(25, 36, 51.50);
        orangeJ = new Item(64, 48, 19.99);
        popcorn = new Item(3, 4, 99.99);
        myStock.addStock(apple.getId(), apple);
        myStock.addStock(banana.getId(), banana);
        myStock.addStock(orange.getId(), orange);
        myStock.addStock(milk.getId(), milk);
        myStock.addStock(orangeJ.getId(), orangeJ);
        myStock.addStock(popcorn.getId(), popcorn);
        frame = new JFrame();
        label = new JLabel("Welcome to Store" + "\n Are you a Customer or Employee?");
        cButton = new JButton("Customer");
        eButton = new JButton("Employee");
        cButton.addActionListener(this);
        eButton.addActionListener(this);
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label, BorderLayout.CENTER);
        panel.add(cButton);
        panel.add(eButton);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome to Store"); //title of window
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Performs all the Actions of the JButtons
     * @param e is the ActionEvent
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == cButton)
        {
            frame.setVisible(false);
            ceFrame = new JFrame();
            ceFrame.setVisible(true);
            ceFrame.setSize(300,300);
            JPanel newPanel = new JPanel();
            JLabel idNum = new JLabel("ID Number: ");
            idText = new JTextField(20);
            idText.setBounds(100, 20, 165, 25);
            cLogin = new JButton("Login");
            cLogin.setBounds(10, 110, 300, 25);
            newPanel.add(idNum, BorderLayout.CENTER);
            newPanel.add(idText,BorderLayout.CENTER);
            newPanel.add(cLogin);
            text = new JLabel("");
            cLogin.addActionListener(this);
            newCustomer = new JButton("New Customer");
            newPanel.add(newCustomer, BorderLayout.CENTER);
            newPanel.add(text, BorderLayout.CENTER);
            newCustomer.addActionListener(this);
            ceFrame.add(newPanel, BorderLayout.CENTER);
            ceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ceFrame.setTitle("Customer"); //title of window

        }

        if (e.getSource() == eButton)
        {
            frame.setVisible(false);
            ceFrame = new JFrame();
            ceFrame.setVisible(true);
            ceFrame.setSize(300,300);
            JPanel newPanel = new JPanel();
            JLabel idNum = new JLabel("ID Number: ");
            idText = new JTextField(20);
            idText.setBounds(100, 20, 165, 25);
            eLogin = new JButton("Login");
            eLogin.setBounds(10, 110, 165, 25);
            newPanel.add(idNum, BorderLayout.CENTER);
            newPanel.add(idText,BorderLayout.CENTER);
            newPanel.add(eLogin);
            text = new JLabel("");
            eLogin.addActionListener(this);
            newEmployee = new JButton("New Employee");
            newPanel.add(newEmployee);
            newPanel.add(text, BorderLayout.CENTER);
            newEmployee.addActionListener(this);
            ceFrame.add(newPanel, BorderLayout.CENTER);
            ceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ceFrame.setTitle("Employee"); //title of window
        }

        if (e.getSource() == newCustomer)
        {
            ceFrame.dispose();

            id = myStore.addCustomer();
            text = new JLabel("Welcome Customer ID: " +  id);
            newCEFrame = new JFrame();
            JPanel cPanel = new JPanel();
            JLabel yNLabel = new JLabel("Would you like to join the membership program?");
            yesButton = new JButton("Yes");
            noButton = new JButton("No");
            temp = new JLabel("");
            cPanel.add(text);
            cPanel.add(yNLabel);
            cPanel.add(yesButton);
            cPanel.add(noButton);
            cPanel.add(temp);
            yesButton.addActionListener(this);
            noButton.addActionListener(this);
            newCEFrame.setVisible(true);
            newCEFrame.add(cPanel, BorderLayout.CENTER);
            newCEFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newCEFrame.setSize(325, 150);
        }

        if (e.getSource() == newEmployee)
        {
            id = myStore.addEmployee();
            //text.setText("Welcome Employee ID: " +  id);
            ceFrame.dispose();
            newCEFrame = new JFrame();
            JPanel newCEPanel = new JPanel();
            JLabel welcomeLabel = new JLabel("Welcome Employee ID: " +  id);
            nextB = new JButton("Next");
            nextB.addActionListener(this);
            newCEPanel.add(welcomeLabel);
            newCEPanel.add(nextB);
            newCEFrame.add(newCEPanel, BorderLayout.CENTER);
            newCEFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newCEFrame.setVisible(true);
            newCEFrame.setSize(400, 100);
            myStore.loginEmployee(id);
        }

        if (e.getSource() == cLogin)
        {
            String idNum = idText.getText();
            if (idNum.equals("") || idNum == null)
            {
                text.setText("No Input" + "\n" + "Try Again");
                return;
            }
            boolean success = myStore.loginCustomer(Integer.valueOf(idNum));
            if (success)
            {
                ceFrame.setVisible(false);
                text.setText("Login Successful");
                new StoreCustomerGUI(myStore, Integer.valueOf(idNum), frame);

            }
            else
            {
                text.setText("Login Failed" + "\n" + "Try Again");
            }
        }

        if (e.getSource() == eLogin)
        {
            String idNum = idText.getText();
            if (idNum.equals("") || idNum == null)
            {
                text.setText("No Input" + "\n" + "Try Again");
                return;
            }
            boolean success = myStore.loginEmployee(Integer.valueOf(idNum));
            if (success)
            {
                ceFrame.setVisible(false);
                text.setText("Login Successful");
                new StoreEmployeeGUI(myStore, Integer.valueOf(idNum), frame);

            }
            else
            {
                text.setText("Login Failed" + "\n" + "Try Again");
            }
        }

        if (e.getSource() == yesButton)
        {
            temp.setText("Successfully Joined Membership");
            Member mem = new Member(myStore, id);
            myStore.getCustomers().replace(id, mem);
            mem.setMembership(true);
            newCEFrame.dispose();
            myStore.loginCustomer(id);
            new StoreCustomerGUI(myStore, id, frame);

        }

        if (e.getSource() == noButton)
        {
            myStore.getCustomers().get(id).setMembership(false);
            newCEFrame.dispose();
            myStore.loginCustomer(id);
            new StoreCustomerGUI(myStore, id, frame);
        }

        if (e.getSource() == nextB)
        {
            newCEFrame.dispose();
            new StoreEmployeeGUI(myStore, id, frame);
        }
    }


}
