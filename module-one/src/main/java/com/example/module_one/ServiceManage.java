package com.example.module_one;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_common.router.HelloService;

/**
 * @Description
 * @Author chuxiong
 * @Time 2021/6/11 2:53 PM
 */
public class ServiceManage {

    public ServiceManage() {
        ARouter.getInstance().inject(this);
    }

    @Autowired
    HelloService mHelloService;

    @Autowired(name = "/service/singleService")
    HelloService helloService2;

    HelloService helloService3;


    public void testService2(){
        // 1. (推荐)使用依赖注入的方式发现服务,通过注解标注字段,即可使用，无需主动获取
        // Autowired注解中标注name之后，将会使用byName的方式注入对应的字段，不设置name属性，
        // 会默认使用byType的方式发现服务(当同一接口有多个实现的时候，必须使用byName的方式发现服务)
        mHelloService.sayHello("Autowired");

    }

    public void testService3(){
        helloService2.sayHello(" @Autowired(name = \"/service/singleService\") ");
    }
    public void testService4(){
        helloService3 = (HelloService) ARouter.getInstance().build("/service/singleService").navigation();
        helloService3.sayHello(" build(\"/service/singleService\") ");
    }

}
