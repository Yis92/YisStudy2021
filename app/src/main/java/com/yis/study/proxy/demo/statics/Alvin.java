package com.yis.study.proxy.demo.statics;


import com.yis.study.proxy.demo.Massage;
import com.yis.study.proxy.demo.Wash;

/**
 *  实实现类： 提供马杀鸡服务的Alvin
 */
public class Alvin implements Massage, Wash {

    @Override
    public void massage() {

        System.out.println("精通各种按摩手法");
    }

    @Override
    public void wash() {
        System.out.println("精通各种按摩手法2222");
    }
}
