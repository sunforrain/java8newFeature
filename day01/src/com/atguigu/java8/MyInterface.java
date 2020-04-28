package com.atguigu.java8;

/**
 * 视频16. 尚硅谷_Java8新特性_接口中的默认方法与静态方法
 */
public interface MyInterface {
	
	default String getName(){
		return "呵呵呵";
	}
	
	public static void show(){
		System.out.println("接口中的静态方法");
	}

}
