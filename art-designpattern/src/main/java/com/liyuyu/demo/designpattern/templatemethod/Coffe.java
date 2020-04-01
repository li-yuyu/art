package com.liyuyu.demo.designpattern.templatemethod;

public class Coffe extends AbstractDrink {

	@Override
	public void step2() {
		System.out.println("Put coffe in the cup");
	}

	@Override
	public void hook() {
		System.out.println("Add some milk");
	}
	
}
