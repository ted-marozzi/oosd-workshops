import java.io.IOException;

public class TransitProcessor extends LogProcessor {

    /**
     * Instantiates a new TransitProcessor.
     *
     * @param filePath The path to the transit log file
     * @throws IOException File reading error
     */
    public TransitProcessor(String filePath) throws IOException {
        super(filePath);
    }

    /**
     * Processes the transit log file.
     *
     * @return A re-ordered log sorted by: (1) Arrival time (2) Departure city (3) Destination city
     * in order, according to their natural ordering.
     */
    @Override
    public String[] processLogLines() {
        // Remember, you can access the lines of the log using the getter inherited from the superclass
        return null;
    }
}
