
public class Main {
    public static void main(String[] args) throws Exception {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        int centerX = 100;
        int centerY = 100;
        int radius = 40;

        String color = "magenta";
        int input;

        Mouse m1 = new Mouse(centerX, centerY, radius, color);

        System.out.printf("Press Enter to turn the mouse red\n");
        input = System.in.read();
        m1.changeColor("red");
        m1.mouth1.changeColor("black");
        m1.mouth2.changeColor(m1.getColor());

        System.out.printf("Press Enter to change the ear colors\n");
        input = System.in.read();
        m1.ear1.changeColor("blue");
        m1.ear2.changeColor("green");

        System.out.printf("Press Enter to change the ear sizes\n");
        input = System.in.read();
        m1.ear1.changeSize(0.5);
        m1.ear2.changeSize(2.0);

        System.out.printf("Press Enter to move the mouse\n");
        input = System.in.read();
        m1.moveMouseDirection(30, 80);

        System.out.printf("Press Enter to inflate the mouse by 1.5\n");
        input = System.in.read();
        m1.inflateMouse(1.5);

        System.out.printf("Press Enter to make the mouse run a bit\n");
        input = System.in.read();
        m1.runMouse(30, 20, 4);

        System.out.printf("Press Enter to close the canvas window\n");
        input = System.in.read();

        m1.dispose();
        /*
        Canvas canvas = Canvas.getCanvas();
        canvas.dispose();
        */
    }
}