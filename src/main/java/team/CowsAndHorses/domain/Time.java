package  team.CowsAndHorses.domain;

import lombok.Builder;
import lombok.Data;

@Data

public class Time {
    private  int id;
    private  int year;
    private  int month;
    private int day;
    private  int hour;
    private String minute;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time() {
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute='" + minute + '\'' +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
