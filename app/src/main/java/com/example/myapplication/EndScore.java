package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.myapplication.databinding.FragmentEndScoreBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EndScore#} factory method to
 * create an instance of this fragment.
 */
public class EndScore extends Fragment {

    private WritingSectionActivity wsActivity;
    private FragmentEndScoreBinding binding;
    private TextView timeElapsed,qRight,qWrong,timeBonus,scoreText,correctBonus;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentEndScoreBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        wsActivity = (WritingSectionActivity) getActivity();

        timeElapsed = (TextView) binding.timeElapsed;
        qRight = (TextView) binding.qRight;
        qWrong = (TextView) binding.qWrong;
        timeBonus = (TextView) binding.timeBonus;
        scoreText = (TextView) binding.score;
        correctBonus = (TextView) binding.correctBonus;
        //assert wsActivity != null;
        long elapsedTime = ((wsActivity.endTime - wsActivity.startTime)/1_000_000)/1000;
        int timeBonusPoints = 50 - (int)(elapsedTime/2.4);
        if (timeBonusPoints < 0){
            timeBonusPoints = 0;
        }


        timeElapsed.setText("Time: " + DateUtils.formatElapsedTime(elapsedTime));
        qRight.setText("Questions Right: " + wsActivity.questionR);
        qWrong.setText("Questions Wrong: " + wsActivity.questionW);
        scoreText.setText("Score: " + (timeBonusPoints + (wsActivity.questionR * 50)));
        timeBonus.setText("Time Bonus: " + timeBonusPoints);
        correctBonus.setText("Correct Bonus: " + wsActivity.questionR + " x 50");


        return view;
    }
}