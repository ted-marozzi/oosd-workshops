import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.*;

public class TransitProcessorTest {

    @Test
    void testA() throws IOException {
        runTestFromName("A");
    }

    @Test
    void testB() throws IOException {
        runTestFromName("B");
    }

    private void runTestFromName(String name) throws IOException {
        // File paths
        String inPath = String.format("res/input%s.txt", name);
        String resultPath = String.format("res/output%s.txt", name);
        // Create log processor
        LogProcessor processor = new TransitProcessor(inPath);
        // Get log processor output
        String[] output = processor.processLogLines();
        //
        String[] expected = Files.readAllLines(Paths.get(resultPath)).toArray(new String[0]);
        Assertions.assertArrayEquals(expected, output);
    }
}
