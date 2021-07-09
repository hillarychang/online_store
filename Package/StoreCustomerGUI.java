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

/**
 *  Creates a GUI for the Customer aspect of the store. Functions of the
 *  customer include adding items to the cart. An additional feature is viewing
 *  the items in the customers cart
 *
 *  @author Ryan
 *  @version May 12, 2021
 */
public class StoreCustomerGUI implements ActionListener
{
    //~ Fields ................................................................
    private Store myStore;
    private Object myCustomer;
    private Item apple, banana, orange, milk, orangeJ, popcorn;
    private ItemStock myStock;
    private JFrame frame, loginFrame, exitFrame;
    private JLabel label, appleLabel, orangeLabel, milkLabel, bananaLabel,
            orangeJLabel, popcornLabel;
    private JButton appleB, bananaB, orangeB, milkB, orangeJB, popcornB, checkoutB,
            viewCartB, exitB;

    /**
     * Create a new StoreCustomerGUI object.
     * @param store is a Store object
     * @param id is the ID number of the customer
     * @param loginFrame is the JFrame of the login feature
     */
    //~ Constructors ..........................................................
    public StoreCustomerGUI(Store store, int id, JFrame loginFrame)
    {
        myStore = store;
        myStock = myStore.getStock();
        myCustomer = myStore.getCustomers().get(id);
        this.loginFrame = loginFrame;
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

        label = new JLabel("Select the items you wish to buy");
        JLabel itemsLabel = new JLabel("Items");
        JLabel checkoutLabel = new JLabel("Ready to Check out");
        //labels of all items with stock count
        appleLabel = new JLabel("Current Stock: " + apple.getStock());
        orangeLabel = new JLabel("Current Stock: " + orange.getStock());
        milkLabel = new JLabel("Current Stock: " + milk.getStock());
        bananaLabel = new JLabel("Current Stock: " + banana.getStock());
        orangeJLabel = new JLabel("Current Stock: " + orangeJ.getStock());
        popcornLabel = new JLabel("Current Stock: " + popcorn.getStock());
        //buttons of all items
        appleB = new JButton("Apple");
        bananaB = new JButton("Banana");
        orangeB = new JButton("Orange");
        milkB = new JButton("Milk");
        orangeJB = new JButton("Orange Juice");
        popcornB = new JButton("Popcorn");
        checkoutB = new JButton ("Checkout");
        viewCartB = new JButton ("View Cart");
        //actions of all buttons
        appleB.addActionListener(this);
        bananaB.addActionListener(this);
        orangeB.addActionListener(this);
        milkB.addActionListener(this);
        orangeJB.addActionListener(this);
        popcornB.addActionListener(this);
        viewCartB.addActionListener(this);
        checkoutB.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label, BorderLayout.CENTER);
        panel.add(itemsLabel, BorderLayout.CENTER);
        panel.add(appleB);
        panel.add(appleLabel, BorderLayout.CENTER);
        panel.add(bananaB);
        panel.add(bananaLabel, BorderLayout.CENTER);
        panel.add(orangeB);
        panel.add(orangeLabel, BorderLayout.CENTER);
        panel.add(milkB);
        panel.add(milkLabel, BorderLayout.CENTER);
        panel.add(orangeJB);
        panel.add(orangeJLabel, BorderLayout.CENTER);
        panel.add(popcornB);
        panel.add(popcornLabel, BorderLayout.CENTER);
        panel.add(viewCartB);
        panel.add(checkoutLabel, BorderLayout.CENTER);
        panel.add(checkoutB);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
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
        //actions of all JButtons of the items (adding to cart if possible)
        if (e.getSource() == appleB)
        {
            if (apple.getStock() > 0)
            {
                apple.setStock(apple.getStock() - 1);
                appleLabel.setText("Current Stock: " + apple.getStock());
                ((Customer)myCustomer).getCart().addItem(apple);
                //Cart temp = ((Customer)myCustomer).getCart(); //testing purposes
                //System.out.println(temp.getNumOfItems());
            }
            else
            {
                appleLabel.setText("No Stock; Employee will restock shortly");
            }
        }

