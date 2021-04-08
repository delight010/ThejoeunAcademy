package com.javalec.function;

public class SubtractNum {
	
	// Field
	public int num1, num2;
	
	// Constructor
	public SubtractNum() {
		// TODO Auto-generated method stub
	}
	
		
	public SubtractNum(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}




	// Method
	public String SubAction(int num1, int num2) { // String 및 포맷을 이용한 방법
		int result = num1 - num2;
		return Integer.toString(result);
	}
		
	
	public void subPrint(int num1, int num2) {
		System.out.println("뺄셈은 " + (num1-num2));
	}
	
	public String SubAction2() { // String 및 포맷을 이용한 방법
		int result =  num1 - num2;
		return Integer.toString(result);
	}

	

}
