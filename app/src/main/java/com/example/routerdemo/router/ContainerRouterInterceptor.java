package com.example.routerdemo.router;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_common.router.RouterActivityPath;
import com.example.lib_common.router.RouterExtrasFlag;

/**
 * @Description 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
 *              priority 优先级，越小，越先执行。
 * @Author chuxiong
 * @Time 2021/6/11 4:21 PM
 */
@Interceptor(priority = 1,name = "测试用拦截器")
public class ContainerRouterInterceptor implements IInterceptor {
    private  final String TAG = this.getClass().getName();
    /**
     * 在Activity跳转时调用，运行在ARouter 的子线程中
     * @param postcard 如果我们要为拦截器加上一些帅选条件的话可以通过Postcard
     * @param callback callback.onContinue(postcard); //处理完成，交还控制权
     *                 callback.onInterrupt(new RuntimeException("我觉得有点异常"));
     *                 以上两种至少需要调用其中一种，否则不会继续路由
     */
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        int routerFlag = postcard.getExtra();
        int flagModuleFlutter = routerFlag & RouterExtrasFlag.FLAG_FLUTTER;
        int flagModuleWeex = routerFlag & RouterExtrasFlag.FLAG_WEEX;
        if (flagModuleFlutter != 0) {
            // 跳转到Flutter模块
            callback.onInterrupt(new RuntimeException("需要处理Flutter路由的跳转"));
         //   ARouter.getInstance().build(RouterActivityPath.ModuleTwo.MODULE_TEST).navigation();
        } else if (flagModuleWeex != 0) {
            // 跳转到Weekx模块
            callback.onInterrupt(new RuntimeException("需要处理Weekx路由的跳转"));
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        Log.e(TAG, "init: ContainerRouterInterceptor ");
    }
}
