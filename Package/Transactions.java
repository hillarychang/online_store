package Package;

//import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * This class manages the transactions of the customer's cart.
 *
 * @author Hillary
 * @version Apr 30, 2021
 */
public class Transactions
{
    // ~ Fields ................................................................
    private double totalPrice;
    private Customer customerObj;
    private ItemStock myStock;


    // ~ Constructors ..........................................................
    /**
     * Create a new Transactions object.
     * @param customer is a customer
     * @param stock is an ItemStock
     */
    public Transactions(Customer customer, ItemStock stock)
    {
        customerObj = customer;
        myStock = stock;
        //getCartMap()
        totalPrice = 0.00;
    }


    /**
     * Create a new Transactions object.
     * @param customer is a member
     * * @param stock is an ItemStock
     */
    public Transactions(Member customer, ItemStock stock)
    {
        customerObj = customer;
        myStock = stock;
        totalPrice = 0.00;
    }


    // ~Public Methods ........................................................
    /**
     * Takes all of the items in the cart and adds
     * them up together for the total price.
     * @return total price of the items in the cart
     */
    public double pay()
    {

        //double customerPayment = 0.00;
        double price = 0.00;
        double discount = 0.00;

        TreeMap<Integer, Integer> map = customerObj.getCart().getCartMap();

        System.out.println(map);

        //resolved error: what is getCart()?? want treeMap.keySet()
        Set<Integer> set1 = map.keySet();


        for (int id : set1)
        {
            price = myStock.lookUpItem(id).getPrice();
            for (int i = 0; i < map.get(id); i++)
            {
                totalPrice += price;
            }
             // gets price of item
        }

        // check if member to apply discount
        if (customerObj instanceof Member)
        {
            discount = ((Member)customerObj).applyDiscount(getTotalPrice());
            totalPrice -= totalPrice * discount;
        }

        //System.out.println("Total comes to: $"+totalPrice);
        //possibly check for cases
//        do
//        {
//            System.out.println("Enter payment in dollars and cents:");
//            Scanner scan = new Scanner(System.in);
//
//            customerPayment += scan.nextDouble();
//
//
//            if (customerPayment < totalPrice) {
//
//                System.out.println("You owe: $"+ Math.round((totalPrice-customerPayment)*100.0)/100.0); //should be 2 decimal places
//
//            }
//            else {
//                System.out.println("Amount of change for you: $"+ Math.round((customerPayment-totalPrice)*100.0)/100.0);
//            }
//
//        }
//        while (customerPayment < totalPrice); //while money inserted is not enough
// I/O testing purposes

        return totalPrice;
    }


    /**
     * Gets the total price.
     * @return the total price of all the items the customer wants.
     */
    public double getTotalPrice()
    {
        return totalPrice;
    }

}
