package com.liyuyu.art.designpattern.templatemethod.demo;

import com.liyuyu.art.designpattern.templatemethod.AbstractDrink;
import com.liyuyu.art.designpattern.templatemethod.Coffe;
import com.liyuyu.art.designpattern.templatemethod.Tea;

/**
 * @Description:
 * 模板方法通过抽象类来封装算法步骤，父类抽取共性，子类实现不同
 * @author Lyle
 * @date 2019-05-28
 */
public class Demo {
	
	public static void main(String[] args) {
		AbstractDrink drink = new Coffe();
		drink.makeDrink();
		
		AbstractDrink drink2 = new Tea();
		drink2.makeDrink();
	}
	
}
