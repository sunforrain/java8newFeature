package com.atguigu.java8;

/**
 * 优化方式一：策略设计模式
 * @param <T>
 */
@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
