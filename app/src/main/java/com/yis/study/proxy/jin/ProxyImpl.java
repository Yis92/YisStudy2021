package com.yis.study.proxy.jin;

import android.util.Log;

/**
 * Created by liuyi on 2021-02-09.
 */
public class ProxyImpl implements ITargetFactoryService {

    ITargetFactoryService service;

    public ProxyImpl(ITargetFactoryService service) {
        this.service = service;
    }

    @Override
    public void sale(String name) {
        before();
        Log.i("qqq", name + "通过代理购买了商品");
        after();
    }

    /**
     * 后置增强
     */
    private void after() {
        Log.i("qqq", "代购在购买后得到了市场调研结果");
    }

    /**
     * 前置增强
     */
    private void before() {
        Log.i("qqq", "代购在购买前做了市场调研");
    }
}
