import java.util.Arrays;

/**
 * Represents a timetable for a student at The University of Melbourne
 */
public class UnimelbTimetable implements Timetable {

    /* Constants */
    private static final int MAX_SUBJECTS = 4;
    private static final int MAX_TIMETABLE_ACTIVITIES = 20;
    private static final int NUM_DAYS = 5;
    private static final int NULL_TIME = 0;
    private static final double LATEST_FINISH = 24.0;
    /* Arrays of classes: Subjects, Activities */
    private Subject[] subjects = new Subject[MAX_SUBJECTS];
    private Activity[] activities = new Activity[MAX_TIMETABLE_ACTIVITIES];
    /* Keeps track of the number of subjects and activities loaded. */
    private int numActivities = 0;
    private int numSubjects = 0;


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
        /* Constructs a new subject for every subjected loaded and adds it to subjects array */
        subjects[numSubjects++] = new Subject(subjectCode, activityInformation);
    }

    /**
     * Loads an activity into the timetable.
     *
     * @param activityCode The activity code (e.g. SWEN20003/U/1/SM1/L02/1).
     */
    public void loadActivityFromCode(String activityCode) {
        /* Extracts the subject code */
        String subjectCode = activityCode.split("/")[0];

        int i;
        /* Match the subject code to the subject */
        for(i=0;i<numSubjects;i++)
        {
            if(subjects[i].getSubjectCode().equals(subjectCode))
            {
                /* When a match is found create an activity under that subject, also add it to activities array */
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

        int i;
        /* Array of doubles */
        double[] dailyHoursNoLec = new double[NUM_DAYS];
        /* Adds to daily lecture time for that day provided class isn't a lecture */
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

        int i;
        double[] dailyHours = new double[NUM_DAYS];
        /* Adds to daily hours for each activity */
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

        int i;
        double[] dailyTime = new double[NUM_DAYS];
        double[] earliestStart = new double[NUM_DAYS];
        double[] latestFinish = new double[NUM_DAYS];

        Arrays.fill(earliestStart, LATEST_FINISH);

        /* Finds the earliest start and latest finish for each day */
        for(i = 0; i < numActivities; i++ )
        {
            int day = activities[i].getDay();
            earliestStart[day] = Math.min(earliestStart[day], activities[i].getStart());
            latestFinish[day] = Math.max(latestFinish[day], activities[i].getFinish());

        }
        /* Subtracts those numbers, More efficient to do outside the loop i believe. */
        for(i = 0; i < NUM_DAYS; i++ )
        {
            dailyTime[i] = latestFinish[i] - earliestStart[i];
            /* Edge case where no activities on a day */
            if(earliestStart[i] == LATEST_FINISH)
            {
                dailyTime[i] = NULL_TIME;
            }
        }

        return dailyTime;
    }

    /*
    * QUESTION: I contemplated using a day class considering the
    * questions regard daily activities. Do you think this could also work, or is that not preferred?
    */
}
