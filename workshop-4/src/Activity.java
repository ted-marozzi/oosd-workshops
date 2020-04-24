public class Activity {
    private String activityInfoString;
    private String activityCode;
    private String activityName;
    private int day;
    private double start;
    private double finish;
    private String[] stringArr;
    /* Constructor to parse attributes */
    public Activity(String activityInfoString)
    {
        int i = 0;
        this.activityInfoString = activityInfoString;
        stringArr = activityInfoString.split(", ");

        activityCode = stringArr[i++];
        activityName = stringArr[i++];
        day = Integer.parseInt(stringArr[i++]);
        start = Double.parseDouble(stringArr[i++]);
        finish = Double.parseDouble(stringArr[i++]);
    }

    /* Get methods 88*/
    public String getActivityCode() {
        return activityCode;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getDay() {
        return day;
    }

    public double getStart() {
        return start;
    }

    public double getFinish() {
        return finish;
    }
}
