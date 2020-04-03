package com.liyuyu.art.designpattern.singleton.demo;

import com.liyuyu.art.designpattern.singleton.HungrySingleton;
import com.liyuyu.art.designpattern.singleton.LazySingleton;
import com.liyuyu.art.designpattern.singleton.StaticInnerClassSingleton;

public class Demo {
	
	public static void main(String[] args) {
		HungrySingleton.getInstance().doSometing();
		LazySingleton.getInstance().doSomeThing();
		StaticInnerClassSingleton.getInstance().doSomeThing();
	}
}
