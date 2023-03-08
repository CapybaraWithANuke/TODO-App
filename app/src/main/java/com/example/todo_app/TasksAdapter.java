package com.example.todo_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskHolder> {

    private ArrayList<Task> tasks;

    public static class TaskHolder extends RecyclerView.ViewHolder {

        private TextView taskName;
        private LocalDate taskDate;
        public TaskHolder(View view) {
            super(view);
        }

        public void setTaskDate(LocalDate localDate) {
            this.taskDate = localDate;
        }

        public void setTaskName(String name) {
            this.taskName.setText(name);
        }
    }

    public TasksAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TaskHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_task, viewGroup, false);

        return new TaskHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(TaskHolder TaskHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        TaskHolder.setTaskName(tasks.get(position).getName());
        TaskHolder.setTaskDate((tasks.get(position).getDate()));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return tasks.size();
    }
}

