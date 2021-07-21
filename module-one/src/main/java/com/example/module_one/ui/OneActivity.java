package com.example.module_one.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_common.bean.ScoreBean;
import com.example.lib_common.router.HelloService;
import com.example.lib_common.router.RouterActivityPath;
import com.example.module_one.ServiceManage;
import com.example.module_one.databinding.ActivityMainOneBinding;

/**
 * @author chuxiong
 */
@Route(path = RouterActivityPath.ModuleOne.ONE)
public class OneActivity extends AppCompatActivity {

    private ActivityMainOneBinding mBinding;
    /**
     * 如果要在Uri中传递自定义对象，在参数中要使用json字符串(encodeURI转码)传递，创建一个实现了SerializationService接口的类完成json的解析
     */
    @Autowired
    public ScoreBean score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainOneBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        ARouter.getInstance().inject(this);
        mBinding.tv.setText(score == null ? "null" : score.toString());
        mBinding.backToAppBtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("param_result", "I'm OneActivity data");
            setResult(RESULT_OK, intent);
            finish();
        });
        ServiceManage serviceManage = new ServiceManage();
        mBinding.showServiceBtn.setOnClickListener(v -> ARouter
                .getInstance()
                .navigation(HelloService.class)
                .sayHello("hello oneAty"));


        mBinding.showServiceBtn2.setOnClickListener(v -> serviceManage.testService2());

        mBinding.showServiceBtn3.setOnClickListener(v -> serviceManage.testService3());

        mBinding.showServiceBtn4.setOnClickListener(v -> serviceManage.testService4());




    }

}