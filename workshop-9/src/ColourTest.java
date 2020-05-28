import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This testing class won't work until you create the fromRGB method in the Colour class as required
 * by the specification.
 */
class ColourTest {

    @Test
    public void restrictiveInstantiation() {
        Constructor<?>[] constructors = Colour.class.getDeclaredConstructors();
        Arrays.stream(constructors)
            .map(constructor -> Modifier.isPrivate(constructor.getModifiers()))
            .forEach(Assertions::assertTrue);
    }

    @Test
    public void fromRGB() {
        Colour white = Colour.fromRGB(255, 255, 255);
        Colour black = Colour.fromRGB(0, 0, 0);
        Colour green = Colour.fromRGB(0, 255, 0);
        Assertions.assertEquals(white, Colour.fromRGB(255, 255, 255));
        Assertions.assertEquals(black, Colour.fromRGB(0, 0, 0));
        Assertions.assertEquals(green, Colour.fromRGB(0, 255, 0));
    }

    private static final String INVALID_ARG_MESSAGE = "Invalid RGB values specified";

    @Test
    public void invalidArguments() {
        Throwable exceptionA = Assertions
            .assertThrows(IllegalArgumentException.class, () -> Colour.fromRGB(-1, 0, 0));
        Assertions.assertEquals(exceptionA.getMessage(), INVALID_ARG_MESSAGE);
        Throwable exceptionB = Assertions
            .assertThrows(IllegalArgumentException.class, () -> Colour.fromRGB(0, 0, 256));
        Assertions.assertEquals(exceptionB.getMessage(), INVALID_ARG_MESSAGE);
    }
}