package com.yis.study.proxy.demo;

import com.yis.study.proxy.demo.statics.Alvin;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import retrofit2.Retrofit;

public class MyClass {

    public static void main(String[] args) throws Exception {
        //静态代理
//        Massage message = new Lucy();
//        Agent agent = new Agent(message);
//
//        agent.massage();

        // 静态代理的缺点，需要为每一个

        //动态代理
        final Alvin alvin = new Alvin();


        Object o = Proxy.newProxyInstance(MyClass.class.getClassLoader(),
                new Class[]{Massage.class, Wash.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//                        System.out.println(o.toString());
                        return method.invoke(alvin, objects);
                    }
                });

        Massage massage = (Massage) o;
        massage.massage();

        Wash wash = (Wash) o;
        wash.wash();

    }


    private static void proxy() throws Exception {

    }
}
