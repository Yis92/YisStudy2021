package com.yis.study.fanxing;

import com.yis.study.fanxing.tongpeifu.Fruit;
import com.yis.study.fanxing.tongpeifu.GenericType;

/**
 * 泛型
 * Created by liuyi on 2021-02-19.
 */
public class FanxingActivity {

    public static void main(String... args) {
        System.out.println("1230");
    }

    class A<T> {
        T t;
    }

    interface B<T> {

    }

    class C extends A<String> {
    }


    class C2<T> extends A<T> {

    }

    /**
     * 泛型方法
     */
    public <T> void dosome(T t) {

    }

    /**
     * 只能作用于方法，不能作用于类
     * 通配符 上界
     *
     * @param genericType
     */
    public void dosome2(GenericType<? extends Fruit> genericType) {

    }

    /**
     * 通配符 下界
     *
     * @param genericType super 只能用于 ？
     */
    public void dosome3(GenericType<? super Fruit> genericType) {

    }
}
