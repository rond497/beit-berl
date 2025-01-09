import java.util.*;
// Drink class for all drinks
public class Drink {
    static Scanner reader = new Scanner(System.in);
    // List to store all current drinks
    private static List<Drink> allDrinks = new ArrayList<>();
    // instance variables
    private String brand;         // name of the drink's brand
    private double percentAlcohol;      // percentage of alcohol in the drink
    private double price;
    private String type = "Drink";

    /*
     * Constructors for objects of class Drink
     */
    public Drink(String type, String brand, double percentAlcohol,double price)
    {
        allDrinks.add(this);
        this.brand = brand;
        this.percentAlcohol = percentAlcohol;
        this.price = price;
        this.type = type;
    }
    // Constructor in case nothing but brand is known
    public Drink(String brand, double percentAlcohol, double price) {
        allDrinks.add(this);
        this.brand = brand;
        this.percentAlcohol = percentAlcohol;
        this.price = price;
    }
    // Constructor in case nothing but brand is known
    public Drink(String type, String brand) {
        allDrinks.add(this);
        this.type = type;
        this.brand = brand;
    }

    // toString method to represent a Drink
    public String toString()
    {
        return String.format("Drink - Brand: %s, %% Alcohol: %.2f%%, price: %.2f", brand, percentAlcohol, price);
    }
    boolean equals(Drink d)
    {
        return this.toString().equals(d.toString());
    }
    // Get a list of all available drinks
    public static void listAllDrinks()
    {
        for (Drink d : allDrinks)
            System.out.println(d);
    }

    // Get methods for Drink's attributes
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public double getPercentAlcohol() { return percentAlcohol; }

    public Drink getDrink() {
        return new Drink(this.type, this.brand, this.percentAlcohol,this.price);
    }
    // Set methods for Drink's attributes
    public void setPrice(double newPrice)
    {
        this.price = newPrice;
    }
    public void setPercentAlcohol(double newPercentAlcohol)
    {
        this.percentAlcohol = newPercentAlcohol;
    }
    public void raisePrice(int percent)
    {
        this.price = this.price * (1 + percent/100.);
    }
    // Method to raise the price of all drinks by a certain percentage
    public static void raiseAllPrices(int percent)
    {
        for (Drink d : allDrinks)
            d.price = d.price * (1 + percent/100.);
    }
    public double setNewPrice()
    {
        System.out.println("Current price of " + this.brand + " is " + this.price +
                ". Please enter new price:");
        return this.price = reader.nextDouble();
    }
}