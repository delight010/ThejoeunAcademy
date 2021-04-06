package com.javalec.function;

public class SumEvenOdd2 {

	// Field, Property
	int num = 0;
	
	
	
	// Construcotr 생성자
	public SumEvenOdd2() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Method 함수
	public void sumCalc(int num1, int num2) { // 공개여부 :리턴함수(자료형):함수명(매개변수)
		int sum = 0;
		for(int i=num1; i<=num2; i++) {
			sum +=i;
		}
		num = sum;
		System.out.println(num1 + " ~ " + num2 + " 합은 " + sum + "입니다.");
		
	}
	
	
	
	public void evenOdd() { // 홀수 짝수 판별하기
		int remainder = num %2;
		String chk;
		if(remainder==0) {
			chk = "짝수";
		}else {
			chk = "홀수";
		}
	}
	
}
