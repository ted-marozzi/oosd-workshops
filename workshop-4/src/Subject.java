/* Subject class intended to exist within a Timetable
*/


public class Subject {
    private final String[] activityInformation;
    private String subjectCode;
    /* Constructor */
    public Subject(String subjectCode, String[] activityInformation) {
        this.subjectCode = subjectCode;
        this.activityInformation = activityInformation;
        
    }
    /* Main method, creates an activity and returns it */
    public Activity createActivity(String activityCode)
    {
        int i;
        Activity activity = null;


        for(i = 0; i < activityInformation.length; i++)
        {
            /* Takes the activity code and checks it against the activity codes in the subjects activity infomation */
            if(activityInformation[i].split(", ")[0].equals(activityCode))
            {
                /* Creates a new activity and returns it */
                activity = new Activity(activityInformation[i]);
                break;
            }
        }

        return activity;
    }

    /* Get methods */
    public String getSubjectCode() {
        return subjectCode;
    }

    public String[] getActivityInformation() {
        return activityInformation;
    }
}
