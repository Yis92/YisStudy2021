package com.yis.study.proxy.demo.agent;

import com.yis.study.proxy.demo.Massage;

/**
 * 代理对象：马杀鸡经纪人
 */
public class Agent implements Massage {

    private final Massage massage;

    public Agent(Massage massage) {
        this.massage = massage;
    }

    //....前置处理
    public void before() {
        System.out.println("一条龙服务,包君满意");
    }

    //....后置处理
    public void after() {
        System.out.println("满意度调查");
    }

    @Override
    public void massage() {
        before();
        massage.massage();
        after();
    }
}
