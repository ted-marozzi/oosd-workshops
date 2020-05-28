public final class Colour {

    private final int r;
    private final int g;
    private final int b;

    private static Colour rgb;

    private Colour(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static Colour fromRGB(int r, int g, int b) {
        if(r < 0 || g < 0 || b < 0 || r > 255 || g > 255 || b > 255)
        {
            throw new IllegalArgumentException("Invalid RGB value specified");
        }
        return rgb = new Colour(r,g,b);
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }


}
