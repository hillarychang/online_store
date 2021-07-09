package Package;

import java.util.*;

/**
 *  Keeps track of all items in the store in a HashMap
 *
 *  @author Isabelle
 *  @version May 6, 2021
 */
public class ItemStock
{
    //~ Fields ................................................................
    private Map<Integer, Item> itemList;

    //~ Constructors ..........................................................
    /**
     * Create a new ItemStock object.
     */
    public ItemStock()
    {
        itemList = new HashMap<Integer, Item>();
    }

    /**
     * Create a new ItemStock object.
     * @param id is the id number of the Item
     * @param item is an Item object
     */
    public ItemStock(int id, Item item)
    {
        itemList = new HashMap<Integer, Item>();
        itemList.put(id, item);
    }

    /**
     * Checks stock of all items in the hashmap and if stock of an item is less
     * than 6, restock item's current stock to a value of 50
     */
    //~Public  Methods ........................................................
    public void restock()
    {
        for (int id : itemList.keySet())
        {
            if (itemList.get(id).getStock() <= 5)
            {
                itemList.get(id).setStock(50);
            }
        }
    }

    /**
     * Adds an Item to the list of all items
     * @param id is the id number of the Item
     * @param item is an Item object
     * @return true if successfully added, else false
     */
    public boolean addStock(int id, Item item)
    {
        if (itemList.containsKey(id))
        {
            return false;
        }
        itemList.put(id, item);
        return true;
    }

    /**
     * Looks up an Item in the stock of Items with its ID and returns it
     * @param id is the id number of the Item
     * @return Item
     */
    public Item lookUpItem(int id)
    {
        return itemList.get(id);
    }

    /**
     * Returns the map of all the items in the store
     * @return Map of items
     */
    public Map<Integer, Item> getItemsList()
    {
        return itemList;
    }
}
