package Package;
/**
 *  Creates a Member object that has an additional feature of having a discount
 *
 *  @author Ryan
 *  @version Apr 30, 2021
 */
public class Member extends Customer
{
    //~ Fields ................................................................
    private final double DISCOUNT = 0.1; //discount 10 percent off

    //~ Constructors ..........................................................
    /**
     * Create a new Member object.
     * @param store is a Store object
     */
    public Member(Store store)
    {
        super(store);
    }

    /**
     * Create a new Member object with a given ID number.
     * @param store is a Store object
     * @param id is the Id number
     */
    public Member(Store store, int id)
    {
        super(store, id);
    }
    //~Public  Methods ........................................................
    /**
     * Applies the discount for the member
     * @param totalPrice total price of all items in cart
     * @return the total discount
     */
    public double applyDiscount(double totalPrice)
    {
        double additionalDiscount = 0;
        if (luckyNumber() == 7) //lucky 7 --> additional 7% discount
        {
            additionalDiscount = 0.07;
        }
        //if total price is over x amount get an additional 5% off
        if (totalPrice >= 50.0)
        {
            return DISCOUNT + 0.05 + additionalDiscount;
        }
        return DISCOUNT + additionalDiscount;
    }

    /**
     * Generates random integer that can give the customer an additional
     * discount
     * @return num
     */
    private int luckyNumber()
    {
        int num = (int)(Math.random() * 10) + 1;
        return num;
    }

}
