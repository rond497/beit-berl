public class Beer extends Drink {
    private final String type = "Beer";
    private String style;

    public Beer(String brand, double percentAlcohol, double price, String style) {
        super("Beer", brand, percentAlcohol, price);
        this.style = style;
    }
    // getter and setter methods for the style attribute
    public String getStyle() {
        return style;
    }
    public void setStyle(String newStyle) {
        this.style = newStyle;
    }
    public String getType() {
        return type;
    }
    // toString method to represent a Beer
    public String toString() {
        return "Beer " + super.toString() + ", style: " + style;
    }
    boolean equals(Beer b)
    {
        return this.toString().equals(b.toString());
    }
    // a clone method to return a new Beer object with the same attributes
    public Beer getBeer() {
        return new Beer(getBrand(), getPercentAlcohol(), getPrice(), getStyle());
    }
}
