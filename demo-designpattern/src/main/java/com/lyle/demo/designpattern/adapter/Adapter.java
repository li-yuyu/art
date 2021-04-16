package com.lyle.demo.designpattern.adapter;

public class Adapter implements Target {

	private Adaptee adaptee;

	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void newFunction() {
		adaptee.oldFunction();
	}

}
