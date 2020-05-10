import java.io.IOException;
import java.util.Arrays;


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
        int i = 0;
        LogLine[] sortedLog = new LogLine[getLines().length];
        String[] sortedLogString = new String[getLines().length];
        for(String line:getLines())
        {
            sortedLog[i] = new LogLine(line);
            i++;
        }

        Arrays.sort(sortedLog);
        i = 0;

        for(LogLine line:sortedLog)
        {
            sortedLogString[i] = line.getLogLine();
            i++;
        }

        return sortedLogString;
    }
}
