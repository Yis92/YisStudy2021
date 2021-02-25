package com.yis.study.fanxing.tongpeifu.bean;

/**
 * Created by liuyi on 2021-02-25.
 */
public class People<T> {

    private Class<T> name;

    public People(Class<T> fatherClass) {
        name = fatherClass;
    }

    public boolean compare(Object obj) {
        return name.isInstance(obj);
    }
}
