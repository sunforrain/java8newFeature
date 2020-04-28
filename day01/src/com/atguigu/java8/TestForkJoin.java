package com.atguigu.java8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

/**
 * 视频14. 尚硅谷_Java8新特性_并行流与串行流
 */
public class TestForkJoin {

	// ForkJoin计算累加
	@Test
	public void test1(){
		// currentTimeMillis是jdk8获得当前时间(毫秒)的方法
		long start = System.currentTimeMillis();
		// ForkJoin的运行需要个线程池的支持
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 10000000000L);
		
		long sum = pool.invoke(task);
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费的时间为: " + (end - start)); //112-1953-1988-2654-2647-20663-113808
	}

	// 普通for的计算累加
	@Test
	public void test2(){
		long start = System.currentTimeMillis();
		
		long sum = 0L;
		
		for (long i = 0L; i <= 10000000000L; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费的时间为: " + (end - start)); //34-3174-3132-4227-4223-31583
	}

	// 并行Stream的累加, 这就是jdk8对于ForkJoin的实现, 简单许多
	@Test
	public void test3(){
		long start = System.currentTimeMillis();
		
		Long sum = LongStream.rangeClosed(0L, 10000000000L)
							 .parallel().reduce(0 , Long::sum);
//							 .sum();
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费的时间为: " + (end - start)); //2061-2053-2086-18926
	}

}
