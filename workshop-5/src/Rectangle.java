public class Rectangle extends Shape {
    private final double width, length;
    private final Colour colour;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
        this.colour = Colour.BLACK;
    }

    public Rectangle(double width, double length, Colour colour) {
        this.width = width;
        this.length = length;
        this.colour = colour;

    }


    @Override
    public void render() {

    }

    @Override
    public double getArea() {
        return width*length;
    }

}