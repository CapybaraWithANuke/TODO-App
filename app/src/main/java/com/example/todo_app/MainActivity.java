package com.example.todo_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks;
    RecyclerView tasksRecycler;
    TasksAdapter tasksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton createButton = findViewById(R.id.createButton);

        tasksRecycler = (RecyclerView) findViewById(R.id.recycler);
        tasksRecycler.setLayoutManager(new LinearLayoutManager(this));
        tasks = new ArrayList<>();

        tasksAdapter = new TasksAdapter(tasks);
        tasksRecycler.setAdapter(tasksAdapter);


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Creation.class);
                startActivityForResult(intent, 0);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        String newTaskName = data.getExtras().getString("name");
        String newTaskDate = data.getExtras().getString("date");
        Task task = new Task(newTaskName, newTaskDate);
        tasks.add(task);
        tasksAdapter.notifyItemInserted(tasks.size()-1);
    }

}