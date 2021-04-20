package com.javalec.function;

public class SumEvenOdd {

	// Property 초기값
	
	
	// Constructor 생성자
	public SumEvenOdd() {
		// TODO Auto-generated constructor stub
		
	}
	
	// Method 함수
	public int sumCalc(int num1, int num2) { // 공개여부 :리턴함수(자료형):함수명(매개변수)
		int sum = 0;
		for(int i=num1; i<=num2; i++) {
			sum +=i;
		}
		return sum;
	}
	
	
	
	public void evenOdd(int j) { // 홀수 짝수 판별하기
		int remainder = j %2;
		String chk;
		if(remainder%2==0) {
			chk = "짝수";
		}else {
			chk = "홀수";
		}
	}
	
	
	
}
