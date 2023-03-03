package com.example.todo_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Creation extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);

        TextView name =(TextView) findViewById(R.id.nameInput);
        TextView date =(TextView) findViewById(R.id.dateInput);
        Button button = (Button) findViewById(R.id.saveButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Creation.this, MainActivity.class);



                startActivity(intent);

            }
        });


    }
}
