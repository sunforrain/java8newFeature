package com.atguigu.java8;

/**
 * 视频15. 尚硅谷_Java8新特性_Optional 容器类
 * 注意这里的Godness可能是null的
 */
public class Man {

	private Godness god;

	public Man() {
	}

	public Man(Godness god) {
		this.god = god;
	}

	public Godness getGod() {
		return god;
	}

	public void setGod(Godness god) {
		this.god = god;
	}

	@Override
	public String toString() {
		return "Man [god=" + god + "]";
	}

}
