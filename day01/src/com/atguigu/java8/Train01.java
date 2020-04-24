package com.atguigu.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 视频4. 尚硅谷_Java8新特性_Lambda 练习, 以及后来用方法引用的写法
 */
public class Train01 {

    // 用于比较的list数据
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test1 () {
        Collections.sort(emps, (emp1, emp2) -> {
            if (emp1.getAge() == emp2.getAge()){
                return emp1.getName().compareTo(emp2.getName());
            } else {
                return Integer.compare(emp1.getAge(), emp2.getAge());
            }
        });
        for (Employee emp : emps){
            System.out.println(emp);
        }
    }

    @Test
    public void test2() {
        String str = "abcdefghijk";
        String strBack = handleStr(str, (strin) -> strin.toUpperCase());
        System.out.println(strBack);
        String strBack2 = handleStr(str, (strin) -> strin.substring(2, 5));
        System.out.println(strBack2);

        // 方法引用的写法, 第二个有些别扭...
        Function<String, String> fun = String::toUpperCase;
        System.out.println(fun.apply(str));
        // 静态方法的引用
        Function<String, String> fun2 = Train01::handleStr2;
        System.out.println(fun2.apply(str));
    }
    // 用于处理字符串
    public String handleStr(String str, MyFunction myFun) {
        return myFun.getValue(str);
    }
    public static String handleStr2(String str) {
        return str.substring(2, 5);
    }

    @Test
    public void test3() {
        System.out.println(handleLong(100L, 200L, (x, y) -> x+y));
        System.out.println(handleLong(100L, 200L, (x, y) -> x*y));

        // 方法引用的写法
        BiFunction<Long, Long, Long> biFunction = Long::sum;
        System.out.println(biFunction.apply(100L, 200L));
        // 实例方法的引用
        Train01 train01 = new Train01();
        BiFunction<Long, Long, Long> biFunction2 = train01::handleLong2;
        System.out.println(biFunction2.apply(100L, 200L));

    }

    public Long handleLong(Long l1, Long l2, MyFunction2<Long, Long> myFun2){
        return myFun2.getValue(l1,l2);
    }
    public Long handleLong2(Long l1, Long l2){
        return l1 * l2;
    }
}
