import java.awt.*;

class Triangle implements Object
{

    int width;       // The width of the triangle
    int height;      // The height of the triangle
    int xPosition;   // The x,y coordinates of its top vertex
    int yPosition;

    int centerX;       // The x,y coordinates of the reference point
    int centerY;
    int radius;
    String color;    // The color of the triangle

    // Create a new triangle
    Triangle(int centerX, int centerY, int radius, int xPosition, int yPosition, int width, int height, String color)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width     = width;
        this.height    = height;
        this.color     = color;
        draw();
    }

    // Move the triangle to a new position.
    @Override
    public void moveTo(int newX, int newY)
    {
        xPosition = newX;
        yPosition = newY;
    }

    // Move the triangle by an amount.
    @Override
    public void move(int deltaX, int deltaY)
    {
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
        centerX = centerX + deltaX;
        centerY = centerY + deltaY;
    }

    // Change the size to the new size.
    void changeSizeTo(int newWidth, int newHeight)
    {
        width  = newWidth;
        height = newHeight;
    }

    // Change the size by a factor.
    void changeSize(double factor)
    {
        erase();
        yPosition = yPosition - (int)(height * (factor-1));
        width = (int)(width * factor);
        height = (int)(height * factor);
        draw();
    }

    // Inflate the triangle by a factor.
    @Override
    public void inflate (int refX, int refY, double factor)
    {
        erase();
        xPosition = centerX + (int)((xPosition - centerX) * factor);
        yPosition = centerY + (int)((yPosition - centerY) * factor);
        width = (int)(width * factor);
        height = (int)(height * factor);
        draw();
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    @Override
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    // Draw the triangle with current specifications on screen.
    @Override
    public void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        int[] xpoints =
            { xPosition, xPosition + (width/2), xPosition - (width/2) };
        int[] ypoints =
            { yPosition, yPosition + height, yPosition + height };
        canvas.fill(new Polygon(xpoints, ypoints, 3));
        canvas.wait(50);
    }

    // Erase the triangle on screen.
    @Override
    public void erase()
    {
        Canvas canvas = Canvas.getCanvas();
        int[] xpoints =
            { xPosition, xPosition + (width/2), xPosition - (width/2) };
        int[] ypoints =
            { yPosition, yPosition + height, yPosition + height };
        canvas.erase(new Polygon(xpoints, ypoints, 3));
    }

}
