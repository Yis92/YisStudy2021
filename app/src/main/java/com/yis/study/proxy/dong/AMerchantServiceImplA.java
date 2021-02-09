package com.yis.study.proxy.dong;

import android.util.Log;

/**
 * Created by liuyi on 2021-02-09.
 */
public class AMerchantServiceImplA implements ASellService {
    @Override
    public void sale(String name) {
        Log.i("qqq", name + "购买了A商品");
    }
}
