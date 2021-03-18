package com.yis.study.mystatic;

/**
 * Created by liuyi on 2021-03-17.
 */
//public static class Test4 {//报错，如果一个类要被声明为static的，只有一种情况，
// 就是静态内部类。如果在外部类声明为static，程序会编译都不会过
public  class Test4 {
    public static void main(String[] args) {
        Test3.Person person = new Test3.Person();//静态内部类可以单独初始化

        //普通内部类初始化
        //Test3.Human human = new Test3.Human();//报错
        Test3 test3 = new Test3();
        Test3.Human human = test3.new Human();

    }
}
