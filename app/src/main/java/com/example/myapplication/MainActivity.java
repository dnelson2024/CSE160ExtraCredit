package com.example.myapplication;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        food = findViewById(R.id.button);
        travel = findViewById(R.id.button3);
        introductions = findViewById(R.id.button2);
        hobbies = findViewById(R.id.button5);


        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                topic = "Food";
                food.setVisibility(View.INVISIBLE);
                travel.setVisibility(View.INVISIBLE);
                introductions.setVisibility(View.INVISIBLE);
                hobbies.setVisibility(View.INVISIBLE);
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
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}