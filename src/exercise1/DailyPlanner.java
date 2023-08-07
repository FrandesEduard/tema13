package exercise1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private List<DaySchedule> daySchedules;

    public DailyPlanner(List<DaySchedule> daySchedules) {
        this.daySchedules = daySchedules;
    }

    public void addActivity(DaysOfTheWeek day, String activity) {
        if (activity == null) {
            throw new NoActivityException("Activity cant be null");
        }
        DaySchedule schedule = getOrCreateDaySchedule(day);
        schedule.addActivity(activity);
    }

    public void removeActivity(DaysOfTheWeek day, String activity) {
        DaySchedule schedule = findDaySchedule(day);
        if (schedule == null) {
            throw new NoActivityException("Day schedule does not exist.");
        }
        schedule.removeActivity(activity);
    }

    public List<String> getActivities(DaysOfTheWeek day) {
        DaySchedule schedule = findDaySchedule(day);
        if (schedule != null) {
            return schedule.getActivities();
        }
        return new ArrayList<>();
    }

    public Map<DaysOfTheWeek, List<String>> endPlanning() throws NoActivityDayException {
        Map<DaysOfTheWeek, List<String>> resultMap = new HashMap<>();
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getActivities().isEmpty()) {
                throw new NoActivityDayException("There are days without activities.");
            }
            resultMap.put(schedule.getDay(), schedule.getActivities());
        }
        return resultMap;
    }

    private DaySchedule findDaySchedule(DaysOfTheWeek day) {
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getDay() == day) {
                return schedule;
            }
        }
        return null;
    }

    private DaySchedule getOrCreateDaySchedule(DaysOfTheWeek day) {
        DaySchedule schedule = findDaySchedule(day);
        if (schedule == null) {
            schedule = new DaySchedule(day);
            daySchedules.add(schedule);
        }
        return schedule;
    }
}
