import java.util.Arrays;

/**
 * Represents a timetable for a student at The University of Melbourne
 */
public class UnimelbTimetable implements Timetable {

    /* Constants */
    private static final int MAX_SUBJECTS = 4;
    private static final int MAX_TIMETABLE_ACTIVITIES = 20;
    private Subject[] subjects = new Subject[MAX_SUBJECTS];
    private Activity[] activities = new Activity[MAX_TIMETABLE_ACTIVITIES];
    private int numActivities = 0;
    private int numSubjects = 0;
    private static final double LATEST_FINISH = 24.0;



    /**
     * Creates a new UnimelbTimetable. A Timetable is comprised of a number of Subjects and a number
     * of Activities.
     */
    public UnimelbTimetable() {
        /* (Optional) Fill in this constructor */

    }

    /**
     * Loads a subject into the timetable.
     *
     * @param subjectCode The subject code (e.g. SWEN20003)
     * @param activityInformation An array of activity information for a subject.  Each element in the array
     *                    is a String of the format: activity code, activity name, day, start,
     *                    finish
     */
    public void loadSubject(String subjectCode, String[] activityInformation) {
        /* Fill in this method */
        subjects[numSubjects++] = new Subject(subjectCode, activityInformation);

    }

    /**
     * Loads an activity into the timetable.
     *
     * @param activityCode The activity code (e.g. SWEN20003/U/1/SM1/L02/1).
     */
    public void loadActivityFromCode(String activityCode) {
        /* Fill in this method */
        String subjectCode = activityCode.split("/")[0];

        int i;

        for(i=0;i<numSubjects;i++)
        {
            if(subjects[i].getSubjectCode().equals(subjectCode))
            {
                activities[numActivities++] = subjects[i].createActivity(activityCode);
            }
        }

    }

    /**
     * Calculate the number of hours spent each day on non-lecture activities.
     *
     * @return An array of doubles, element at index i represent the number of hours spent on
     * non-lecture activities on day index i.
     */
    public double[] getDailyHourTotalsExcludingLectures() {
        /* Fill in this method */
        int i;
        //TODO: make this a constant num days
        double[] dailyHoursNoLec = new double[5];

        for(i = 0; i < numActivities; i++ )
        {

            if(!(activities[i].getActivityName().split(" ")[0].equals("Lecture")))
            {
                dailyHoursNoLec[activities[i].getDay()] +=  activities[i].getFinish()-activities[i].getStart();
            }

        }

        return dailyHoursNoLec;
    }

    /**
     * Calculate the number of hours spent each day on activities.
     *
     * @return An array of doubles, element at index i represent the number of hours spent on
     * activities on day index i.
     */
    public double[] getDailyHourTotals() {
        /* Fill in this method */
        int i;
        double[] dailyHours = new double[5];

        for(i = 0; i < numActivities; i++ )
        {
            dailyHours[activities[i].getDay()] += activities[i].getFinish()-activities[i].getStart();
        }

        return dailyHours;

    }

    /**
     * Calculate the number of hours spent at university each day.
     *
     * @return An array of doubles, element at index i is the total time that would be spent at uni
     * for day index i.
     */
    public double[] getDailyTimeAtUni() {
        /* Fill in this method */
        int i;
        double[] dailyTime = new double[5];
        double[] earliestStart = new double[5];
        double[] latestFinish = new double[5];

        Arrays.fill(earliestStart, LATEST_FINISH);


        for(i = 0; i < numActivities; i++ )
        {

            earliestStart[activities[i].getDay()] = Math.min(earliestStart[activities[i].getDay()], activities[i].getStart());
            latestFinish[activities[i].getDay()] = Math.max(latestFinish[activities[i].getDay()], activities[i].getFinish());

        }

        for(i = 0; i < 5; i++ )
        {

            dailyTime[i] = latestFinish[i] - earliestStart[i];
            if(earliestStart[i] == LATEST_FINISH)
            {
                dailyTime[i] = 0;
            }
        }


        return dailyTime;
    }

    /* Make your life easier by creating other methods and classes! */
}
