package com.javalec.function;

import java.util.Scanner;

public class Calc {
	
	
	//field
	Scanner scanner = new Scanner(System.in);
	public int num1 = 0;
	public int num2 = 0;
	public int sum = 0;
	public int sub = 0;
	public int mul = 0;
	public int div = 0;
	
	//constructor
	
	public Calc() {
		
	}
	
	
	//method
	public void calc() {
		System.out.print("첫번째 숫자를 입력하세요:");
		num1 = scanner.nextInt();
		System.out.print("첫번째 숫자를 입력하세요:");
		num2 = scanner.nextInt();
		
	
		
		System.out.println(">>>>>>>>결과<<<<<<<<<");
		
		
		
	}
	
	
	public void calcAdd() {
		sum = num1+num2;
		System.out.println("덧셈 : " + sum);
	}
	
	public void calcSub() {
		sub = num1-num2;
		System.out.println("뺄셈 : " + sub);
	}
	
	public void calcMul() {
		if(num1!=0 && num2!=0) {
			mul = num1*num2;
			System.out.println("곱셈 : " + mul);
		}else {
			System.out.println("곱할 수 없습니다.");
		}
		
	}
	
	public void calcDiv() {
			double div;
			div = (double)num1/num2;
			System.out.println("나눗셈 : " + div);
	}
	
	
	

}
