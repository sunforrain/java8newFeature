package com.atguigu.java8;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 视频21. 尚硅谷_Java8新特性_重复注解与类型注解
 */
public class TestAnnotation {
    // 基于 checker framework的注解, 可以用于检查类型
//    @NonNull
    private Object obj = null;

    // 利用反射也可以得到注解的数组
    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");
        // getAnnotationsByType可以直接获取注解的全部信息
        MyAnnotation[] mas = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation: mas) {
            System.out.println(myAnnotation.value());
        }
    }
    @MyAnnotation("hello")
    @MyAnnotation ("world")// jdk8以前不能写重复的注解, jdk8如果需要必须要给搞一个容器
    public void show(@MyAnnotation("abc") String str){}// 同时jdk8提供了基于参数类型的注解, 可以用于检查参数
}
