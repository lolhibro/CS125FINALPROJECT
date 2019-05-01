package com.example.cs125finalproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private ArrayList<ItemRecyclerView> inputItems;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView taskRecyclerView;
        public TextView hoursRecyclerView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            taskRecyclerView = itemView.findViewById(R.id.taskNameRecyclerView);
            hoursRecyclerView = itemView.findViewById(R.id.hoursRecyclerView);
        }
    }

    public ItemAdapter(ArrayList<ItemRecyclerView> privItems) {
        inputItems = privItems;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        ItemRecyclerView currentItem = inputItems.get(i);

        itemViewHolder.taskRecyclerView.setText(currentItem.getTask());
        itemViewHolder.hoursRecyclerView.setText(currentItem.getHours());
    }

    @Override
    public int getItemCount() {
        return inputItems.size();
    }
}
