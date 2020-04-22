public interface Timetable {

    void loadSubject(String subjectCode, String[] activityInformation);

    void loadActivityFromCode(String activityCode);

    double[] getDailyHourTotalsExcludingLectures();

    double[] getDailyHourTotals();

    double[] getDailyTimeAtUni();
}
