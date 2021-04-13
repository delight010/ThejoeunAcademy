package com.javalec.base;

public abstract class LunchMenu { //추상화
	
	//field
	public int rice;
	public int bulgogi;
	public int banana;
	public int milk;
	public int almond;
		
	//constructor
	public LunchMenu() {
		// TODO Auto-generated constructor stub
	}

	public LunchMenu(int rice, int bulgogi, int banana, int milk, int almond) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.banana = banana;
		this.milk = milk;
		this.almond = almond;
		//만일 this구문을 설정해주지않는다면 0으로 나온다. 
		//자식클래스의 calc메소드에서는 필드값을 설정하지않았기때문
		//자식클래스 calc메소드 계산 -> 부모클래스 LunchMenu에서 this구문 불러옴 -> this구문에서 lunchMenu의 field값 불러옴
	}
	
	
	
	//method
	public abstract int calc();
	

}
