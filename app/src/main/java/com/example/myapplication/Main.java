package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.FragmentMainBinding;


public class Main extends Fragment {
    private MainActivity Main;
    private FragmentMainBinding binding;

    public Main(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        Main = (MainActivity) getActivity();

        Button food = binding.food;
        Button travel = binding.travel;
        Button introductions = binding.intro;
        Button hobbies = binding.hobbies;

        Button writing = binding.writing;
        Button learning = binding.learning;
        Button multiplechoice = binding.mc;

        Button shop = binding.shop;

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.topic = "Food";
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
                MainActivity.topic = "Travel";
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
                MainActivity.topic = "Introductions";
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
                MainActivity.topic = "Hobbies";
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
                startActivity(new Intent(requireContext(), WritingSectionActivity.class));
            }
        });

        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(requireContext(), Learning.class));
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();

                // Set slide animations
                ft.setCustomAnimations(
                        R.anim.slide_in,  // Enter animation
                        R.anim.slide_out  // Exit animation
                );

                // Replace current fragment with a NEW instance of itself

                ft.replace(R.id.fragment_container2, new Shop())
                        .commit();
            }
        });



        return view;
    }
}
