package com.yis.study.mystatic;

/**
 * Created by liuyi on 2021-03-17.
 */
public class Test3 {
    private static int age;
    private String name;

    public void sayHello() {
        System.out.println("hello");

    }

    public static void sayHi() {
        System.out.println("hi");
    }

    static class Person {
        private String sex;//静态内部类可以声明普通成员变量和方法
        private static int brother;

        public void method() {
            age = 12;
//            name = "rose";//报错，不能引用非静态的成员变量
            sex = "女";
        }
    }

    class Human {
        private String sex;
//        private static int brother;//报错，普通内部类不能声明static成员变量和方法。

        //普通内部类可以访问任意外部类的成员变量和方法
        public void method() {
            age = 20;
            name = "jack";
            sayHello();
        }

    }




}
