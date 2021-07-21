package com.example.routerdemo.router;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.fastjson.JSON;

import java.lang.reflect.Type;

/**
 * @Description
 * 如果需要传递自定义对象，新建一个类（并非自定义对象类），然后实现 SerializationService,
 * 并使用@Route注解标注(方便用户自行选择序列化方式)
 *
 * 同时 ARouter 还支持传递 Object 对象，只需调用 withObject 方法，同时需要在我们的 moudle 下面增加相关的实现
 * SerializationService 接口的类。
 * @Author chuxiong
 * @Time 2021/6/8 11:19 AM
 */
@Route(path =JsonServiceImpl.PATH )
public class JsonServiceImpl implements SerializationService {

    public static final String PATH = "/score/json";
    private static final String TAG = "JsonServiceImpl";

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return JSON.toJSONString(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return JSON.parseObject(input, clazz);
    }

    @Override
    public void init(Context context) {
        Log.d(TAG, "init: JsonServiceImpl ");
    }
}
