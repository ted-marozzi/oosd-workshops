
public final class Colour {

    public static final Colour WHITE = new Colour(255, 255, 255);
    private static final int[] rgb = new int[3];


    public Colour(int r, int g, int b) {
        this.rgb[0]= r;
        this.rgb[1]= g;
        this.rgb[2]= b;
    }
}
