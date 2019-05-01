package com.example.cs125finalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TaskOrganizer {
    private ArrayList<Task> allTasks = new ArrayList<>();
    private LocalDate finalDueDate;
    private LocalDate current;
    private ArrayList<LocalDate> daysList = new ArrayList<>();
    private HashMap<LocalDate, ArrayList<Task>> completeMap = new HashMap<>();

    public TaskOrganizer() {
        current = LocalDate.now();
        setFinalDueDate();
    }
    public TaskOrganizer(Task task) {
        setAllTasks(task);
    }
    public void setAllTasks(Task task) {
        if (task != null) {
            allTasks.add(task);
        }
    }
    public ArrayList<Task> getAllTasks() {
        return allTasks;
    }
    public void setFinalDueDate() {
        if (allTasks != null) {
            LocalDate toReturn = allTasks.get(0).getDueDate();
            for (Task task : allTasks) {
                if (task.getDueDate().compareTo(toReturn) > 0) {
                    toReturn = task.getDueDate();
                }
            }
            finalDueDate = toReturn;
        }
    }
    public LocalDate getFinalDueDate() {
        return finalDueDate;
    }
    public ArrayList<Task> setDailyTask(LocalDate date) {
        ArrayList<Task> toReturn = new ArrayList<>();
        for (Task task: allTasks) {
            if (task.getCurrentDate().compareTo(date) <= 0 && task.getDueDate().compareTo(date) >= 0) {
                toReturn.add(task);
            }
        }
        return toReturn;
    }

    /*Set up the HashMap with the date key and daily list value (using each date until the final
    due date, as the argument for the setDailyTask function.
     */
    public void setCompleteMap() {
        for (LocalDate start = current; start.compareTo(getFinalDueDate()) <= 0; start.plusDays(1)) {
            completeMap.put(start, setDailyTask(start));
        }
    }
    public HashMap<LocalDate, ArrayList<Task>> getCompleteMap() {
        return completeMap;
    }
}