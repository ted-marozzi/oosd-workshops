import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AvnacDesignCacheTest {

    @Test
    public void singleton() throws Exception {
        Constructor<?>[] constructors = AvnacDesignCache.class.getDeclaredConstructors();
        Arrays.stream(constructors)
            .map(constructor -> Modifier.isPrivate(constructor.getModifiers()))
            .forEach(b -> Assertions.assertTrue(b, "Invalid AvnacDesignCache constructor, does not follow the Singleton design pattern."));
        Method getInstance = AvnacDesignCache.class.getMethod("getInstance");
        Class<?> returnType = getInstance.getReturnType();
        Assertions.assertEquals(AvnacDesignCache.class, returnType,
            "Incorrect getInstance method return type, does not follow the Singleton design pattern.");
        int modifiers = getInstance.getModifiers();
        Assertions
            .assertTrue(Modifier.isStatic(modifiers), "Incorrect getInstance method modifiers, does not follow the Singleton design pattern..");
        Assertions
            .assertTrue(Modifier.isPublic(modifiers), "Incorrect getInstance method modifiers, does not follow the Singleton design pattern..");
        Assertions.assertEquals(getInstance.invoke(null), getInstance.invoke(null),
            "A singleton is supposed to return the same instance when getInstance() is called, does not follow the Singleton design pattern..");
    }
}