package com.liyuyu.demo.designpattern.singleton;

/**
 * @Description:
 * 饿汉式单例，虚拟机启动，类一经过加载即创建实例对象
 * @author Lyle
 * @date 2019-05-30
 */
public class HungrySingleton {

	private static HungrySingleton instance = new HungrySingleton();
	
	private HungrySingleton() {}
	
	public static HungrySingleton getInstance() {
		return instance;
	}
	
	public void doSometing() {
		System.out.println("HungrySingleton do some thing");
	}
}

