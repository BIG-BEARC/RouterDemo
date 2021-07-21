package com.example.routerdemo.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_common.bean.ScoreBean;
import com.example.routerdemo.common.Score;
import com.example.routerdemo.databinding.ActivitySixBinding;

/**
 * @author chuxiong
 */
@Route(path = SixActivity.PATH)
public class SixActivity extends AppCompatActivity {
    ActivitySixBinding binding;
    public static final String PATH = "/test/sixActivity";
    @Autowired
    public String name;
    @Autowired
    public int age;
    /**
     * 如果要在Uri中传递自定义对象，在参数中要使用json字符串(encodeURI转码)传递，创建一个实现了SerializationService接口的类完成json的解析
     */
    @Autowired
    public Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySixBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 参数自动依赖注入
        ARouter.getInstance().inject(this);

        String info = "name=" + name + ",age=" + age + ",score=" + score;
        binding.tv.setText(info);
        Log.i("SixActivity", info);
    }
}