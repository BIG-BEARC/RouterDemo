package com.example.routerdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.routerdemo.R;
import com.example.routerdemo.databinding.ActivityFirstAtyBinding;

@Route(path = FirstAty.PATH)
public class FirstAty extends AppCompatActivity {
    public static final String PATH = "/test/firstActivity";
    public static final String PARAM = "param";

    ActivityFirstAtyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstAtyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        if (intent!=null){
            String param = intent.getStringExtra(PARAM);
            binding.tv.setText(param);
        }
    }
}