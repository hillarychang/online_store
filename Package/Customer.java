package Package;

//import java.util.Scanner;

/**
 *  Creates a Customer object
 *
 *  @author Ryan
 *  @version Apr 30, 2021
 */
public class Customer extends Person
{
    //~ Fields ................................................................
    private boolean membershipStatus;
    private Cart myCart;


    /**
     * Create a new Customer object.
     * @param store is a Store object
     */
    //~ Constructors ..........................................................
    public Customer(Store store) //new customer
    {
        super(store); //person with no id
        //newMember(); for IO purposes only
        myCart = new Cart();
        membershipStatus = false;
    }

    /**
     * Create a new Customer object with a given ID number.
     * @param store is a Store object
     * @param id is the ID number
     */
    public Customer(Store store, int id)
    {
        super(store, id); //person with id
        myCart = new Cart();
        membershipStatus = false;
    }

    //~Public  Methods ........................................................
    //for input/ouput purposes only
//    private void newMember()
//    {
//        boolean done = false;
//        Scanner input = new Scanner(System.in);
//        do
//        {
//            System.out.println("Register for membership");
//            System.out.println("Enter: Yes or No");
//            String response = input.nextLine();
//            if (response.length() > 0 )
//            {
//                System.out.println();
//                switch (response.toUpperCase())
//                {
//                    case "YES":
//                        done = true;
//                        System.out.println("Success");
//                        membershipStatus = true;
//                        break;
//
//                    case "NO":
//                        done = true;
//                        System.out.println("Success))))");
//                        membershipStatus = false;
//                        break;
//
//                    default:
//                        if (!response.equalsIgnoreCase("Yes") && !response.equalsIgnoreCase("No"))
//                        {
//                            System.out.print("Invalid Input");
//                        }
//                }
//            }
//        } while (!done);
//    }
    /**
     * changes the Membership status of the customer to the given status
     * @param status is a boolean, true == is member, else false
     */
    public void setMembership(boolean status)
    {
        //for gui purposes
        membershipStatus = status;
    }

    /**
     * Returns whether the customer is a member or not
     * @return true if is a member, else false
     */
    public boolean isMember() //checks if member for discount
    {
        if (membershipStatus == true)
        {
            return true;
        }
        return false;
    }

    /**
     * Returns the cart of the Customer
     * @return myCart
     */
    //added
    public Cart getCart()
    {
        return myCart;
    }

}
