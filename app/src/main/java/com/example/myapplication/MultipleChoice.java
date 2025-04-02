package com.example.myapplication;

import static android.graphics.Color.rgb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class MultipleChoice extends AppCompatActivity {

    private TextView questionText;
    private Button[] answerButtons = new Button[4];
    private ArrayList<Question> questions;
    private int currentQuestionIndex = 0;
    private Button button1, button2, button3, button4;
    private String correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multiple_choice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        questionText = findViewById(R.id.questionText);
        answerButtons[0] = findViewById(R.id.button1);
        answerButtons[1] = findViewById(R.id.button2);
        answerButtons[2] = findViewById(R.id.button3);
        answerButtons[3] = findViewById(R.id.button4);
        loadQuestions();
        displayNewQuestion();
        new StartGameDialogFragment().show(getSupportFragmentManager(), "GAME_DIALOG");


    }

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
            // Create the AlertDialog object and return it.
            return builder.create();
        }
    }

    public void exit (View v){
        startActivity(new Intent(MultipleChoice.this, MainActivity.class));
    }

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
        ImageView imageView = findViewById(R.id.imageView3);
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
                    checkAnswer((Button) v);
                }
            });
        }
    }

    private void checkAnswer(Button selectedButton) {
        if (selectedButton.getText().toString().equals(correctAnswer)) {
            selectedButton.setBackgroundColor(Color.GREEN);
        } else {
            selectedButton.setBackgroundColor(Color.RED);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentQuestionIndex++;
                displayNewQuestion();
            }
        }, 1000);
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