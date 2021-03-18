package com.yis.study.mystatic;

/**
 * Created by liuyi on 2021-03-17.
 * static块可以出现类中的任何地方（只要不是方法内部，记住，任何方法内部都不行），并且执行是按照static块的顺序执行的。
 */
public class Test2 {
    //4
    Person person = new Person("Test");

    //1
    static{
        System.out.println("test static");
    }

    //5
    public Test2() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class Person{
    //3
    static{
        System.out.println("person static");
    }
    //4或6
    public Person(String str) {
        System.out.println("person "+str);
    }
}


class MyClass extends Test2 {
    //6
    Person person = new Person("MyClass");
    //2
    static{
        System.out.println("myclass static");
    }

    //7
    public MyClass() {
        System.out.println("myclass constructor");
    }
}

//执行结果
//test static
//myclass static
//person static
//person Test
//test constructor
//person MyClass
//myclass constructor
