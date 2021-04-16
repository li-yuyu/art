package com.lyle.demo.designpattern.singleton.demo;

import com.lyle.demo.designpattern.singleton.HungrySingleton;
import com.lyle.demo.designpattern.singleton.LazySingleton;
import com.lyle.demo.designpattern.singleton.StaticInnerClassSingleton;

public class Demo {
	
	public static void main(String[] args) {
		HungrySingleton.getInstance().doSometing();
		LazySingleton.getInstance().doSomeThing();
		StaticInnerClassSingleton.getInstance().doSomeThing();
	}
}
