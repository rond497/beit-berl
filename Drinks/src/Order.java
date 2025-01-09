/*
A complex class, referring to Drink and Customer, representing an order to be fulfilled
*/
public class Order {

    private int maxDrinks = 5;      // default for Max # of Drinks in an order
    private final Drink[] drinks;     // array of the drinks in the Order
    private final Customer customer;           // customer name
    private int discount;       // in percent

    int numDrinks = 0;      // actual number of drinks in an order
    /**
     * Constructors
     */
    public Order(Customer customer, int maxDrinks, int discount)
    {
        this.customer = customer;
        this.maxDrinks = maxDrinks; //should add a check that maxDrinks > 0 in all constructors
        this.drinks = new Drink[this.maxDrinks];    // try to use an ArrayList with dynamic sizing
        this.discount = discount;
    }
    public Order(Customer customer, int maxDrinks)
    {
        this.customer = customer;
        this.maxDrinks = maxDrinks;
        this.drinks = new Drink[this.maxDrinks]; //The number of Drinks in the order is set when constructing it
        this.discount = this.customer.getDiscount();
    }
    // Constructor with no discount and maxDrinks. discount is taken from the customer's
    // and maxDrinks is taken from default (5 now)
    public Order(Customer customer)
    {
        this.customer = customer;
        this.drinks = new Drink[this.maxDrinks]; //The number of Drinks in the order is set when constructing it
        this.discount = this.customer.getDiscount();
    }
    public String toString()    // I am not sure how appropriate is it to create multi-line toString,
                                // definitely unclear about enumerating the drinks in order.toString()
    {
        StringBuilder drinkList = new StringBuilder();
        for (int i = 0; i < numDrinks; i++)
            drinkList = drinkList.append(drinks[i]).append("\n");

        return "Order: customer details- " + this.customer + ".\nOrder has " + numDrinks +
                " items:\n" + drinkList + String.format("The total value is %.2f", this.checkOut());
    }
    // Getter methods
    public int getMaxDrinks () {
        return maxDrinks;
    }
    public int getDiscount() {
        return discount;
    }
    public String getCustomerName () {
        return this.customer.getName();
    }

    public Drink[] getDrinks()  {
        Drink[] outDrinks = new Drink[this.numDrinks];
        for (int i = 0; i < this.numDrinks; i++)
            outDrinks[i] = drinks[i].getDrink();
        return outDrinks;
    }

    // Setter for discount
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    //Adding a Drink to an order
    public void addDrink(Drink newDrink)
    {
        if (this.numDrinks == this.maxDrinks)
            System.out.println("Order is already Maxed out.");
        else
        {
            this.drinks[this.numDrinks] = newDrink;
            this.numDrinks++;
        }
    }
    public void changeDrink (Drink newDrink, int index) {
        this.drinks[index] = newDrink;
    }

    public double checkOut() {
        double total = 0.0;
        for (int i = 0; i < this.numDrinks; i++) {
            total += this.drinks[i].getPrice();
        }
        total = total * (1 - this.discount/100.);    // Applying the discount
        return total;
    }

}
