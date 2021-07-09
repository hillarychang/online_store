package Package;

/**
 * Represents an item.
 *
 * @author Hillary
 * @version Apr 30, 2021
 */
public class Item
{

    // ~ Fields ................................................................
    private int myId;
    private int myStock;
    private double myPrice;

    // ~ Constructors ..........................................................
    /**
     * Create a new Item object.
     * @param id is the item's ID number
     * @param stock is the item's amount of stock
     * @param price is the price of the item
     */
    public Item(int id, int stock, double price) // inital stock
    {
        if (stock < 0)
        {
            myStock = 0;
        }
        else
        {
            myStock = stock;
        }
        if (price < 0)
        {
            myPrice = 0;
        }
        else
        {
            myPrice = price;
        }
        myId = id;

    }

    // ~Public Methods ........................................................
    /**
     * Gets item's price.
     * @return myPrice is the price of the item.
     */
    public double getPrice()
    {
        return myPrice;
    }

    /**
     * Gets the item's ID.
     * @return myId is the item's ID number.
     */
    public int getId()
    {
        return myId;
    }


    /**
     * Gets the amount of stock of an item.
     * @return the amount of stock
     */
    public int getStock()
    {
        return myStock;
    }

    /**
     * Sets the amount of stock of an item to specified amount.
     * @param stock is the amount of stock
     */
    public void setStock(int stock)
    {
        myStock = stock;
        return;
    }

}
