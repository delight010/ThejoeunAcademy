package com.javalec.base;

import java.util.Scanner;

public class exam {

	public static void main(String[] args) {

		// scanner로 값을 n개 받아, 총합구하기
		
		Scanner scanner = new Scanner(System.in);
		
		int i = 1;
		int answer = 0;
		
		System.out.print("몇 개의 숫자를 더할까요 ? : ");
		int num = scanner.nextInt();
		
		System.out.println(num + "의 숫자를 입력하세요");
		while(i <= num) {
			int sum = scanner.nextInt();
			answer += sum;
			i++;
		}
		System.out.println("입력한 숫자의 합은 " + answer + " 입니다.");
	}

}
