package com.example.todo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton createButton = findViewById(R.id.createButton);

        RecyclerView tasksRecycler = (RecyclerView) findViewById(R.id.recycler);
        tasksRecycler.setLayoutManager(new LinearLayoutManager(this));
        TasksAdapter tasksAdapter = new TasksAdapter(tasks);
        tasksRecycler.setAdapter(tasksAdapter);


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Creation.class);
                startActivity(intent);
                try {
                    intent.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String newTaskName = getIntent().getExtras().getString("name");
                String newTaskDate = getIntent().getExtras().getString("date");
                Task task = new Task(newTaskName, LocalDate.parse(newTaskDate));
                tasks.add(task);
                System.out.println("\n\n\n\n\n\n\n\n" + task.getName());
            }
        });

    }

}