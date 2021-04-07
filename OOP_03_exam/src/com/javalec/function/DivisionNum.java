package com.javalec.function;

public class DivisionNum {

	// Field
	public int num1, num2;
	
	// Constructor
	public DivisionNum() {
		// TODO Auto-generated method stub
	}
	
	
	
	public DivisionNum(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}



	// Method
	public void divAction(int num1, int num2) {
		if(num1<num2 | num1==0 | num2 ==0) {
			System.out.println("나눌 수 없습니다");
		}else {
			System.out.println("나눗셈은 "+num1/num2);			
		}
	}
	
	public void divPrint(int num1, int num2) {

		if(num1<num2 | num1==0 | num2 ==0) {
			System.out.println("나눌 수 없습니다");
		}else {
			System.out.println("나눗셈은 "+(num1/num2));			
		}
	}
	
	
	public void divAction2() {
		if(num1!=0 && num2 !=0 ) {
			System.out.println("나눗셈은 "+(num1/num2));	
			if(num1<num2) {
				System.out.println("나눌 수 없습니다");		
			}
		}else {
			
		}
	}
	
}
