package com.javalec.base;

import java.util.Scanner;

public class exe {

	public static void main(String[] args) {
		
		// 입력한 한 자릿수 정수의 합을 구하는 프로그램을 작성하라.
		
		Scanner scanNum = new Scanner(System.in);
		System.out.print("Enter an integer(0 ~ 9) : ");		 //입력받는 정수
		int namoji = 0; // 나머지
		
		for(int number = scanNum.nextInt(); number!=0; number/=10) {
			namoji += (number%10);	
			// namoji = namoji+(number%10);
			}
		
		System.out.println(namoji);
		
		
		// ==================================================수정 바
		
		Scanner scanNum2 = new Scanner(System.in);
		System.out.print("숫자를 입력하시오 : ");
		int number2 = scanNum2.nextInt();
		int namoji2 = 0;
		
		while(number2!=0 ) {
			number2/=10;
			while(number2!=0) {
				namoji2 += (number2%10);
				}
			
			System.out.println(namoji2);
			}58
		
	
		
		
	}
}
				
			
			

		
		
		
		
	


