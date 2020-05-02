// Rectangle is a Shape
public class Rectangle extends Shape {
    // Final variables
    private final double width, length;
    private final Colour colour;

    // Overloaded constructors, default colour black
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
        this.colour = Colour.BLACK;
    }
    // Constructor with explicit colour definition
    public Rectangle(double width, double length, Colour colour) {
        this.width = width;
        this.length = length;
        this.colour = colour;
    }


    // Overridden methods
    @Override
    public void render() {
        System.out.println("Drawing a Rectangle with colour:" + colour.printRGB() +
                " and area:" + String.format("%.2f", getArea()) + "px2");
    }

    @Override
    public double getArea() {
        return width*length;
    }

}