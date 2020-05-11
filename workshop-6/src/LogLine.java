public class LogLine implements Comparable<LogLine>
{

    private String desCity;
    private String depCity;
    private int arrTime;
    private String logLine;

    public LogLine(String logLine)
    {
        this.logLine = logLine;
        String[] logLineArr = logLine.split(":");
        depCity = logLineArr[1];
        desCity = logLineArr[2];
        arrTime = Integer.parseInt(logLineArr[3]);
    }

    @Override
    public int compareTo(LogLine logLine) {
        if(this.arrTime == logLine.arrTime)
        {
            if(this.depCity.compareTo(logLine.depCity) == 0)
                return this.desCity.compareTo(logLine.desCity);
            return this.depCity.compareTo(logLine.depCity);
        }
        return Integer.compare(this.arrTime , logLine.arrTime);
    }

    public String getLogLine() {
        return logLine;
    }
}
