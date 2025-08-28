package com.example.myapplication;

import static android.graphics.Color.rgb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import android.graphics.Color;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.FragmentMcQuestionsBinding;
import com.example.myapplication.databinding.FragmentWsQuestionsBinding;

import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoice extends Fragment {

    private TextView questionText;
    private Button[] answerButtons = new Button[4];
    private ArrayList<Question> questions;
    private int currentQuestionIndex = 0;
    private Button button1, button2, button3, button4;
    private String correctAnswer;
    private WritingSectionActivity wsActivity;
    private MediaPlayer right_Sound;
    private MediaPlayer wrong_Sound;
    private FragmentMcQuestionsBinding binding;
    private Button selectedButton = null;


    public MultipleChoice(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMcQuestionsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        wsActivity = (WritingSectionActivity) getActivity();

        right_Sound = MediaPlayer.create(requireContext(), R.raw.correct_s1);
        wrong_Sound = MediaPlayer.create(requireContext(), R.raw.wrong_s1);
        boolean chosen =false;

        questionText = binding.questionText;
        answerButtons[0] = binding.button1;
        answerButtons[1] = binding.button2;
        answerButtons[2] = binding.button3;
        answerButtons[3] = binding.button4;
        loadQuestions();
        displayNewQuestion();
        Button button = binding.button10;
        button.setOnClickListener(v -> {
            checkAnswer(view);
        });


        return view;
    }


//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.fragment_mc_questions);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });


        //new StartGameDialogFragment().show(getSupportFragmentManager(), "GAME_DIALOG");




    /*
    public static class StartGameDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction.
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Start the Multiple Choice Activity?")
                    .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // START THE GAME!
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancels the dialog.
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }

    }
       */

    private void loadQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("¿Dónde puedo encontrar algunos libros?",
                "En la biblioteca", "En el baño", "En la cocina", "En el supermercado"));
        questions.add(new Question("¿Como puedo llegar al hotel?",
                "En un auto", "En el tren", "En una bicicleta", "En una avión"));
        questions.add(new Question("¿Dónde puedo comprar una chamarra?",
                "En el centro comercial", "En un dormitorio", "Las chamarras no existen", "En tu armario"));

        Collections.shuffle(questions);

    }


    private void displayNewQuestion() {
        if (currentQuestionIndex >= questions.size()) {
            currentQuestionIndex = 0;
            Collections.shuffle(questions);
        }

        Question currentQuestion = questions.get(currentQuestionIndex);
        ImageView imageView = binding.imageView4;
        if (questions.get(0).equals("¿Dónde puedo encontrar algunos libros?")){
            imageView.setImageResource(R.drawable.books);
        } else if (questions.get(2).equals("¿Dónde puedo comprar una chamarra?")){
            imageView.setImageResource(R.drawable.jacket);
        }
        questionText.setText(currentQuestion.getQuestion());

        ArrayList<String> answers = new ArrayList<>();
        answers.add(currentQuestion.getCAnswer());
        answers.add(currentQuestion.getWAnswer1());
        answers.add(currentQuestion.getWAnswer2());
        answers.add(currentQuestion.getWAnswer3());
        Collections.shuffle(answers);

        correctAnswer = currentQuestion.getCAnswer();

        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(answers.get(i));
            answerButtons[i].setBackgroundColor(Color.parseColor("#654321"));

            answerButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (binding.button10.getText().equals("Check!")) {
                        clickedAnswer((Button) v);
                    }
                    }
            });

//            answerButtons[i].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    checkAnswer((Button) v);
//
//
//                }
//            });
        }
    }

    public void clickedAnswer(View v){

        for (int i = 0; i < 4; i++) {
            answerButtons[i].setBackgroundColor(Color.parseColor("#654321"));
        }
        v.setBackgroundColor(Color.parseColor("#c7803a"));
        selectedButton = (Button) v;
    }
    private void checkAnswer(View v) {
        Button btn = (Button) binding.button10;
        if (selectedButton != null && btn.getText().equals("Check!")) {
            if (selectedButton.getText().toString().equals(correctAnswer)) {
                wsActivity.questionR += 1;
                wsActivity.score += 30;
                selectedButton.setBackgroundColor(Color.rgb(0, 200, 0));
                right_Sound.setVolume(1.0f, 1.0f); // Default to full volume of the MediaPlayer
                right_Sound.start();

            } else {
                selectedButton.setBackgroundColor(Color.RED);
                wsActivity.questionW += 1;
                wrong_Sound.setVolume(1.0f, 1.0f); // Default to full volume of the MediaPlayer
                wrong_Sound.start();

                for (int i = 0; i < 4; i++) {
                    if (answerButtons[i].getText().toString().equals(correctAnswer)) {
                        answerButtons[i].setBackgroundColor(Color.rgb(0, 200, 0));
                    }

                }
            }
            selectedButton = null;
            btn.setText("Next");
        }

        else if(btn.getText().equals("Next")){
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

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                currentQuestionIndex++;
//                displayNewQuestion();
//            }
//        }, 1000);
    }

    private static class Question {
        private final String question;
        private final String CAnswer;
        private final String WAnswer1;
        private final String WAnswer2;
        private final String WAnswer3;

        public Question(String question, String CAnswer, String WAnswer1, String WAnswer2, String WAnswer3) {
            this.question = question;
            this.CAnswer = CAnswer;
            this.WAnswer1 = WAnswer1;
            this.WAnswer2 = WAnswer2;
            this.WAnswer3 = WAnswer3;
        }

        public String getQuestion() {
            return question;
        }

        public String getCAnswer() {
            return CAnswer;
        }

        public String getWAnswer1() {
            return WAnswer1;
        }

        public String getWAnswer2() {
            return WAnswer2;
        }

        public String getWAnswer3() {
            return WAnswer3;
        }


    }
}