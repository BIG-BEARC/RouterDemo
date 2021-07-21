package com.example.routerdemo.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.lib_common.router.HelloService;

/**
 * @Description
 * @Author chuxiong
 * @Time 2021/6/11 2:08 PM
 */
@Route(path = HelloServiceImpl.PATH, name = "测试服务")
public class HelloServiceImpl implements HelloService {
    public static final String PATH= "/service/singleService";
    private final String TAG = this.getClass().getName();
    private Context mContext;
    @Override
    public void init(Context context) {
        Log.e(TAG, "init: SingleService" );
        this.mContext = context;
    }


    /**
     * 具体服务
     * @param msg
     * @return
     */
    @Override
    public String sayHello(String msg) {
        Toast.makeText(mContext, "这是对外提供的服务" + msg, Toast.LENGTH_SHORT).show();
        return "haha: " + msg;
    }
}
