package com.example.routerdemo.router;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_common.router.RouterActivityPath;

/**
 * @Description
 * @Author chuxiong
 * @Time 2021/6/15 1:17 PM
 */
@Route(path = DegradeServiceImpl.PATH)
public class DegradeServiceImpl implements DegradeService {
    public static final String PATH = "/score/DegradeServiceImpl";
    private final String TAG = this.getClass().getName();
    @Override
    public void onLost(Context context, Postcard postcard) {
        ARouter.getInstance().build(RouterActivityPath.Main.MODULE_LOSS).navigation();
    }

    @Override
    public void init(Context context) {
        Log.e(TAG, "init: DegradeServiceImpl init");
    }
}
