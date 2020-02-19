package com.liyuyu.demo.designpattern.adapter.demo;

import com.liyuyu.demo.designpattern.adapter.Adaptee;
import com.liyuyu.demo.designpattern.adapter.AdapteeImpl;
import com.liyuyu.demo.designpattern.adapter.Adapter;
import com.liyuyu.demo.designpattern.adapter.Target;

/**
 * @Description:
 * 适配器将一个接口(adaptee)适配成另一个不同的接口(Target)
 * 后续代码可使用目标接口的新方法，而无需调用老接口的方法
 * @author Lyle
 * @date 2019-05-28
 */
public class Demo {

	public static void main(String[] args) {
		Adaptee adaptee = new AdapteeImpl();
		Target target = new Adapter(adaptee);
		target.newFunction();
	}
}
