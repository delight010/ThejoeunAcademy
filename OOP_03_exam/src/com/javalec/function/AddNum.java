package com.javalec.function;

public class AddNum {
	
	// Field
	public int num1, num2;
	
	
	// Constructor
	public AddNum() {
		// TODO Auto-generated method stub
	}
	
	
	
		
	public AddNum(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}




	// Method
	public int AddAction(int num1, int num2) {
		int addResult = num1 + num2;
		return addResult;
	}
	
	
	public void addPrint(int num1, int num2) {
		System.out.println("합계는 " + (num1+num2));
	}

	public int addAction2() {
		return num1 + num2;
	}
	

}
