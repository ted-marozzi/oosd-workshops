import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

class TimetableTest {

    private static Timetable simpleTimetable;
    private static Timetable regularTimetable;

    @BeforeAll
    static void setup() {
        simpleTimetable = new UnimelbTimetable();
        regularTimetable = new UnimelbTimetable();
        simpleTimetable.loadSubject("SWEN20003", getCSV("SWEN20003"));
        regularTimetable.loadSubject("SWEN20003", getCSV("SWEN20003"));
        regularTimetable.loadSubject("INFO20003", getCSV("INFO20003"));
        regularTimetable.loadSubject("COMP20007", getCSV("COMP20007"));
        regularTimetable.loadSubject("MAST20009", getCSV("MAST20009"));
        // Load timetables
        String[] simpleTimetableActivities = getCSV("simple-timetable");
        for (String activityCode : simpleTimetableActivities) {
            simpleTimetable.loadActivityFromCode(activityCode);
        }
        String[] regularTimetableActivities = getCSV("regular-timetable");
        for (String activityCode : regularTimetableActivities) {
            regularTimetable.loadActivityFromCode(activityCode);
        }
    }

    @Test
    void getDailyHourTotalsExcludingLectures() {
        double[] simpleTotals = simpleTimetable.getDailyHourTotalsExcludingLectures();
        double[] regularTotals = regularTimetable.getDailyHourTotalsExcludingLectures();
        Assertions.assertArrayEquals(simpleTotals, new double[]{0, 0, 0, 0, 2});
        Assertions.assertArrayEquals(regularTotals, new double[]{0, 1, 3, 0, 3});
    }

    @Test
    void getDailyHourTotals() {
        double[] simpleTotals = simpleTimetable.getDailyHourTotals();
        double[] regularTotals = regularTimetable.getDailyHourTotals();
        Assertions.assertArrayEquals(simpleTotals, new double[]{0, 1, 0, 0, 3});
        Assertions.assertArrayEquals(regularTotals, new double[]{0, 5, 3, 3, 5});
    }

    @Test
    void getDailyTimeAtUni() {
        double[] simpleTimeSpans = simpleTimetable.getDailyTimeAtUni();
        double[] regularTimeSpans = regularTimetable.getDailyTimeAtUni();
        Assertions.assertArrayEquals(simpleTimeSpans, new double[]{0.0, 1.0, 0.0, 0.0, 4.0});
        //Assertions.assertArrayEquals(regularTimeSpans, new double[]{0, 6.25, 5, 8.25, 5});
    }


    private static String[] getCSV(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            String path = String.format("res/%s.csv", fileName);
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] result = new String[lines.size()];
        lines.toArray(result);
        return result;
    }

}