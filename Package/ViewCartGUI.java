package Package;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  Creates a GUI to view all the items in the cart. Functions include removing
 *  items from the cart if desired
 *
 *  @author Ryan
 *  @version May 16, 2021
 */
public class ViewCartGUI implements ActionListener
{
    //~ Fields ................................................................
    private Store myStore;
    private Customer myCustomer;
    private JFrame frame;
    private JButton backB, appleB, bananaB, orangeB, milkB, orangeJB, popcornB;
    private ItemStock myStock;
    private int apple, banana, orange, milk, orangeJ, popcorn;
    private JLabel appleLabel, orangeLabel, milkLabel, bananaLabel, orangeJLabel,
    popcornLabel;
    private TreeMap<Integer, Integer> myCart;
    //~ Constructors ..........................................................
    /**
     * Create a new ViewCartGUI object.
     * @param store is a Store object
     * @param customer is the Customer whose cart is to be displayed
     */
    public ViewCartGUI(Store store, Customer customer)
    {
        myStore = store;
        myCustomer = customer;
        viewCart();
    }
    /**
     * viewCart method initializes the parts that for the GUI
     */
    //~Public  Methods ........................................................
    public void viewCart()
    {
        frame = new JFrame();
        myStock = myStore.getStock();
        myCart = (myCustomer.getCart()).getCartMap();
        JLabel cartLabel = new JLabel("My Cart");
        JPanel panel = new JPanel();
        panel.add(cartLabel, BorderLayout.CENTER);
        if (myCart.size() == 0)
        {
            JLabel noItemsLabel = new JLabel("No Items in Cart");
            panel.add(noItemsLabel);
        }
        for (int id : myCart.keySet())
        {
            int count = myCart.get(id);
            if (id == 1)
            {
                apple = count;
            }
            else if (id == 10)
            {
                banana = count;
            }
            else if (id == 37)
            {
                orange = count;
            }
            else if (id == 25)
            {
                milk = count;
            }
            else if (id == 64)
            {
                orangeJ = count;
            }
            else if (id == 3)
            {
                popcorn = count;
            }
        }
        //if the item is in the cart, GUI will display item
        if (apple > 0)
        {
            appleLabel = new JLabel("Apple Count: " + apple);
            panel.add(appleLabel, BorderLayout.CENTER);
            appleB = new JButton("Remove");
            appleB.addActionListener(this);
            panel.add(appleB);

        }
        if (banana > 0)
        {
            bananaLabel = new JLabel("Banana Count: " + banana);
            panel.add(bananaLabel, BorderLayout.CENTER);
            bananaB = new JButton("Remove");
            bananaB.addActionListener(this);
            panel.add(bananaB);
        }
        if (orange > 0)
        {
            orangeLabel = new JLabel("Orange Count: " + orange);
            panel.add(orangeLabel, BorderLayout.CENTER);
            orangeB = new JButton("Remove");
            orangeB.addActionListener(this);
            panel.add(orangeB);
        }
        if (milk > 0)
        {
            milkLabel = new JLabel("Milk Count: " + milk);
            panel.add(milkLabel, BorderLayout.CENTER);
            milkB = new JButton("Remove");
            milkB.addActionListener(this);
            panel.add(milkB);
        }
        if (orangeJ > 0)
        {
            orangeJLabel = new JLabel("Orange Juice Count: " + orangeJ);
            panel.add(orangeJLabel, BorderLayout.CENTER);
            orangeJB = new JButton("Remove");
            orangeJB.addActionListener(this);
            panel.add(orangeJB);
        }
        if (popcorn > 0)
        {
            popcornLabel = new JLabel("Popcorn Count: " + popcorn);
            panel.add(popcornLabel, BorderLayout.CENTER);
            popcornB = new JButton("Remove");
            popcornB.addActionListener(this);
            panel.add(popcornB);
        }
        backB = new JButton("Back");
        backB.addActionListener(this);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(backB);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Performs all the actions of the JButtons (Primarily remove functionality
     * Updates the GUI after every action is performed
     * @param e is the ActionEvent
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backB)
        {
            frame.dispose();
        }
        if (e.getSource() == appleB)
        {
            removeAndRefresh(1);
        }
        if (e.getSource() == bananaB)
        {
            removeAndRefresh(10);
        }
        if (e.getSource() == orangeB)
        {
            removeAndRefresh(37);
        }
        if (e.getSource() == milkB)
        {
            removeAndRefresh(25);
        }
        if (e.getSource() == orangeJB)
        {
            removeAndRefresh(64);
        }
        if (e.getSource() == popcornB)
        {
            removeAndRefresh(3);
        }

    }

    /**
     * Removes one item from cart and refreshes the GUI
     * @param itemID
     */
    public void removeAndRefresh(int itemID)
    {
        frame.dispose();
        myCustomer.getCart().removeItem(myStock.lookUpItem(itemID));
        new ViewCartGUI(myStore, myCustomer);
    }

}
