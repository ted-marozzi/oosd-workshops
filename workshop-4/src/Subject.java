public class Subject {
    private final String[] activityInformation;
    private String subjectCode;
    private Activity[] activities;
    private int numActivities = 0;

    public Subject(String subjectCode, String[] activityInformation) {
        this.subjectCode = subjectCode;
        this.activityInformation = activityInformation;
        // Array of all activities in the subject
        activities = new Activity[activityInformation.length];
    }

    public Activity createActivity(String activityCode)
    {
        int i;


        for(i = 0; i < activityInformation.length; i++)
        {

            if(activityInformation[i].split(", ")[0].equals(activityCode))
            {

                activities[numActivities++] = new Activity(activityInformation[i]);
                break;
            }
        }

        return activities[numActivities-1];

    }

    public Activity[] getActivities() {
        return activities;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String[] getActivityInformation() {
        return activityInformation;
    }
}
