
class Line implements Object
{
    int    xPosition;   // The x,y coordinates of its start
    int    yPosition;
    int    xEnd;        // The x,y coordinates of its end
    int    yEnd;
    String color;       // The color of the line

    // Create a new line 
    Line(int xPosition, int yPosition, int xEnd, int yEnd, String color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xEnd      = xEnd;
        this.yEnd      = yEnd;
        this.color     = color;
        draw();
    }

    // Move the line to a new position.
    @Override
    public void moveTo(int newX, int newY)
    {
        xEnd      = (xEnd-xPosition) + newX;
        yEnd      = (yEnd-yPosition) + newY;
        xPosition = newX;
        yPosition = newY;
    }

    // Move the line by an amount.
    @Override
    public void move(int deltaX, int deltaY)
    {
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
        xEnd      = xEnd      + deltaX;
        yEnd      = yEnd      + deltaY;
    }

    // Change the size by a factor.
    void changeSize(int factor)
    {
        xEnd = (xEnd - xPosition) * factor;
        yEnd = (yEnd - yPosition) * factor;
    }

    // Inflate the line by a factor.
    @Override
    public void inflate(int refX, int refY, double factor)
    {
        xPosition = refX + (int)((xPosition - refX) * factor);
        yPosition = refY + (int)((yPosition - refY) * factor);
        xEnd = refX + (int)((xEnd - refX) * factor);
        yEnd = refY + (int)((yEnd - refY) * factor);
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    @Override
    public void changeColor(String newColor)
    {
        color = newColor;
    }

    // Draw the line with current specifications on screen.
    @Override
    public void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        canvas.drawLine(xPosition, yPosition, xEnd, yEnd);
        canvas.wait(50);
    }

    // Erase the line on screen.
    @Override
    public void erase()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.eraseLine(xPosition, yPosition, xEnd, yEnd);
    }

}
