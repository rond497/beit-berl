import java.awt.geom.*;

public class Arc implements Object {
    int xPosition, yPosition;   // The x,y coordinates of its top vertex
    int width, height;          // The width and height of the arc (its bounding box)
    int startAngle, arcAngle;   // The start angle and extent of the arc
    String color = "black";     // The color of the arc

    // Create a new arc
    Arc(int xPosition, int yPosition, int width, int height, int startAngle, int arcAngle, String color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;
        this.color = color;
        draw();
    }

    public void draw() {
        // Draw the arc
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        canvas.fill(new Arc2D.Double(xPosition, yPosition, width, height, startAngle, arcAngle, Arc2D.PIE));
        canvas.wait(50);
    }
    public void erase() {
        // Erase the arc
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(new Arc2D.Double(xPosition, yPosition, width, height, startAngle, arcAngle, Arc2D.PIE));
    }
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }
    public void move(int deltaX, int deltaY)
    {
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
    //    draw();
    }
    public void moveTo(int newX, int newY) {
        xPosition = newX;
        yPosition = newY;
    }

    @Override
    public void inflate(int refX, int refY, double factor) {
        double fctr = Math.abs(factor);
        xPosition = refX + (int)((xPosition - refX) * fctr);
        yPosition = refY + (int)((yPosition - refY) * fctr);
        width = (int)(width * fctr);
        height = (int)(height * fctr);
        draw();
    }
}


