import java.util.List;

// Note: to modify a class of a specific object to have an interface of Object, you can do the following:
// 1. Create a new interface Object.java with all relevant methods (Done)
// 2. Modify the class to implement the interface Object
// 3. Make all related methods public
// 4. Add the @Override annotation to all such methods
//

class Mouse
{
    int centerX;       // The x,y coordinates of the reference point
    int centerY;
    int radius;     // The radius of the mouse
    String  color;      // The color of the mouse

    Circle   face;        /* The features of the mouse */
    Triangle ear1;
    Triangle ear2;
    Line   whisker1; // = new Line(80, 120,  100, 120, "black");;
    Line   whisker2;
    Line   whisker3;
    Line   whisker4;
    Arc    mouth1;
    Arc    mouth2;

    List<Object> objects;  ;

    /* Construct a mouse object with exact specifications. NOT USED! */
    Mouse()
    {
        face = new Circle(  100, 100,  40,      "black");
        whisker1 = new Line(80, 120,  100, 120, "black");
        whisker2 = new Line(140, 120, 160, 120, "black");
        whisker3 = new Line(85, 130, 100, 125, "black");
        whisker4 = new Line(140, 125, 155, 130, "black");
        mouth1 = new Arc(110, 110, 20, 18, 180, 180, "green");
        mouth2 = new Arc(112, 110, 16, 15, 180, 180, "black");

        objects = List.of(whisker1, whisker2, whisker3, whisker4, face, ear1, ear2, mouth1, mouth2);

    }

    /* Construct a mouse object by Center, Radius and Color only */
    Mouse( int centerX, int centerY, int radius, String color)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;

        face = new Circle(  centerX-radius, centerY-radius,2*radius, color);
        ear1 = new Triangle( centerX, centerY, radius,centerX-radius,  centerY-(int)(1.5*radius),  radius/2, radius, color);
        ear2 = new Triangle( centerX, centerY, radius,centerX+radius,  centerY-(int)(1.5*radius),  radius/2, radius, color);
        whisker1 = new Line(centerX-2*radius, centerY,  centerX-radius, centerY, color);
        whisker2 = new Line(centerX+radius, centerY, centerX+2*radius, centerY, color);
        whisker3 = new Line(centerX-(int)(2.25*radius), centerY+(int)(0.5*radius), centerX-radius, centerY+(int)(0.25*radius), color);
        whisker4 = new Line(centerX+radius, centerY+(int)(0.25*radius), centerX+(int)(2.25*radius), centerY+(int)(0.5*radius), color);
        mouth1 = new Arc(centerX-(int)(0.5*radius), centerY-(int)(0.25*radius), radius, (int)(0.9*radius), 180, 180, "green");
        mouth2 = new Arc(centerX-(int)(0.4*radius), centerY-(int)(0.25*radius), (int)(0.8*radius), (int)(0.75*radius), 180, 180, "black");

        objects = List.of(whisker1, whisker2, whisker3, whisker4, face, ear1, ear2, mouth1, mouth2);

    }

    /* Draw the mouse on the screen */
    void drawMouse()
    {
        for (Object object : objects)
            object.draw();
    }

    /* Erase the mouse from the screen */
    void eraseMouse()
    {
        for (Object object : objects)
            object.erase();
    }

    String getColor()
    {
        return face.color;
    }

    /* Change color of mouse to newColor */
    void changeColor(String newColor)
    {
        for (Object object : objects)
            object.changeColor(newColor);
        drawMouse();
    }

    /* Move mouse by an amount (dx, dy) */
    void moveMouse(int deltaX, int deltaY)
    {
        eraseMouse();
        for (Object object : objects)
            object.move(deltaX, deltaY);
        drawMouse();
    }

    /* Move mouse n times by an amount (dx, dy) */
    void runMouse(int dx, int dy, int n)
    {
        for (int i = 1; i <= n; i = i + 1)
            moveMouse(dx, dy);
    }

    /* Move the mouse by direction, in degrees (0-360) */
    void moveMouseDirection(int direction, int distance)
    {
        int dx = (int) (distance * Math.cos(Math.toRadians(direction)));
        int dy = (int) (distance * Math.sin(Math.toRadians(direction)));
        moveMouse(dx, dy);
    }
    /* Inflate the mouse by a factor */
    void inflateMouse(double factor)
    {
        int refX = face.xPosition + face.diameter / 2;
        int refY = face.yPosition + face.diameter / 2;
        eraseMouse();
        for (Object object : objects)
            object.inflate(refX, refY, factor);
        drawMouse();
    }

    public void dispose()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.dispose();
    }

}
