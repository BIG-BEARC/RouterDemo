package com.example.routerdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.routerdemo.R;
@Route(path = FiveActivity.PATH)
public class FiveActivity extends AppCompatActivity {
    public static final String PATH = "/test/fiveActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
    }
}