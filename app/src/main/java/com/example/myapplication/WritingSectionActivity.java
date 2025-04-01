package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

        text = (TextView) findViewById(R.id.textView4);
        textbox = (TextInputEditText) findViewById(R.id.TextBox);
        ansText = (TextView) findViewById(R.id.rightAns);
        questions = new String[] {"To the right","To the left","I need a"};
        answers = new String[] {"A la derecha", "A la izquierda", "Yo necesito un"};
        answers2 = new String[] {"A la derecha", "A la izquierda", "Necesito un"};
        text.setText("To the right");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clicked(View v){

        String question = "" + text.getText();
        int ansLength = 0;
        String key = "a la derecha";
        String ans = "";
        String ansNS = "";
        int count = 0;


        //Log.d("Success", "Text Changed");

//        ansLength = ansNs.length();

        if (checker <= 1) {
            ans = "" + textbox.getText();

            if (ans.length() == key.length()) {
                for (int i = 0; i < ans.length(); i++) {
                    if (ans.toLowerCase().charAt(i) == key.toLowerCase().charAt(i)) {
                        count += 1;
                        Log.d("Success", "" + count);
                    }
                }
                if(count == key.length()){
                    textbox.setTextColor(Color.rgb(0, 230, 0));
                    Button btn = (Button) findViewById(v.getId());
                    textbox.setEnabled(false);
                    ansText.setText("Correct Answer:\n" +answers);
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
            ansText.setText("Correct Answer:\n" +answers);
            ansText.setVisibility(View.VISIBLE);
            btn.setText("Next");

        }



}
}