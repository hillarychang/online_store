package Package;
import java.util.Map;

/**
 *  Represents a person that will have an ID number and is part of a Store
 *
 *  @author Isabelle
 *  @version May 6, 2021
 */
public class Person
{
    //~ Fields ................................................................
    private Store myStore;
    private int myID;

    //~ Constructors ..........................................................
    /**
     * Create a new Person object and intializes their id number for them.
     * @param store is a Store Object
     */
    public Person(Store store)
    {
        myStore = store;
        String str = "";
        //creates an id num and checks if store already has someone with the
        //same id
        do
        {
            for (int idCount = 0; idCount < 6; idCount++)
            {
                str += "" + (int)(Math.random() * 10);
            }
        }
        while (containsPerson(str));
        myID = Integer.valueOf(str);
    }

    /**
     * Create a new Person object with a given id.
     * @param store
     * @param id
     */
    public Person(Store store, int id)
    {
        myStore = store;
        //creates new id if id is already in use
        if (containsPerson(((Integer)id).toString()))
        {
            String str = "";
            do
            {
                for (int idCount = 0; idCount < 6; idCount++)
                {
                    str += "" + (int)(Math.random() * 10);
                }
            }
            while (containsPerson(str));
            myID = Integer.valueOf(id);
        }
        else
        {
            myID = id;
        }
    }

    //~Public  Methods ........................................................
    /**
     * Returns the ID number person
     * @return returns myID
     */
    public int getID()
    {
        return myID;
    }

    /**
     *
     * Checks if the ID number is already in use by a customer or employee
     * @param id
     * @return
     */
    private boolean containsPerson(String id)
    {
        //checks if store already has someone with the same id num
        Map<Integer, Customer> customers = myStore.getCustomers();
        Map<Integer, Employee> employees = myStore.getEmployees();
        if (customers.containsKey(Integer.valueOf(id)))
        {
            return true;
        }
        if (employees.containsKey(Integer.valueOf(id)))
        {
            return true;
        }
        return false;
    }
}
