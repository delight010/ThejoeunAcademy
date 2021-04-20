package com.javalec.base;

public class ThrowsClass {

	//Field
	
	
	//Constructor
	public ThrowsClass() { //메소드들을 공개하지 않고 실행 가능
		doC();
	}
	
	//Method
	private void doA() { //만일 throws Exception를 붙여쓰게되면 에러코드가 나타나지않음(java8기준)
		System.out.println("doA");
		int[] arr = {1,2,3,4};
		System.out.println(arr[4]); // arr[4]가 없으므로 catch구문 실행
		System.out.println("endA");
	}
	
	private void doB() {
		System.out.println("doB");
		try {
			doA();
		}catch(Exception e) {
			System.out.println("Exception은 여기서");
			System.out.println(e.getMessage());
		}
		System.out.println("endB");
	}
	
	private void doC() {
		System.out.println("doC");
		doB();
		System.out.println("endC");
	}
	
	
}
