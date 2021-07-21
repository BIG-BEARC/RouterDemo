package com.example.lib_common.router;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @Description 声明接口,其他组件通过接口来调用服务
 * @Author chuxiong
 * @Time 2021/6/11 2:19 PM
 */
public interface HelloService extends IProvider {

    String sayHello(String msg);
}
