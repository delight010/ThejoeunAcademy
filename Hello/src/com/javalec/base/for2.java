package com.javalec.base;

import java.util.Scanner;

public class for2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);
//		System.out.println(4);
//		System.out.println(5);
//		System.out.println(6);
//		System.out.println(7);
//		System.out.println(8);
//		System.out.println(9);
//		System.out.println(10);
//		
//		
//		for(int i = 1; i<=10; i++) {
//			System.out.println(i);
		
		
		// 1부터 10까지 합계 구하기
//		int tot = 0; // 누적변수
//		for(int i = 1; i<=10; i++) {
//			tot = tot + i;
//		}
//		System.out.println("1부터 10까지의 합은 " + tot + "입니다.");
		
		
		// Exercise
		// 1부터 100까지의 수중 짝수의 합을 구하시오 (단, if문 사용)
		int totEven = 0;
		int totOdd = 0;
		
		for(int i = 1; i<=100; i++) {
			if(i % 2 == 0) {
				totEven += i; // 짝수의 합
			}else{
				totOdd += i; // 홀수의 합
			}
		}
		System.out.println(totEven + "," + totOdd);
		
		// 1부터 100까지의 수중 짝수의 합 구하기(if문 x)
		
		int totEven_nif = 0;
		for(int i = 2; i<=100; i+=2) {
			totEven_nif += i;
		}
		
		
		
		// 입력한 수의 factorial 구하기 (예:4! = 4*3*2*1)
		
		Scanner answer = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int num = answer.nextInt();
		int answerF = 1;
		
		for(int i = num; i>0; i--) {
			answerF *= i;
		}
		
		System.out.println("답은 " + answerF + "입니다");
		
		
		
		Scanner answer2 = new Scanner(System.in);
		System.out.println("두번째 "+ "숫자를 입력하세요");
		int num2 = answer2.nextInt();
		int answerF2 = 1;
		
		for(int i = 1; i<=num2; i++) {
			answerF2 *= i;
		}
		
		System.out.println("답은 " + answerF2 + "입니다");
		
		
	}
}


