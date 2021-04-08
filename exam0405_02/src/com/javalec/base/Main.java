package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


		System.out.print("몇 단계의 피라미드로 구성할까 ? : ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		
		int value = 1;
		
		for(int i = 1; i<=number; i++) {
			
			for(int j = 1; j<=i; j++) { // 반복되서 실행 될 때 j는 무조건 1부터 시작한다는 걸 염두할 것
				System.out.print(value + " "); 
				value++;
			}
			System.out.println("");
		}
		
	}

}
