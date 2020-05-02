// Triangle is a shape
public class Triangle extends Shape {
    // Final so when class in initiated is immutable
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


    // Triangle render method
    @Override
    public void render() {
        System.out.println("Drawing a Triangle with colour:" + colour.printRGB() +
                " and area:" +  String.format("%.2f", getArea()) + "px2");
    }

    // Triangle area method
    @Override
    public double getArea() {
        return 0.5*base*height;
    }
}