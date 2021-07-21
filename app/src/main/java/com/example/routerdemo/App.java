package com.example.routerdemo;


import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Description
 * @Author chuxiong
 * @Time 2021/6/7 3:49 PM
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
    }
    private void initRouter() {
        // 必须在初始化ARouter之前配置
        if (BuildConfig.DEBUG){
            //  调试模式开启，如果在install run模式下运行，则必须开启调试模式
            ARouter.openDebug();
            // 日志开启
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
