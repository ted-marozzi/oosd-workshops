import java.util.ArrayList;
import java.util.Objects;

public final class Colour {

    private final int r;
    private final int g;
    private final int b;

    private static final ArrayList<Colour> rgbList = new ArrayList<>();

    private Colour(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static Colour fromRGB(int r, int g, int b) {
        if(r < 0 || g < 0 || b < 0 || r > 255 || g > 255 || b > 255)
        {
            throw new IllegalArgumentException("Invalid RGB values specified");
        }

        Colour color = new Colour(r,g,b);

        for(Colour tmp: rgbList)
        {
            if(tmp.equals(color))
            {
                return tmp;
            }
        }
        rgbList.add(color);
        return color;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour = (Colour) o;
        return r == colour.r &&
                g == colour.g &&
                b == colour.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b);
    }
}
