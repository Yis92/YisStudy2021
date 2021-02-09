package com.yis.study.proxy.jin;

import android.util.Log;

/**
 * Created by liuyi on 2021-02-09.
 */
public class TargetFactoryServiceImpl implements ITargetFactoryService {
    @Override
    public void sale(String name) {
        Log.i("qqq", name + "购买了商品");
    }
}
