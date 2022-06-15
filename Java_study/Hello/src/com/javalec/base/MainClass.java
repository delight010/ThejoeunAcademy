package com.javalec.base;

public class MainClass {

	public static void main(String[] args) {
			
		/*----------------------------
		 *아래의 기능은 화면에 출력되지 않습니다
		 *----------------------------
		 */
		
		//화면에 문자열 상수 출력
	System.out.println("-------------");
	System.out.println("Hello, World!");
	System.out.println("-------------");
	
	System.out.print("-------------");
	System.out.print("Hello, World!");
	System.out.print("-------------");
	System.out.println("");

	// 화면에 정수(숫자) 상수 출력
	System.out.println(10);
	System.out.println(10+20); // 덧셈
	System.out.println(10-20); // 뺄셈
	System.out.println(10*20); // 곱셈
	System.out.println(10/20); // 나눗셈
	System.out.println(10.0/20.0); // 나눗셈
	
	// 화면 출력을 예쁘게 하기
	System.out.println("a "+"b");
	System.out.println(10 + "+" + 20 + "=" + (10+20));
	System.out.println(10 + "-" + 20 + "=" + (10-20));
	System.out.println(10 + "*" + 20 + "=" + (10*20));
	System.out.println(10 + "/" + 20 + "=" + (10/20));
	System.out.println(10.0 + "/" + 20.0 + "=" + (10.0/20.0));
	
	}
}
