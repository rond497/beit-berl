/*
Main class to run an ordering systems, where customers can order drinks.
It instantiates available Drinks, possible Customers, starts an Order and takes it
all the way to check out.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Initialize our Drink store, Customers and Orders");
        // Define Drinks
        Drink goldstar = new Beer("Goldstar", 5.5, 8, "Lager");
        Drink johnny = new Whisky("Johnny Walker", 40, 128, 12);
        Drink macallan = new Whisky("Macallan", 46, 260, 18);
        Drink glenfiddich = new Whisky("Glenfiddich");
        Drink coke = new Drink("Cocacola", 0.0, 12.0);

        System.out.println("List of all available drinks:");
        Drink.listAllDrinks();

        // raising the price of all drinks by 10%
        Drink.raiseAllPrices(10);
        System.out.println("\nList of all available drinks, after 10% price raise:");
        Drink.listAllDrinks();

        // Define Customers
        Customer ron = new Customer("Ron", 55, 15);
        Customer dan = new Customer("Dan", 18); // not in use for now
        System.out.printf("\nNumber of customers: %d\n", Customer.getTotalCustomers());   // Static attribute and method
        //System.out.println("Is Dan === Ron? " + dan.equals(ron));
        System.out.println("Is Dan an instance of Customer? " + (dan instanceof Customer));
        System.out.println("Is goldstar an instance of Whisky? " + (goldstar instanceof Whisky));


        // create empty Order of a customer
        Order ronOrder = new Order(ron);

        // add/change Drinks to order
        ronOrder.addDrink(goldstar);
        ronOrder.addDrink(johnny);
        ronOrder.addDrink(goldstar);

        ronOrder.changeDrink(macallan, 2); // Test: change the second drink to Macallan

        // Testing copying of drinks for order
        Drink[] myDrinks;
        myDrinks = ronOrder.getDrinks();
        System.out.printf("\nTesting copying of drinks for order of customer %s", ronOrder.getCustomerName());
        System.out.printf(", total drinks = %d.\n", myDrinks.length);
        for (int i = 0; i < myDrinks.length; i++)
            System.out.printf("Drink %d: %s\n", i+1, myDrinks[i]);

        // Output Order:
        System.out.println("\n-->Order summary, using toString():\n" + ronOrder);
    }
}