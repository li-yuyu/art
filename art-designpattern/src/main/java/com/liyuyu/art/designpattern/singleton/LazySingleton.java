package com.liyuyu.art.designpattern.singleton;

/**
 * @Description:
 * 懒汉式单例，懒加载，当调用方法获取实例时才new实例对象
 * @author Lyle
 * @date 2019-05-30
 */
public class LazySingleton {
	
	private static LazySingleton instance;
	
	private LazySingleton() {}

	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					return new LazySingleton();
				}
			}
		}
		return instance;
	}
	
	public void doSomeThing() {
		System.out.println("LazySingleton do some thing");
	}
}
