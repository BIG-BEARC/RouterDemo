package com.example.routerdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.lib_common.router.RouterActivityPath;
import com.example.routerdemo.R;

/**
 * @author chuxiong
 */
@Route(path = RouterActivityPath.Main.MODULE_LOSS)
public class LossActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss);
    }
}