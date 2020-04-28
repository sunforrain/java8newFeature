package com.atguigu.java8;
/**
 * 视频15. 尚硅谷_Java8新特性_Optional 容器类
 * 注意这里的Godness可能是null的
 */
public class Godness {

	private String name;

	public Godness() {
	}

	public Godness(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Godness [name=" + name + "]";
	}

}
