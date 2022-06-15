package com.javalec.base;

public class Child01 extends LunchMenu {

	
	public Child01() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Child01(int rice, int bulgogi, int banana, int milk, int almond) {
		super(rice, bulgogi, banana, milk, almond);
		// TODO Auto-generated constructor stub
		System.out.println(rice+bulgogi+banana);
	}

//	@Override
//	public int calc() {
//		// TODO Auto-generated method stub
//		return rice + bulgogi + banana; // 자료형 int
//	}

}
