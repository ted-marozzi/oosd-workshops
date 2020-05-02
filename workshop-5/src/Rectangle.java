public class Rectangle extends Shape {
    private final double width, length;

    public Rectangle() {
        this(1,1);
    }
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }


    @Override
    public void render() {

    }

    @Override
    public double getArea() {
        return width*length;
    }

}