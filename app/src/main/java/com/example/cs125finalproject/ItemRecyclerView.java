package com.example.cs125finalproject;

public class ItemRecyclerView {
    private String taskRecyclerView;
    private String hoursRecyclerView;

    public ItemRecyclerView(String inputTask, String inputHours) {
        taskRecyclerView = inputTask;
        hoursRecyclerView = inputHours;
    }

    public String getTask() {
        return taskRecyclerView;
    }

    public String getHours() {
        return hoursRecyclerView;
    }
}
