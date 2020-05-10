import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class LogProcessor {

    // Stores the lines of the log
    private final String[] lines;

    /**
     * Instantiates a new LogProcessor
     *
     * @param filePath The file path to the log
     * @throws IOException Log reading exception
     */
    public LogProcessor(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        this.lines = lines.toArray(new String[0]);
    }

    /**
     * Performs processing on the log lines
     *
     * @return Processed log lines
     */
    public abstract String[] processLogLines();


    public String[] getLines() {
        return lines;
    }
}
