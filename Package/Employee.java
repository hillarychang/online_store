package Package;

import java.util.Queue;

/**
 *  Represents an employee that will have an ID number and is part of a store
 *
 *  @author Isabelle
 *  @version May 6, 2021
 */
public class Employee extends Person
{
    //~ Fields ................................................................
    private Queue<Customer> checkOutLine;
    private ItemStock stock;

    //~ Constructors ..........................................................
    /**
     * Create a new Employee object.
     * @param store is a Store object
     */
    public Employee(Store store)
    {
        super(store);
        checkOutLine = store.getQueue();
        stock = store.getStock();
    }

    /**
     * Create a new Employee object with a given ID.
     * @param store is a Store object
     * @param id is the given id number
     */
    public Employee(Store store, int id)
    {
        super(store, id);
        stock = store.getStock();
        checkOutLine = store.getQueue();
    }

    /**
     * Checkout the customers in the queue
     */
    //~Public  Methods ........................................................
    public void checkOut()
    {
        //System.out.println(checkOutLine.isEmpty());
        new PayGUI(checkOutLine, stock);
        //Customer c = checkOutLine.remove();
        //Transactions t = new Transactions(c, stock);
        //double price = t.pay();
        //System.out.println(price);
    }

    /**
     * Restocks all items in the store
     */
    public void restock()
    {
        stock.restock();
    }
}