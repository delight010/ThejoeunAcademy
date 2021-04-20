package com.javalec.function;

public class AddNum {

	
	//Field
	public int num1, num2; // 디폴트 값은 private이므로 public을 써준다
	
	//Constructor
	public AddNum() {
		// TODO Auto-generated method stub
	}
	
	
	
	
	public AddNum(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}




	//Method
	public int addAction(int i, int j) {
		int addResult = i+j;
		return addResult;
	}
	
	public void addPrint(int i, int j) {
		System.out.println(i+j);
	}
	
	public int addAction2() {
		return num1+num2;
	}
	
	
	
}
