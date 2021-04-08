package com.javalec.function;

public class MultiplyNum {
	
	// Field
	public int num1, num2;
	
	// Constructor
	public MultiplyNum() {
		// TODO Auto-generated method stub
	}
	
	
	
	public MultiplyNum(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}



	// Method
	public void MulAction(int num1, int num2) {
		if(num1==0 | num2==0) {
			System.out.println("곱할 수 없습니다");
		}else {
		int result = num1 * num2;
		System.out.println("곱셈은 " +result);
		}
	}
	
	public void mulPrint(int num1, int num2) {
		System.out.println("곱셈은 " + (num1*num2));
	}
	
	
	public void MulAction2() {
		System.out.println("곱셈은 " + (num1*num2)); 
				
	}

	
}
