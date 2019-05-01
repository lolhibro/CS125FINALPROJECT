package com.example.cs125finalproject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task {
    public final int MIN_PRIORITYLVL = 1;
    public final int MAX_PRIORITYLVL = 5;

    public static int newInt;

    private String name;
    private int priorityLvl;
    private int completionHours;
    private LocalDate dueDate;
    private long dayDiff;
    private LocalDate currentDate;

    public Task(String setName, int setPriorityLvl, int setCompletionHours, LocalDate setDueDate) {
        setName(setName);
        setPriorityLvl(setPriorityLvl);
        setCompletionHours(setCompletionHours);
        setDueDate(setDueDate);
        setDayDiff();
        currentDate = LocalDate.now();
    }

    public void setName(String setName) {
        if (setName != null) {
            name = setName;
        }
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
    public LocalDate getCurrentDate() {
        if (currentDate != null) {
            return currentDate;
        }
        return null;
    }
    public void setDueDate(LocalDate setDueDate) {
        if (setDueDate != null) {
            dueDate = setDueDate;
        }
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDayDiff() {
        if (dueDate != null && currentDate != null) {
            dayDiff = ChronoUnit.DAYS.between(getCurrentDate(), getDueDate());
        }
    }
    public long getDayDiff() {
        return dayDiff;
    }
}