        if (e.getSource() == bananaB)
        {
            if (banana.getStock() > 0)
            {
                banana.setStock(banana.getStock() - 1);
                bananaLabel.setText("Current Stock: " + banana.getStock());
                ((Customer)myCustomer).getCart().addItem(banana);
                //Cart temp = ((Customer)myCustomer).getCart();
                //System.out.println(temp.getNumOfItems());
            }
            else
            {
                bananaLabel.setText("No Stock; Employee will restock shortly");
            }
        }

        if (e.getSource() == orangeB)
        {
            if (orange.getStock() > 0)
            {
                orange.setStock(orange.getStock() - 1);
                orangeLabel.setText("Current Stock: " + orange.getStock());
                ((Customer)myCustomer).getCart().addItem(orange);
                //Cart temp = ((Customer)myCustomer).getCart();
                //System.out.println(temp.getNumOfItems());
            }
            else
            {
                orangeLabel.setText("No Stock; Employee will restock shortly");
            }
        }

        if (e.getSource() == milkB)
        {
            if (milk.getStock() > 0)
            {
                milk.setStock(milk.getStock() - 1);
                milkLabel.setText("Current Stock: " + milk.getStock());
                ((Customer)myCustomer).getCart().addItem(milk);
                //Cart temp = ((Customer)myCustomer).getCart();
                //System.out.println(temp.getNumOfItems());
            }
            else
            {
                milkLabel.setText("No Stock; Employee will restock shortly");
            }
        }

        if (e.getSource() == orangeJB)
        {
            if (orangeJ.getStock() > 0)
            {
                orangeJ.setStock(orangeJ.getStock() - 1);
                orangeJLabel.setText("Current Stock: " + orangeJ.getStock());
                ((Customer)myCustomer).getCart().addItem(orangeJ);
                //Cart temp = ((Customer)myCustomer).getCart();
                //System.out.println(temp.getNumOfItems());
            }
            else
            {
                orangeJLabel.setText("No Stock; Employee will restock shortly");
            }
        }

        if (e.getSource() == popcornB)
        {
            if (popcorn.getStock() > 0)
            {
                popcorn.setStock(popcorn.getStock() - 1);
                popcornLabel.setText("Current Stock: " + popcorn.getStock());
                ((Customer)myCustomer).getCart().addItem(popcorn);
                //Cart temp = ((Customer)myCustomer).getCart();
                //System.out.println(temp.getNumOfItems());
            }
            else
            {
                popcornLabel.setText("No Stock; Employee will restock shortly");
            }
        }
        //creates another GUI that will show the items in the cart
        if (e.getSource() == viewCartB)
        {
            new ViewCartGUI(myStore, (Customer)myCustomer);
        }

        //checks out customer and adds them to the queue
        //returns to login page after
        if (e.getSource() == checkoutB)
        {
            //if cart is empty doesn't add customer to the checkout line
            if (!((Customer)myCustomer).getCart().getCartMap().isEmpty() && !myStore.getQueue().contains(myCustomer))
            {
                myStore.lineUp((Customer)myCustomer);
            }
            myStore.logoutCustomer((Customer)myCustomer);
            frame.dispose();
            loginFrame.setVisible(true);
            exitFrame = new JFrame();
            JLabel tyLabel = new JLabel("Thank You");
            JLabel waitLabel = new JLabel("Please wait in line");
            exitB = new JButton("Exit");
            JPanel tempPanel = new JPanel();
            exitB.addActionListener(this);
            tempPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
            tempPanel.setLayout(new GridLayout(0, 1));
            tempPanel.add(tyLabel);
            tempPanel.add(waitLabel);
            tempPanel.add(exitB);
            exitFrame.add(tempPanel, BorderLayout.CENTER);
            exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            exitFrame.pack();
            exitFrame.setVisible(true);
        }

        if (e.getSource() == exitB)
        {
            exitFrame.dispose();
        }
    }
}
