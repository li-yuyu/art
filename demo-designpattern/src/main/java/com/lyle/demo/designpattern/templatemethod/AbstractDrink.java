package com.lyle.demo.designpattern.templatemethod;

public abstract class AbstractDrink {

	/**
	 * 模板方法
	 */
	final public void makeDrink() {
		step1();
		step2();
		step3();
		hook();
	}

	private void step1() {
		System.out.println("Heat up water");
	}

	public abstract void step2();

	private void step3() {
		System.out.println("Pour water into the cup");
	}
	
	/**
	 * 钩子方法，子类可选择性实现，自定义一些步骤
	 */
	public void hook() {}
	
}
