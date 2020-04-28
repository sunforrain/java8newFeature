package com.atguigu.java8;

import java.util.concurrent.RecursiveTask;

/**
 * 视频14. 尚硅谷_Java8新特性_并行流与串行流
 * jdk8以前, 并行流需要自己写:
 * 创建一个Fork/Join 框架相关的类, 让其计算累加, 并且一直拆子任务, 直到拆到临界值为止
 * 两个父类可选
 * RecursiveAction 没有返回值
 * RecursiveTask	有返回值
 * Recursive 就是递归
 *
 * jdk8以后, 并行流放到了Stream中
 */
public class ForkJoinCalculate extends RecursiveTask<Long>{

	private static final long serialVersionUID = 13475679780L;

	// 累加的起始值
	private long start;
	// 累加的结束值
	private long end;

	// 比如计算1累加到100000000, 可以拆分为 1累加到50000000, 50000000累加到100000000
	// 然后1累加到50000000, 还可以拆为 1累加到25000000, 25000000累加道100000000
	// 然后1累加到25000000还可以拆... 一直拆到小任务为1累加到10000
	private static final long THRESHOLD = 10000L; //临界值
	
	public ForkJoinCalculate(long start, long end) {
		this.start = start;
		this.end = end;
	}

	// 需要实现的计算的方法
	@Override
	protected Long compute() {
		// 判断一下累加的范围
		long length = end - start;

		// 如果length<=10000, 比如 1累加到10000, 说明拆分到临界值了, 就不能再拆了
		if(length <= THRESHOLD){ // 计算和
			long sum = 0;
			
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			
			return sum;
		}else{// 没到临界值, 就给继续拆分
			long middle = (start + end) / 2;
			
			ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
			left.fork(); //拆分，并将该子任务压入线程队列
			
			ForkJoinCalculate right = new ForkJoinCalculate(middle+1, end);
			right.fork();
			// 拆分之后的总和需要合并
			return left.join() + right.join();
		}
		
	}

}
