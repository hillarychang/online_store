package Package;

import java.util.TreeMap;

/**
 * Represents a cart.
 *
 * @author Hillary
 * @version Apr 30, 2021
 */
public class Cart
{

    // ~ Fields ................................................................
    private TreeMap<Integer, Integer> cartMap;


    // ~ Constructors ..........................................................
    /**
     * Create a new Cart object.
     */
    public Cart()
    {
        cartMap = new TreeMap<Integer, Integer>();

    }


    // ~Public Methods ........................................................
    /**
     * Gets a cart.
     * @return a cart
     */
    public TreeMap<Integer, Integer> getCartMap()
    {
        return cartMap;
    }


    /**
     * Gets the number of items in the cart.
     * @return number of items in cart.
     */
    public int getNumOfItems()
    {
        int count = 0;
        for (int id : cartMap.keySet())
        {
            for (int i = 0; i < cartMap.get(id); i++)
            {
                count++;
            }
        }
        return count;
    }


    /**
     * Adds an item to the cart.
     * @param item is the item customer is adding
     * @return "No stock" if there is no more of the item;
     *          nothing if operation was successful
     */
    public String addItem(Item item)
    {
        if (item.getStock() != 0)
        { // check that there is enough of item to add
            if (!cartMap.containsKey(item.getId()))
            {
                cartMap.put(item.getId(), 1);
            }
            else
            {
                int count = cartMap.get(item.getId());
                cartMap.replace(item.getId(), count + 1);
            }
            System.out.println("You added item #" + item.getId() + " to your cart");
        }
        else
        {
            return ("No stock");
        }
        return null;
    }


    /**
     * Removes specified item from cart
     * @param item is the item customer is removing
     */
    public void removeItem(Item item)
    {
        if (cartMap.containsKey(item.getId()))
        { // check there is item to remove
            if (cartMap.get(item.getId()) > 0)
            {
                if (cartMap.get(item.getId()) - 1 == 0)
                {
                    cartMap.remove(item.getId());
                }
                else
                {
                    cartMap.replace(item.getId(), cartMap.get(item.getId()) - 1);
                }
            }
            else if (cartMap.get(item.getId()) <= 0)
            {
                cartMap.remove(item.getId());
            }
            System.out.println("You removed item #" + item.getId() + " from your cart");
        }
    }

}
