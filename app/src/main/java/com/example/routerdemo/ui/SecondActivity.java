package com.example.routerdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.routerdemo.R;
import com.example.routerdemo.databinding.ActivitySecondBinding;

@Route(path = SecondActivity.PATH)
public class SecondActivity extends AppCompatActivity {
    public static final String PATH = "/test/secondActivity";
    public static final String PARAM = "param";
    public static final String PARAM_RESULT = "param_result";
    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            binding.tv.setText(intent.getStringExtra(PARAM));
            intent.putExtra(PARAM_RESULT, "这是返回携带的参数");
            setResult(RESULT_OK, intent);
            binding.finishBtn.setOnClickListener(v -> finish());
        }

    }
}