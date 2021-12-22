
/**
 * This is the Money class, and is the object that is used in virtually every other class in this project.
 * "Money" is represented as a number of cents. For example, one dollar would have 100 cents.
 * Money can be added and subtracted. The MN sales tax on any given amount of Money can be calculated as well.
 * Money is printed out in the form: "$0.00"
 * @author Aashish Bharath
 *
 */
public class Money {
    /**
     * Final Variable for 0 Dollar, and cents
     */
    public static final Money ZERO = new Money(0);
    /**
     * Final variable for One dollar, and 0 Cents. Otherwise known as 100 cents. 
     */
    public static final Money ONE_DOLLAR = new Money(100);
    /**
     * Final variable for two dollars, and 0 cents. Otherwise known as 200 cents. 
     */
    public static final Money TWO_DOLLAR = new Money(200);
    private int amountInCents;
    
    
    /**
     * Constructor for money. Specific amount cents will be inputed into amountInCents
     * @param cents amount of cents that needs to be inputted to create a Money object. 
     */
    public Money(int cents) {
        amountInCents = cents;
    }
    
    /**
     * Computes the MN sales tax that a given amount would have. 
     * @param itemCost the cost of the item in question. 
     * @return salesTaxAsMoney returns a Money object, and only returns the tax amount. 
     */
    public static Money computeMNSalesTax(Money itemCost) {
    //RETURN AMOUNT OF TAX
        int salesTax;
        
        salesTax = (int) Math.round(itemCost.amountInCents * .06875);
        
        Money salesTaxAsMoney = new Money(salesTax);
        return salesTaxAsMoney;
        
    }
    
    
    /**
     * Method adds two money object together, thus returning a new Money object which is the added number. 
     * @param other Money object that needs to be add to this.amountInCents
     * @return addedMoney a new Money object that is the result of addition between this.amountInCents and other.amountInCents.
     */
    public Money add(Money other) {
        Money addedMoney = new Money(amountInCents + other.amountInCents);
        return addedMoney;
    }
    
    /**
     * Method subtracts two Money objects, thus returning a new Money object which is the subtracted value. 
     * @param other Money object that needs to be subtracted to this.amountInCents
     * @return addedMoney a new Money object that is the result of subtraction between this.amountInCents and other.amountInCents.
     * 
     * Not used in CoffeeKiosk lab, but is useful to have if their are additonal feautres in the future. 
     */
    public Money subtract(Money other) {
        Money subtractedMoney = new Money(amountInCents - other.amountInCents);
        return subtractedMoney;
    }
    
    
    /**
     *Returns a easily readable format of amountInCents.
     *Examples.) if amountInCents equals 125 ---> toString() would return "$1.25"
     */
    @Override
    public String toString() {
        int wholePart;
        int decimalPart;
        wholePart = amountInCents/100;
        decimalPart = amountInCents - (wholePart*100);
        if(decimalPart<10) {
            return "$" + wholePart + ".0" + decimalPart;
        }
        return "$" + wholePart + "." + decimalPart;
        
    }

}
