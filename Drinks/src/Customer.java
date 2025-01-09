/*
Simple Class that represents the customers who may order drinks
 */
import java.util.*;
public class Customer {
    static Scanner reader = new Scanner(System.in);
    // Class attribute
    private static int totalCustomers = 0;
    private static int defaultDiscount = 10;

    // Customer attributes
    private final String name;
    private final int customerID;
    private int age;
    private int discount;   // level of discount, in percent

    // Customer constructor method
    public Customer (String name, int age, int discount) {
        this.name = name;
        totalCustomers++;
        this.customerID = totalCustomers;
        this.age = age;
        this.discount = discount;
    }
    // Customer constructor method with no discount set
    public Customer (String name, int age) {
        this.name = name;
        totalCustomers++;
        this.customerID = totalCustomers;
        this.age = age;
        this.discount = defaultDiscount;
    }
    // String to represent a Customer
    public String toString() {
        return "Name: " + name + ", ID: " + customerID + ", age: " + ((age == 0) ? "no age provided" : age)
                + ", discount: " + discount;
    }
    boolean equals(Customer c)
    {
        return this.toString().equals(c.toString());
    }
    // Getter methods
    public static int getTotalCustomers() { return totalCustomers; }
    public String getName() { return this.name; }
    public int getID() { return this.customerID; }
    public int getAge() { return this.age; }
    public int getDiscount() { return this.discount; }

    // Setter method
    public int setAge(int newAge) {
        return this.age = newAge;
    }
    // Method to set the default discount level of all customers (like in spring sale)
    public void setDefaultDiscount (int newDiscount) {
        defaultDiscount = newDiscount;
    }
    // Method to set the discount level of a customer using input
    public void setDiscount() {
        System.out.println("Current discount of " + this.name + " is " + this.discount +
            "%. Please enter new discount level:");
        this.discount = reader.nextInt();
    }
    public int raiseAge() {
        return age++;
    }

}
