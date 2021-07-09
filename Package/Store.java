package Package;

import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *  Represents a store
 *
 *  @author Isabelle
 *  @version May 6, 2021
 */
public class Store
{
    //~ Fields ................................................................
    private Map<Integer, Customer> customers;
    private Map<Integer, Employee> employees;
    private Set<Customer> loggedCustomers;
    private Set<Employee> loggedEmployees;
    private Queue<Customer> checkOutLine;
    private ItemStock itemList;

    /**
     * Create a new Store object.
     */
    //~ Constructors ..........................................................
    public Store()
    {
        customers = new HashMap<Integer, Customer>();
        loggedCustomers = new HashSet<Customer>();
        employees = new HashMap<Integer, Employee>();
        loggedEmployees = new HashSet<Employee>();
        checkOutLine = new LinkedList<Customer>();
        itemList = new ItemStock();
        new LoginGUI(this);
    }

    /**
     * Adds a new customer to the HashMap of customers
     * @return the ID number of the customer
     */
    public int addCustomer()
    {
        Customer customer = new Customer(this);
        customers.put(customer.getID(), customer);
        loggedCustomers.add(customer);
        return customer.getID();
    }

    /**
     * Adds a new Employee to the HashMap of employees
     * @return the ID number of the employee
     */
    public int addEmployee()
    {
        Employee employee = new Employee(this);
        employees.put(employee.getID(), employee);
        loggedEmployees.add(employee);
        return employee.getID();
    }

    /**
     * Logs in a Customer with the given ID
     * @param id is the ID of the Customer
     * @return true if successfully logged in, else false
     */
    public boolean loginCustomer(Integer id)
    {
        if (!customers.containsKey(id))
        {
            return false;
        }
        else if (loggedCustomers.contains(customers.get(id)))
        {
            return false;
        }
        loggedCustomers.add(customers.get(id));
        return true;
    }

    /**
     * Logs in an Employee with the given ID
     * @param id is the ID of the Employee
     * @return true if successfully logged in, else false
     */
    public boolean loginEmployee(Integer id)
    {
        if (!employees.containsKey(id))
        {
            return false;
        }
        else if (loggedEmployees.contains(employees.get(id)))
        {
            return false;
        }
        loggedEmployees.add(employees.get(id));
        return true;
    }

    /**
     * Logs out a Customer
     * @param customer is a Customer object
     */
    public void logoutCustomer(Customer customer)
    {
        loggedCustomers.remove(customer);
    }

    /**
     * Logs out an Employee
     * @param employee is an Employee object
     */
    public void logoutEmployee(Employee employee)
    {
        loggedEmployees.remove(employee);
    }
    /**
     * Queues up a customer ready to checkout
     * @param customer is a Customer object
     */
    public void lineUp(Customer customer)
    {
        checkOutLine.add(customer);
    }

    /**
     * Returns the list of registered customers
     * @return customers
     */
    public Map<Integer, Customer> getCustomers()
    {
        return customers;
    }

    /**
     * Returns the list of registered employees
     * @return employees
     */
    public Map<Integer, Employee> getEmployees()
    {
        return employees;
    }

    /**
     * Returns the queue of customers ready for checkout
     * @return checkOutLine
     */
    public Queue<Customer> getQueue()
    {
        return checkOutLine;
    }

    /**
     * Return the ItemStock of the store
     * @return itemList
     */
    public ItemStock getStock()
    {
        return itemList;
    }

    /**
     * Main method to start program
     * @param args
     */
    public static void main(String[] args)
    {
        new Store();
    }
    //~Public  Methods ........................................................
   /* public static void main( String[] args )
    {
        ItemStock items = new ItemStock();
        items.addStock( 1, new Item(1, 30, 4.00) );
        items.addStock( 10, new Item(10, 55, 1.50) );
        items.addStock( 37, new Item(37, 10, 3.99) );
        items.addStock( 25, new Item(25, 36, 51.50) );
        items.addStock( 64, new Item(64, 48, 19.99) );
        items.addStock( 3, new Item(3, 4, 99.99) );

        Store store = new Store();
        int id = store.addEmployee();
        store.loginEmployee(id);
        int id2 = store.addCustomer();
        store.loginCustomer(id2);
    }*/
}
