public class Whisky extends Drink {
    private final String type = "Whisky";
    private int age;    // Whisky age (in years)

    public Whisky(String brand, double percentAlcohol, double price, int age) {
        super("Whisky", brand, percentAlcohol, price);
        this.age = age;
    }
    public Whisky(String brand) {
        super("Whisky", brand);
    }
    // Get/set methods
    public int getAge() {
        return age;
    }
    public String getType() {
        return type;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    }
    // toString method to represent a Whisky
    public String toString() {
        return "Whisky " + super.toString() + ", age: " + age;
    }
    boolean equals(Whisky w)
    {
        return this.toString().equals(w.toString());
    }
    // a clone method to return a new Whisky object with the same attributes
    public Whisky getWhisky() {
        return new Whisky(getBrand(), getPercentAlcohol(), getPrice(), getAge());
    }
}
