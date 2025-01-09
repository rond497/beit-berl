import java.awt.geom.*;
import static java.lang.Math.abs;

class Circle implements Object
{
    int diameter;    // The diameter of the circle
    int xPosition;   // The x,y coordinates of the upper-left corner
    int yPosition;   //    of a bounding square
    String color;    // The color of the circle

    // Create a new circle 
    Circle(int xPosition, int yPosition, int diameter, String color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.diameter  = diameter;
        this.color     = color;
        draw();
    }

    // Move the circle to a new position.
    @Override
    public void moveTo(int newX, int newY)
    {
        xPosition = newX;
        yPosition = newY;
    }   
    // Move the circle by an amount.
    @Override
    public void move(int deltaX, int deltaY)
    {
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
    }

    // Change the size to the new size.
    void changeSizeTo(int newDiameter)
    {
        diameter = newDiameter;
    }

    // Change the size by a factor.
    void changeSize(int deltaDiameter)
    {
        diameter = diameter * deltaDiameter;
    }

    public void inflate(int refX, int refY, double factor)
    {
        xPosition = refX - (int)(abs(factor) * diameter / 2);
        yPosition = refY - (int)(abs(factor) * diameter / 2);
        diameter = (int)(diameter * abs(factor));
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    @Override
    public void changeColor(String newColor)
    {
        color = newColor;
    }

    // Draw the circle with current specifications on screen.
    @Override
    public void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        canvas.fill(new Ellipse2D.Double(
            xPosition, yPosition, diameter, diameter));
        canvas.wait(50);
    }

    // Erase the circle on screen.
    @Override
    public void erase()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(new Ellipse2D.Double(
            xPosition, yPosition, diameter, diameter));
    }

}
