// Colour class to hold rgb values
public final class Colour {
    // Static variables
    // White colour
    public static final Colour WHITE = new Colour(255, 255, 255);
    // Black colour
    public static final Colour BLACK = new Colour(0, 0, 0);
    // Indexes in rgb array
    public static final int R_INDEX = 0, G_INDEX = 1, B_INDEX = 2;
    // rgb array
    private final int[] rgb = new int[3];

    // TODO: Implement range checks 0,255 inclusive

    // Constructor
    public Colour(int r, int g, int b) {
        this.rgb[R_INDEX]= r;
        this.rgb[G_INDEX]= g;
        this.rgb[B_INDEX]= b;
    }

    // Returns an array with the rgb values
    public int[] getRgb() {
        return rgb;
    }

    // Returns ints of r, g and b
    public int getR() {
        return rgb[R_INDEX];
    }

    public int getG() {
        return rgb[G_INDEX];
    }

    public int getB() {
        return rgb[B_INDEX];
    }

    // Returns "(r, g, b)" as a string to be printed
    public String printRGB()
    {
        return "(" + rgb[R_INDEX] + ", " + rgb[G_INDEX] + ", " + rgb[B_INDEX] + ")";
    }



}
