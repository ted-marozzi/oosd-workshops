public final class Colour {

    public static final Colour WHITE = new Colour(255, 255, 255);
    public static final Colour BLACK = new Colour(0, 0, 0);
    public static final int R_INDEX = 0, G_INDEX = 1, B_INDEX = 2;
    private int[] rgb = new int[3];


    public Colour(int r, int g, int b) {
        this.rgb[R_INDEX]= r;
        this.rgb[G_INDEX]= g;
        this.rgb[B_INDEX]= b;
    }

    public int[] getRgb() {
        return rgb;
    }

    public int getR() {
        return rgb[R_INDEX];
    }

    public int getG() {
        return rgb[G_INDEX];
    }

    public int getB() {
        return rgb[B_INDEX];
    }


}
