package com.yis.study.proxy.demo.statics;


import com.yis.study.proxy.demo.Massage;

/**
 * 真实实现类： 提供马杀鸡服务的露西
 */
public class Lucy implements Massage {

    @Override
    public void massage() {
        System.out.println("36D，手法一流");
    }
}
