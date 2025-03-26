package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Learning extends AppCompatActivity {
    //Boolean buttonPressed = false;

    String category = "category2";

    String[] category1Info = {"¿Dónde puedo encontrar un taxi? \n How can I find a taxi?", "¿Cuánto cuesta? \n How much is this?", "¿Dónde está este lugar? \n Where is this place?", "A la derecha \n to the right"};
    String[] category2Info = {"Me llamo... \n My name is...", "Soy de... \n I am from...", "¿Como estás? \n How are you?", "¿Puedo ir al baño? \n Can I use the bathroom?"};
    String[] category3Info = {"¿Qué me recomienda? \n What do you recommend?", "¿Tienen algún plato vegetariano?\n Do you have a vegetarian option?", "Con salsa \n With sauce", "Quiero pedir... \n I would like to order..."};
    String[] category4Info = {"¿Tienes algún pasatiempo?\n Do you have any hobbies?", "Me gusta... \n I like...", "Yo disfruto.. \n I enjoy", "Me encanta... \n I love"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_learning);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView catTextView = findViewById(R.id.categorytextView);
        //travel
        if("category1".equals(category)){
            catTextView.setText("Category 1");
        }
        //introductory info
        else if("category2".equals(category)){
            catTextView.setText("Category 2");
        }
        //restuarant
        else if("category3".equals(category)){
            catTextView.setText("Category 3");
        }
        //hobbies and interests
        else if("category4".equals(category)){
            catTextView.setText("Category 4");
        }
        else if ("null".equals(category)){
            catTextView.setText("Error");
        }
        else {
            catTextView.setText("Error");
        }



    }

    int i = 0;
    public void showInfo(View view) {
        //view.setEnabled(false);
        TextView textView = findViewById(R.id.informationTextView);

        if (i < 4) {
            if ("category1".equals(category)) {
                textView.setText(category1Info[i]);
            } else if ("category2".equals(category)) {
                textView.setText(category2Info[i]);
            } else if ("category3".equals(category)) {
                textView.setText(category3Info[i]);
            } else if ("category4".equals(category)) {
                textView.setText(category4Info[i]);
            }
        }
        if (i == 3){
            i = 0;
        }
        i += 1;


    }

        /*
        for (int i = 0; i < 4; i++){
            if("category1".equals(category)) {
                textView.setText(category1Info[i]);
            } else if ("category2".equals(category)) {
                textView.setText(category2Info[i]);
            } else if ("category3".equals(category)) {
                textView.setText(category3Info[i]);
            } else if ("category4".equals(category)) {
                textView.setText(category4Info[i]);
            }
        }*/




}