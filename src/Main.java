import exercise1.DailyPlanner;
import exercise1.DaySchedule;
import exercise1.DaysOfTheWeek;
import exercise1.NoActivityDayException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoActivityDayException {
        DaySchedule joi = new DaySchedule(DaysOfTheWeek.JOI);
        DaySchedule luni = new DaySchedule(DaysOfTheWeek.LUNI);
        joi.addActivity("sala");
        joi.addActivity("cumparaturi");
        luni.addActivity("shopping");
        luni.addActivity("fotbal");
        List<DaySchedule> activitatiDeJoi = new ArrayList<>();
        activitatiDeJoi.add(joi);
        DailyPlanner planner = new DailyPlanner(activitatiDeJoi);
        System.out.println(planner.getActivities(DaysOfTheWeek.JOI));
        planner.addActivity(DaysOfTheWeek.JOI, "alergat");
        planner.addActivity(DaysOfTheWeek.JOI, "plimbat");
        System.out.println(planner.getActivities(DaysOfTheWeek.JOI));
        planner.removeActivity(DaysOfTheWeek.JOI, "plimbat");
        System.out.println(planner.getActivities(DaysOfTheWeek.JOI));
        System.out.println(planner.endPlanning());


    }
}