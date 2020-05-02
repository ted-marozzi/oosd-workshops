public class Triangle extends Shape {
    private final double base, height;
    private final Colour colour;

    // Constructor with default colour
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
        this.colour = Colour.BLACK;
    }

    // Constructor with Colour passed
    public Triangle(double base, double height, Colour colour) {
        this.base = base;
        this.height = height;
        this.colour = colour;
    }


    @Override
    public void render() {

    }

    @Override
    public double getArea() {
        return 0;
    }
}