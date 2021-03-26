package com.yis.study;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by liuyi on 2021-03-25.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //ARouter 只需要在主进程初始化
        initARouter();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
