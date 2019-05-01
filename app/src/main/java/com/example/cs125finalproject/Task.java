package com.example.cs125finalproject;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task {
    public final int MIN_PRIORITYLVL = 1;
    public final int MAX_PRIORITYLVL = 5;

    public static int newInt;

    private String name;
    private int priorityLvl;
    private int completionHours;
    private Date dueDate;
    Date currentDate = new Date();
    long dayDiff = TimeUnit.DAYS.convert((dueDate.getTime() - currentDate.getTime()), TimeUnit.MILLISECONDS);

    public void setName(String setName) {
        name = setName;
    }
    public String getName() {
        return name;
    }
    public void setPriorityLvl(int setPriorityLvl) {
        if (priorityLvl >= MIN_PRIORITYLVL && priorityLvl <= MAX_PRIORITYLVL) {
            priorityLvl = setPriorityLvl;
        }
    }
    public int getPriorityLvl() {
        return priorityLvl;
    }
    public void setCompletionHours(int setCompletionHours) {
        completionHours = setCompletionHours;
    }
    public int getCompletionHours() {
        return completionHours;
    }
    public void setDueDate(Date setDueDate) {
        dueDate = setDueDate;
    }
    public Date getDueDate() {
        return dueDate;
    }

    public long getDayDiff() {
        return dayDiff;
    }
}
