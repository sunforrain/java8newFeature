package com.atguigu.java8;

import java.util.Optional;

/**
 * 视频15. 尚硅谷_Java8新特性_Optional 容器类
 * 注意这里的Godness可能是null的, 因此用Optional封装一下
 */
//注意：Optional 不能被序列化
public class NewMan {

	private Optional<Godness> godness = Optional.empty();
	
	private Godness god;
	
	public Optional<Godness> getGod(){
		return Optional.of(god);
	}

	public NewMan() {
	}

	public NewMan(Optional<Godness> godness) {
		this.godness = godness;
	}

	public Optional<Godness> getGodness() {
		return godness;
	}

	public void setGodness(Optional<Godness> godness) {
		this.godness = godness;
	}

	@Override
	public String toString() {
		return "NewMan [godness=" + godness + "]";
	}

}
