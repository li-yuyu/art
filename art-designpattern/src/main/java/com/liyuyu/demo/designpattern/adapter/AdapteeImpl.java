package com.liyuyu.demo.designpattern.adapter;

public class AdapteeImpl implements Adaptee {

	@Override
	public void oldFunction() {
		System.out.println("Adaptee excute old function");
	}

}
