package com.yis.study.proxy.demo.agent;


import com.yis.study.proxy.demo.Wash;

public class WashAgent implements Wash {
    @Override
    public void wash() {
        System.out.println("不错哦");
    }
}
