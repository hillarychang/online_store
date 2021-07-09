package Package;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  Creates a GUI for the employee aspect of the store
 *  Functions include restocking items and checking out customers in the
 *  checkout queue. Has an additional feature of refreshing the GUI
 *
 *  @author Ryan
 *  @version May 14, 2021
 */
public class StoreEmployeeGUI implements ActionListener
{

    //~ Fields ................................................................
    private Store myStore;
    private int myId;
    private Item apple, banana, orange, milk, orangeJ, popcorn;
    private ItemStock myStock;
    private JFrame frame, loginFrame;
    private JPanel panel;
    private JLabel label, appleLabel, orangeLabel, milkLabel, bananaLabel, orangeJLabel,
                    popcornLabel, cInQueue;
    private Employee myEmployee;
    private JButton checkoutB, restockB, logout, refreshB;
    private Queue<Customer> line;

    /**
     * Create a new StoreEmployeeGUI object.
     * @param store is a Store object
     * @param id is the id Number of the Employee
     * @param loginFrame is the JFrame of the Login
     */
    //~ Constructors ..........................................................
    public StoreEmployeeGUI(Store store, int id, JFrame loginFrame)
    {
        myStore = store;
        myStock = myStore.getStock();
        this.loginFrame = loginFrame;
        myId = id;
        line = myStore.getQueue();
        myEmployee = (Employee)myStore.getEmployees().get(id);
        for (Object temp : myStock.getItemsList().values())
        {
            if (((Item)temp).getId() == 1)
            {
                apple = (Item)temp;
            }
            else if (((Item)temp).getId() == 10)
            {
                banana = (Item)temp;
            }
            else if (((Item)temp).getId() == 37)
            {
                orange = (Item)temp;
            }
            else if (((Item)temp).getId() == 25)
            {
                milk = (Item)temp;
            }
            else if (((Item)temp).getId() ==64)
            {
                orangeJ = (Item)temp;
            }
            else
            {
                popcorn = (Item)temp;
            }
        }
        frame = new JFrame();
        label = new JLabel("Select which to restock");
        appleLabel = new JLabel("Current Stock: " + apple.getStock());
        orangeLabel = new JLabel("Current Stock: " + orange.getStock());
        milkLabel = new JLabel("Current Stock: " + milk.getStock());
        bananaLabel = new JLabel("Current Stock: " + banana.getStock());
        orangeJLabel = new JLabel("Current Stock: " + orangeJ.getStock());
        popcornLabel = new JLabel("Current Stock: " + popcorn.getStock());
        cInQueue = new JLabel("Customers in Queue: " + line.size());
        panel = new JPanel();
        restockB = new JButton("Restock");
        checkoutB = new JButton("Checkout Customers");
        refreshB = new JButton("Refresh");
        logout = new JButton("Logout");
        restockB.addActionListener(this);
        checkoutB.addActionListener(this);
        refreshB.addActionListener(this);
        logout.addActionListener(this);
        panel.add(label, BorderLayout.CENTER);
        panel.add(appleLabel, BorderLayout.CENTER);
        panel.add(bananaLabel, BorderLayout.CENTER);
        panel.add(orangeLabel, BorderLayout.CENTER);
        panel.add(milkLabel, BorderLayout.CENTER);
        panel.add(orangeJLabel, BorderLayout.CENTER);
        panel.add(popcornLabel, BorderLayout.CENTER);
        panel.add(restockB);
        panel.add(cInQueue);
        panel.add(checkoutB);
        panel.add(refreshB);
        panel.add(logout);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 300);
        //frame.setTitle("Welcome to Store"); //title of window
        frame.setVisible(true);

    }

    //~Public  Methods ........................................................
    /**
     * Performs all the actions of the JButtons
     * @param e is the ActionEvent
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == restockB)
        {
            myEmployee.restock();
            refreshGUI();
        }

        if (e.getSource() == checkoutB)
        {
            myEmployee.checkOut();
            refreshGUI();
        }

        if (e.getSource() == refreshB)
        {
            refreshGUI();
        }

        if (e.getSource() == logout)
        {
            frame.dispose();
            myStore.logoutEmployee(myEmployee);
            loginFrame.setVisible(true);
        }
    }

    /**
     * Refreshes the GUI
     */
    private void refreshGUI()
    {
        frame.dispose();
        new StoreEmployeeGUI(myStore, myId, loginFrame);
    }
}
