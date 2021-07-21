package com.example.routerdemo.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_common.bean.ScoreBean;
import com.example.lib_common.router.RouterActivityPath;
import com.example.routerdemo.common.Constants;
import com.example.routerdemo.databinding.ActivityMainBinding;
import com.example.routerdemo.router.LoginNavigationCallbackImpl;

/**
 * @author chuxiong
 */
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        mainBinding.btn.setOnClickListener(v -> ARouter.getInstance().build(FirstAty.PATH)
                .withString(FirstAty.PARAM, "这是跳转携带的参数")
                .navigation());

        mainBinding.secondBtn.setOnClickListener(v -> ARouter.getInstance()
                .build(SecondActivity.PATH)
                .withString(SecondActivity.PARAM, "这是跳转携带的参数,requestCode 100")
                .navigation(this, Constants.MAIN_TO_SECOND_REQUEST_CODE)// Activity返回结果处理
        );

        mainBinding.webAtyBtn.setOnClickListener(v -> ARouter.getInstance().build(WebViewAty.PATH).navigation());
        ScoreBean scoreBean = new ScoreBean("68", "I'm form Module App");
        mainBinding.jumpToModuleOneBtn.setOnClickListener(v ->
                ARouter
                        .getInstance()
                        .build(RouterActivityPath.ModuleOne.ONE)
                        .withParcelable("score",scoreBean)
                        .navigation(this, Constants.MAIN_TO_MODULE_ONE_REQUEST_CODE));

           mainBinding.jumpToModuleTwoBtn.setOnClickListener(v ->
                ARouter
                        .getInstance()
                        .build(RouterActivityPath.ModuleTwo.MODULE_MAIN)
                        .navigation(this,new LoginNavigationCallbackImpl()));

           mainBinding.lossBtn.setOnClickListener(v -> ARouter.getInstance().build("/xxx/xxx").navigation());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case Constants.MAIN_TO_SECOND_REQUEST_CODE:
                    mainBinding.tv.setText(data.getStringExtra(SecondActivity.PARAM_RESULT));
                    break;
                case Constants.MAIN_TO_MODULE_ONE_REQUEST_CODE:
                    mainBinding.tv.setText(data.getStringExtra(Constants.PARAM_RESULT));
                    break;
                default:

                    break;
            }

        }
    }
}