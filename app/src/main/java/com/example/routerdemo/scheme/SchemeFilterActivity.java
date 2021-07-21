package com.example.routerdemo.scheme;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Description 新建一个Activity用于监听Scheme事件, 之后直接把url传递给ARouter即可
 * @Author chuxiong
 * @Time 2021/6/7 4:53 PM
 */
public class SchemeFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = getIntent().getData();
        // 统一外部跳转的Uri，实现路由器统一分发，减少只依靠Intent属性匹配带来的安全风险
        ARouter.getInstance().build(uri).navigation(this, new NavCallback() {
                    @Override
                    public void onArrival(Postcard postcard) {
                        finish();
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        super.onLost(postcard);
                    }
                }

        );


    }
}
