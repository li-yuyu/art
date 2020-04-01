package com.liyuyu.demo.designpattern.singleton.demo;

import com.liyuyu.demo.designpattern.singleton.HungrySingleton;
import com.liyuyu.demo.designpattern.singleton.LazySingleton;
import com.liyuyu.demo.designpattern.singleton.StaticInnerClassSingleton;

public class Demo {
	
	public static void main(String[] args) {
		HungrySingleton.getInstance().doSometing();
		LazySingleton.getInstance().doSomeThing();
		StaticInnerClassSingleton.getInstance().doSomeThing();
	}
}
