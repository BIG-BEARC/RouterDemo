package com.example.module_two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.lib_common.router.RouterActivityPath;
import com.example.lib_common.router.RouterExtrasFlag;

/**
 * @author chuxiong
 */
@Route(path = RouterActivityPath.ModuleTwo.MODULE_MAIN,extras = RouterExtrasFlag.FLAG_FLUTTER)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}