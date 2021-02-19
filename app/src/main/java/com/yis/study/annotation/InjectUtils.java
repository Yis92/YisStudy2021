package com.yis.study.annotation;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by liuyi on 2021-02-19.
 */
public class InjectUtils {

    public static void injectView2(Activity activity) {
        Class<? extends Activity> cls = activity.getClass();

        //获得此类所有的成员
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field filed : declaredFields) {
            // 判断属性是否被InjectView注解声明
            if (filed.isAnnotationPresent(InjectView.class)) {
                InjectView injectView = filed.getAnnotation(InjectView.class);
                //获得了注解中设置的id
                int id = injectView.value();
                View view = activity.findViewById(id);
                //反射设置 属性的值
                filed.setAccessible(true); //设置访问权限，允许操作private的属性
                try {
                    //反射赋值
                    filed.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void injectView(Activity activity) {
        Class<? extends Activity> cls = activity.getClass();

        //获取此类的所有成员
        //getFields()只能获取public的字段，包括父类的
        //getDeclaredFields()只能获取自己声明的各种字段，包括public，protected，private
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            //判断属性是否被 InjectView 注解声明
            if (field.isAnnotationPresent(InjectView.class)) {
                InjectView injectView = field.getAnnotation(InjectView.class);
                //获得了注解中设置的id
                int id = injectView.value();
                View view = activity.findViewById(id);
                //反射设置 属性的值
                field.setAccessible(true);//设置访问权限，允许操作private的属性
                try {
                    //反射赋值
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
