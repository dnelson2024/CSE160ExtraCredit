package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class WritingSectionActivity extends AppCompatActivity {
    TextView text, ansText;
    TextInputEditText textbox;
    String[] questions;
    String[] answers, answers2;
    String key = "";
    String key2 = "";


    int checker = 0;

    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_writing_section);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }


    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_writing_section);


        TextView catTextView = findViewById(R.id.categoryTextView);
        String category = "Travel";
        if("Travel".equals(category)){
            catTextView.setText("Travel");
        }
        //introductory info
        else if("IntroInfo".equals(category)){
            catTextView.setText("Introductory Phrases");
        }
        //restuarant
        else if("Restaurant".equals(category)){
            catTextView.setText("Restaurant");
        }
        //hobbies and interests
        else if("HobbiesNInterests".equals(category)){
            catTextView.setText("Hobbies and Interests");
        }
        else if ("null".equals(category)){
            catTextView.setText("Error");
        }
        else {
            catTextView.setText("Error");
        }

        text = (TextView) findViewById(R.id.textView4);
        textbox = (TextInputEditText) findViewById(R.id.TextBox);
        ansText = (TextView) findViewById(R.id.rightAns);
        questions = new String[] {"To the right","To the left","I need a"};
        answers = new String[] {"A la derecha", "A la izquierda", "Yo necesito un"};
        answers2 = new String[] {"A la derecha", "A la izquierda", "Necesito un"};
        int rand = (int) Math.floor((Math.random()*4));
        text.setText(questions[rand]);

        ImageView imageView = findViewById(R.id.imageView1);
        if (questions[rand] == "I need a") {
            imageView.setImageResource(R.drawable.waterbottle);
        } else if (questions[rand] == "To the right"){
            imageView.setImageResource(R.drawable.right);
        } else if (questions[rand] == "To the left"){
            imageView.setImageResource(R.drawable.left);
        } else {
            imageView.setImageResource(R.drawable.books);
        }
        key = answers[rand];
        key2 = answers2[rand];


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clicked(View v){

        String question = "" + text.getText();
        int ansLength = 0;
        String ans = "";
        String ansNS = "";
        int count = 0;


        //Log.d("Success", "Text Changed");

//        ansLength = ansNs.length();

        if (checker <= 1) {
            ans = "" + textbox.getText();

            if (ans.length() == key.length()) {
                for (int i = 0; i < ans.length(); i++) {
                    if (ans.toLowerCase().charAt(i) == key.toLowerCase().charAt(i) || ans.toLowerCase().charAt(i) == key2.toLowerCase().charAt(i)) {
                        count += 1;
                        Log.d("Success", "" + count);
                    }
                }
                if(count == key.length()){
                    textbox.setTextColor(Color.rgb(0, 230, 0));
                    Button btn = (Button) findViewById(v.getId());
                    textbox.setEnabled(false);
                    ansText.setText("Correct Answer:\n" +key);
                    ansText.setVisibility(View.VISIBLE);
                    btn.setText("Next");
                }
                else{
                    textbox.setTextColor(Color.RED);
                }
            }
            else{
                textbox.setTextColor(Color.RED);
            }
            checker += 1;
        }
        if (checker == 2) {
            Button btn = (Button) findViewById(v.getId());
            textbox.setEnabled(false);
            ansText.setText("Correct Answer:\n" + key);
            ansText.setVisibility(View.VISIBLE);
            btn.setText("Next" );

        }



}
}