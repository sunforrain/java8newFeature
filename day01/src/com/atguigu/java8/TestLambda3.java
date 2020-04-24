package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/*
 * 视频5. 尚硅谷_Java8新特性_四大内置核心函数式接口
 * Java8 内置的四大核心函数式接口
 * 
 * Consumer<T> : 消费型接口
 * 		对类型为T的对象应用操作, 没有返回值
 * 		void accept(T t);
 * 
 * Supplier<T> : 供给型接口
 * 		返回类型为T的对象, 进T出T
 * 		T get(); 
 * 
 * Function<T, R> : 函数型接口
 * 		对类型为T的对象应用操作，并返回结果。结果是R类型的对象。进T出R
 * 		R apply(T t);
 * 
 * Predicate<T> : 断言型接口
 * 		确定类型为T的对象是否满足某约束，并返回 boolean 值
 * 		boolean test(T t);
 *
 *	其他接口:
 * 	BiFunction<T,U,R>
 *		对类型为T,U参数应用操作，返回R类型的结果。
 *		R apply(T t,U u);
 *
 * 	UnaryOperator<T>(Function子接口)
 * 		对类型为T的对象进行一元运算，并返回T类型的结果。
 *		T apply(T t);
 *
 * 	BinaryOperator<T>(BiFunction子接口)
 * 		对类型为T的对象进行二元运算，并返回T类型的结果。
 * 		T apply(T t1,T t2);
 *
 * BiConsumer<T,U>
 *		对类型为T,U参数应用操作。
 *		 void accept(T t,U u)
 *
 * ToIntFunction<T>
 * ToLongFunction<T>
 * ToDoubleFunction<T>
 *		分别计算int、long、double、值的函数
 * 		int applyAsInt(T value);
 *
 * IntFunction<R>
 * LongFunction<R>
 * DoubleFunction<R>
 * 		参数分别为int、long、double类型的函数
 * 		R apply(int value);
 */
public class TestLambda3 {
	
	//Predicate<T> 断言型接口：
	@Test
	public void test4(){
		List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
		List<String> strList = filterStr(list, (s) -> s.length() > 3);
		
		for (String str : strList) {
			System.out.println(str);
		}
	}
	
	//需求：将满足条件的字符串，放入集合中
	public List<String> filterStr(List<String> list, Predicate<String> pre){
		List<String> strList = new ArrayList<>();

		for (String str : list) {
			if(pre.test(str)){
				strList.add(str);
			}
		}
		
		return strList;
	}
	
	//Function<T, R> 函数型接口：
	@Test
	public void test3(){
		String newStr = strHandler("\t\t\t 我大尚硅谷威武   ", (str) -> str.trim());
		System.out.println(newStr);
		
		String subStr = strHandler("我大尚硅谷威武", (str) -> str.substring(2, 5));
		System.out.println(subStr);
	}
	
	//需求：用于处理字符串
	public String strHandler(String str, Function<String, String> fun){
		return fun.apply(str);
	}
	
	//Supplier<T> 供给型接口 :
	@Test
	public void test2(){
		List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
		
		for (Integer num : numList) {
			System.out.println(num);
		}
	}
	
	//需求：产生指定个数的整数，并放入集合中
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		
		return list;
	}
	
	//Consumer<T> 消费型接口 :
	@Test
	public void test1(){
		happy(10000, (m) -> System.out.println("你们刚哥喜欢大宝剑，每次消费：" + m + "元"));
	} 
	
	public void happy(double money, Consumer<Double> con){
		con.accept(money);
	}
}
