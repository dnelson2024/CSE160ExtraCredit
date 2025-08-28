package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import com.example.myapplication.databinding.FragmentMainShopBinding;


public class Shop extends Fragment {
    private MainActivity shop;
    private FragmentMainShopBinding binding;
    public Shop(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentMainShopBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        shop = (MainActivity) getActivity();

        return view;
    }


}
