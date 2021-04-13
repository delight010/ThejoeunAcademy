package com.javalec.base;

public class Child3 extends LunchMenu {
	
	public Child3() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Child3(int rice, int bulgogi, int banana, int milk, int almond) {
		super(rice, bulgogi, banana, milk, almond);
		// TODO Auto-generated constructor stub
	}



	@Override
	public int calc() { //부모클래스의 calc 메소드를 무시하고 자식클래스의 calc 메소드 실행
		// TODO Auto-generated method stub
		return rice + bulgogi;
	}

}
