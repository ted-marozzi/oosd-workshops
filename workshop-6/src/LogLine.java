public class LogLine implements Comparable<LogLine>
{

    private String desCity = null;
    private String depCity = null;
    private int arrTime = 0;
    private int userID;
    private String logLine;
    private String[] logLineArr;

    public LogLine(String logLine)
    {
        this.logLine = logLine;
        this.logLineArr = logLine.split(":");
        userID = Integer.parseInt(logLineArr[0]);
        depCity = logLineArr[1];
        desCity = logLineArr[2];
        arrTime = Integer.parseInt(logLineArr[3]);
    }


    @Override
    public int compareTo(LogLine logLine) {
        if(this.arrTime == logLine.arrTime)
        {
            if(this.depCity.compareTo(logLine.depCity) == 0)
            {
                return this.desCity.compareTo(logLine.desCity);

            }
            else
                return this.depCity.compareTo(logLine.depCity);
        }
        else
            return Integer.compare(this.arrTime , logLine.arrTime);
    }


    public String getLogLine() {
        return logLine;
    }
}
