package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class TestLambda1 {

	/**
	 * 视频2. 尚硅谷_Java8新特性_为什么使用 Lambda 表达式
	 * 2.1	为什么使用lambda 表达式?
	 * 	1.	大大减少结构性的重复代码
	 */
	//原来的匿名内部类
	@Test
	public void test1(){
		Comparator<String> com = new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		TreeSet<String> ts = new TreeSet<>(com);
		
		TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				// 其实有用的代码就这一句, 其他的都是支持用代码
				return Integer.compare(o1.length(), o2.length());
			}
			
		});
	}
	
	//现在的 Lambda 表达式
	@Test
	public void test2(){
		// 大大简化了匿名内部类的其他支持代码
		Comparator<String> com = (x, y) -> Integer.compare(x.length(), y.length());
		TreeSet<String> ts = new TreeSet<>(com);
	}

	// 用于比较的list数据
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);

	//需求：获取公司中年龄小于 35 的员工信息
	public List<Employee> filterEmployeeAge(List<Employee> emps){
		List<Employee> list = new ArrayList<>();
		
		for (Employee emp : emps) {
			if(emp.getAge() <= 35){
				list.add(emp);
			}
		}
		
		return list;
	}
	
	@Test
	public void test3(){
		List<Employee> list = filterEmployeeAge(emps);
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	//需求：获取公司中工资大于 5000 的员工信息
	public List<Employee> filterEmployeeSalary(List<Employee> emps){
		List<Employee> list = new ArrayList<>();
		
		for (Employee emp : emps) {
			if(emp.getSalary() >= 5000){
				list.add(emp);
			}
		}
		
		return list;
	}

	/**
	 * 2.2 没有lambda表达式之前的简化方式
	 * 	优化方式一：策略设计模式
	 //	问题来了, 我每次要进行比较, 都给像上面那样写个方法?
	 // 优化方式一：策略设计模式
	 // 写一个函数式接口, 就是这里的MyPredicate, 而具体的实现由 调用接口时选择不同实现类传入来实现
	 *
	 */

	public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp){
		List<Employee> list = new ArrayList<>();
		
		for (Employee employee : emps) {
			if(mp.test(employee)){
				list.add(employee);
			}
		}
		
		return list;
	}

	/**
	 * 	优化方式一：策略设计模式
	 *  在这里实现上面的两个需求,
	 *  可以看到FilterEmployeeForAge和FilterEmployeeForSalary都是接口MyPredicate的实现类.
	 *  这就是设计模式的一种应用
	 *  那么这里我们发现每次实现一个功能, 都要重新写一个实现不是么?
	 */
	@Test
	public void test4(){
		List<Employee> list = filterEmployee(emps, new FilterEmployeeForAge());
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		System.out.println("------------------------------------------");
		
		List<Employee> list2 = filterEmployee(emps, new FilterEmployeeForSalary());
		for (Employee employee : list2) {
			System.out.println(employee);
		}
	}
	
	//优化方式二：匿名内部类
	@Test
	public void test5(){
		List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getId() <= 103;
			}
		});
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	/**
	 * 2.3	jdk8 的新方式
	 * 	优化方式三：Lambda 表达式
	 */
	@Test
	public void test6(){
		List<Employee> list = filterEmployee(emps, (e) -> e.getAge() <= 35);
		list.forEach(System.out::println);
		
		System.out.println("------------------------------------------");
		
		List<Employee> list2 = filterEmployee(emps, (e) -> e.getSalary() >= 5000);
		list2.forEach(System.out::println);
	}
	
	//优化方式四：Stream API
	@Test
	public void test7(){
		emps.stream()
			.filter((e) -> e.getAge() <= 35)
			.forEach(System.out::println);
		
		System.out.println("----------------------------------------------");
		
		emps.stream()
			.map(Employee::getName)
			.limit(3)
			.sorted()
			.forEach(System.out::println);
	}
}
