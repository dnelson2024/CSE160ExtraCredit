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
    TextView text;
    TextInputEditText textbox;
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
        String questions = "To the right";
        String answers = "a la derecha";
        text.setText("To the right");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clicked(View v){
//        Button btn = (Button) findViewById(v.getId());
//
//        String randString = "" + (int)((Math.random()*10)+2);
//        btn.setText(randString);
        String question = "" + text.getText();
        int ansLength = 0;
        String key = "a la derecha";
        String ans = "";
        String ansNS = "";
        int count = 0;

        Log.d("Success", "Text Changed");
        ans = "" + textbox.getText();
        ansNS = ans.replace(" ", "");
//        ansLength = ansNs.length();

        if (ans.length() == key.length()) {
            for (int i = 0; i < ans.length(); i++) {
                if (ans.toLowerCase().charAt(i) == key.toLowerCase().charAt(i)) {
                    count += 1;
                    Log.d("Success", "" + count);
                }
            }
            if(count == key.length()){
                textbox.setTextColor(Color.rgb(0, 230, 0));
            }
            else{
                textbox.setTextColor(Color.RED);
            }

        }

        else{
            textbox.setTextColor(Color.RED);
        }



}
}