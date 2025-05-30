package com.example.myapplication;

import static androidx.databinding.DataBindingUtil.setContentView;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.databinding.FragmentWsQuestionsBinding;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link wsQuestions#} factory method to
 * create an instance of this fragment.
 *
 */
public class wsQuestions extends Fragment {

    private TextView text, ansText;
    private TextInputEditText textbox;
    private String[] questions;
    private String[] answers, answers2;
    private String key = "";
    private String key2 = "";
    private WritingSectionActivity wsActivity;

    private MediaPlayer right_Sound;
    private MediaPlayer wrong_Sound;
    private FragmentWsQuestionsBinding binding;



    int checker = 0;
    //int questionNum = 0;
    public wsQuestions(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWsQuestionsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        wsActivity = (WritingSectionActivity) getActivity();

        right_Sound = MediaPlayer.create(requireContext(), R.raw.correct_s1);
        wrong_Sound = MediaPlayer.create(requireContext(), R.raw.wrong_s1);


        text = (TextView) binding.textView4;
        textbox = (TextInputEditText) binding.TextBox;
        ansText = (TextView) binding.rightAns;
        questions = new String[] {"To the right","To the left","I need a"};
        answers = new String[] {"A la derecha", "A la izquierda", "Yo necesito un"};
        answers2 = new String[] {"A la derecha", "A la izquierda", "Necesito un"};
        int rand = (int) Math.floor((Math.random()*3));
        text.setText(questions[rand]);

        ImageView imageView = binding.imageView1;
        if (questions[rand].equals("I need a")) {
            imageView.setImageResource(R.drawable.waterbottle);
        } else if (questions[rand].equals("To the right")){
            imageView.setImageResource(R.drawable.right);
        } else if (questions[rand].equals("To the left")){
            imageView.setImageResource(R.drawable.left);
        } else {
            imageView.setImageResource(R.drawable.books);
        }
        key = answers[rand];
        key2 = answers2[rand];

        Button button = binding.button6;
        button.setOnClickListener(v -> {
            clicked(view);
        });

        return view;
    }

    public void clicked(View v){

        String question = "" + text.getText();
        int ansLength = 0;
        String ans = "";
        String ansNS = "";
        int count = 0;
        // Initial volume setting (e.g., full volume)
//        mediaPlayer.setVolume(1.0f, 1.0f); // Default to full volume of the MediaPlayer
//        mediaPlayer.start();


        //Log.d("Success", "Text Changed");
        Button btn = (Button) binding.button6;
//        ansLength = ansNs.length();
        if(btn.getText().equals("Check!")){
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
                        textbox.setTextColor(Color.rgb(0, 200, 0));
                        right_Sound.setVolume(1.0f, 1.0f); // Default to full volume of the MediaPlayer
                        right_Sound.start();
                        textbox.setEnabled(false);
                        wsActivity.score += 50;
                        ansText.setText("Correct Answer:\n" +key);
                        ansText.setVisibility(View.VISIBLE);
                        btn.setText("Next");
                    }
                    else{
                        textbox.setTextColor(Color.RED);
                        wrong_Sound.setVolume(1.0f, 1.0f); // Default to full volume of the MediaPlayer
                        wrong_Sound.start();
                    }
                }
                else{
                    textbox.setTextColor(Color.RED);
                    wrong_Sound.setVolume(1.0f, 1.0f); // Default to full volume of the MediaPlayer
                    wrong_Sound.start();
                }
                checker += 1;
            }
            if (checker == 2) {
                //Button btn = (Button) findViewById(v.getId());
                textbox.setEnabled(false);
                ansText.setText("Correct Answer:\n" + key);
                ansText.setVisibility(View.VISIBLE);
                btn.setText("Next");
            }
        }
        else if(btn.getText().equals("Next") && wsActivity.questionNum < 4 && !(btn.getText().equals("Check!"))){
//            int rand = (int) Math.floor((Math.random()*3));
//            text.setText(questions[rand]);
//            Log.i("worked", "clicked: ");
//            ImageView imageView = binding.imageView1;
//
//            if (questions[rand].equals("I need a")) {
//                imageView.setImageResource(R.drawable.waterbottle);
//            } else if (questions[rand].equals("To the right")){
//                imageView.setImageResource(R.drawable.right);
//            } else if (questions[rand].equals("To the left")){
//                imageView.setImageResource(R.drawable.left);
//            } else {
//                imageView.setImageResource(R.drawable.books);
//            }
//            key = answers[rand];
//            key2 = answers2[rand];
//
//            textbox.setTextColor(Color.WHITE);
//            textbox.getText().clear();
//            ansText.setVisibility(View.INVISIBLE);
//            btn.setText("Check!");

            wsActivity.questionNum = wsActivity.questionNum + 1;
            FragmentTransaction ft = getParentFragmentManager().beginTransaction();

            // Set slide animations
            ft.setCustomAnimations(
                    R.anim.slide_in,  // Enter animation
                    R.anim.slide_out  // Exit animation
            );

            // Replace current fragment with a NEW instance of itself
            ft.replace(R.id.fragment_container, new wsQuestions())
                    .commit();

        }
        else{
            FragmentTransaction ft = getParentFragmentManager().beginTransaction();

            // Set slide animations
            ft.setCustomAnimations(
                    R.anim.slide_in,  // Enter animation
                    R.anim.slide_out  // Exit animation
            );

            // Replace current fragment with a NEW instance of itself
            ft.replace(R.id.fragment_container, new EndScore())
                    .commit();

            Log.i("Else","Else");
//            FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//
//            // Set slide animations
//            ft.setCustomAnimations(
//                    R.anim.slide_in,  // Enter animation
//                    R.anim.slide_out  // Exit animation
//            );
//
//            // Replace current fragment with a NEW instance of itself
//            ft.replace(R.id.fragment_container, new wsQuestions())
//                    .commit();

//            startActivity(new Intent(WritingSectionActivity.this, MainActivity.class));
        }
    }

}











//
//
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}