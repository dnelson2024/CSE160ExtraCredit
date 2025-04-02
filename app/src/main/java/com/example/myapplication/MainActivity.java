package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public String topic;
    private Button introductions;
    private Button food;
    private Button travel;
    private Button hobbies;

    private Button writing;
    private Button learning;
    private Button multiplechoice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        food = findViewById(R.id.button);
        travel = findViewById(R.id.button3);
        introductions = findViewById(R.id.button2);
        hobbies = findViewById(R.id.button5);


        writing = findViewById(R.id.button9);
        learning = findViewById(R.id.button8);
        multiplechoice = findViewById(R.id.button7);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                topic = "Food";
                food.setVisibility(View.INVISIBLE);
                travel.setVisibility(View.INVISIBLE);
                introductions.setVisibility(View.INVISIBLE);
                hobbies.setVisibility(View.INVISIBLE);

                writing.setVisibility(View.VISIBLE);
                learning.setVisibility(View.VISIBLE);
                multiplechoice.setVisibility(View.VISIBLE);
            }
        });


        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                topic = "Travel";
                food.setVisibility(View.INVISIBLE);
                travel.setVisibility(View.INVISIBLE);
                introductions.setVisibility(View.INVISIBLE);
                hobbies.setVisibility(View.INVISIBLE);
                writing.setVisibility(View.VISIBLE);
                learning.setVisibility(View.VISIBLE);
                multiplechoice.setVisibility(View.VISIBLE);
            }
        });

        introductions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                topic = "Introductions";
                food.setVisibility(View.INVISIBLE);
                travel.setVisibility(View.INVISIBLE);
                introductions.setVisibility(View.INVISIBLE);
                hobbies.setVisibility(View.INVISIBLE);
                writing.setVisibility(View.VISIBLE);
                learning.setVisibility(View.VISIBLE);
                multiplechoice.setVisibility(View.VISIBLE);
            }
        });

        hobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                topic = "Hobbies";
                food.setVisibility(View.INVISIBLE);
                travel.setVisibility(View.INVISIBLE);
                introductions.setVisibility(View.INVISIBLE);
                hobbies.setVisibility(View.INVISIBLE);
                writing.setVisibility(View.VISIBLE);
                learning.setVisibility(View.VISIBLE);
                multiplechoice.setVisibility(View.VISIBLE);
            }
        });

        writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, WritingSectionActivity.class));
            }
        });

        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Learning.class));
            }
        });

        multiplechoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MultipleChoice.class));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}