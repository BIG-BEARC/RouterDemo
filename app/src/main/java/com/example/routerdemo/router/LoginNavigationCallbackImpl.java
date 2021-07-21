package com.example.routerdemo.router;

import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_common.router.RouterActivityPath;

/**
 * @Description
 * @Author chuxiong
 * @Time 2021/6/16 10:55 AM
 */
public class LoginNavigationCallbackImpl implements NavigationCallback {
    private final String TAG = this.getClass().getName();
    @Override
    public void onFound(Postcard postcard) {
        Log.e(TAG, "onFound: ");
    }

    @Override
    public void onLost(Postcard postcard) {
        Log.e(TAG, "onLost: " );
    }

    @Override
    public void onArrival(Postcard postcard) {
        Log.e(TAG, "onArrival: " );
    }

    @Override
    public void onInterrupt(Postcard postcard) {
        Log.e(TAG, "onInterrupt: " );
        ARouter.getInstance().build(RouterActivityPath.Main.MODULE_LOSS).navigation();
    }
}
