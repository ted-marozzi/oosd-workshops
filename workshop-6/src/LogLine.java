public class LogLine implements Comparable<LogLine>
{

    private String arrCity = null;
    private String depCity = null;
    private int arrTime = 0;
    private int userID;

    public LogLine(String logLine)
    {
        String[] logLine1 = logLine.split(":");
        userID = Integer.parseInt(logLine1[0]);
        depCity = logLine1[1];
        arrCity = logLine1[2];
        arrTime = Integer.parseInt(logLine1[3]);
    }


    @Override
    public int compareTo(LogLine logLine) {
        if(this.arrTime == logLine.arrTime)
        {
            if(this.depCity.compareTo(logLine.depCity) == 0)
            {
                return this.arrCity.compareTo(logLine.arrCity);

            }
            else
                return this.depCity.compareTo(logLine.depCity);
        }
        else
            return Integer.compare(this.arrTime , logLine.arrTime);
    }

    public String buildLogline()
    {
        StringBuilder logLine = new StringBuilder();
        logLine.append(userID).append(":").append(depCity).append(":").append(arrCity).append(":").append(arrTime);
        return logLine.toString();
    }

}
