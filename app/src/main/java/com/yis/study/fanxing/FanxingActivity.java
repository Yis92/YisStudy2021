package com.yis.study.fanxing;

import com.yis.study.fanxing.tongpeifu.Fruit;
import com.yis.study.fanxing.tongpeifu.GenericType;
import com.yis.study.fanxing.tongpeifu.bean.Father;
import com.yis.study.fanxing.tongpeifu.bean.People;
import com.yis.study.fanxing.tongpeifu.bean.Son;

/**
 * 泛型
 * Created by liuyi on 2021-02-19.
 */
public class FanxingActivity {

    public static void main(String... args) {
        System.out.println("1230");
        instanceofQuestion();
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
     *412
     * @param genericType super 只能用于 ？
     */
    public void dosome3(GenericType<? super Fruit> genericType) {

    }

    /**
     * 使用instanceof会失败，是因为类型信息已经被擦除，因此我们可以引入类型标签Class< T>，就可以转用动态的isInstance()。
     */
    public static void instanceofQuestion() {
        People<Father> people = new People<Father>(Father.class);
        System.out.println(people.compare(new Father()));// true
        System.out.println(people.compare(new Son()));// true

        People<Son> son = new People<Son>(Son.class);
        System.out.println(son.compare(new Father()));// false
        System.out.println(son.compare(new Son()));// true
    }
}
