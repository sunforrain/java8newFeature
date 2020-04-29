package com.atguigu.java8;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;

/**
 * 视频21. 尚硅谷_Java8新特性_重复注解与类型注解
 * 自定义注解
 * 以下是元注解(用于描述注解的注解), 忘了怎么办?
 * 随便写个认识的注解, 比如@SuppressWarnings, 点进去复制它里面的
 * @Repeatable: 可重复注解必须要有, 其中的参数是重复注解的容器注解, 容器是 MyAnnotations
 * @Target: 可以修饰的目标
 * @Retention: 生命周期, 有class, runtime等
 */
@Repeatable(MyAnnotations.class)
@Target({TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR,
                ElementType.LOCAL_VARIABLE, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "atguigu";
}

