package com.liyuyu.art.designpattern.singleton;

/**
 * @Description: 静态内部类单例，懒加载，内部类被调用时才会加载
 * @author Lyle
 * @date 2019-05-30
 */
public class StaticInnerClassSingleton {

	private static class InnerClass {
		private static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
	}

	private StaticInnerClassSingleton() {
	}

	public static StaticInnerClassSingleton getInstance() {
		return InnerClass.instance;
	}

	public void doSomeThing() {
		System.out.println("StaticInnerClassSingleton do some thing");
	}
}
