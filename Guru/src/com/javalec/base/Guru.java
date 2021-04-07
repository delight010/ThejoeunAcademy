package com.javalec.base;

import java.util.Scanner;

public class Guru {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int dan;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("원하시는 단을 입력하세요 : ");
		dan = scanner.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.println(dan + " X " + i + " = " + (dan*i));
		}
		
		
		// Exercise
		// 원하시는 단을 입력하세요 : 7
		// 7 X 2 = 14
		// 7 X 4 = 28
		// 7 X 6 = 42
		// 7 X 8 = 56
		
		int new_dan;
		Scanner dan2 = new Scanner(System.in);
		
		System.out.print("원하시는 단을 입력하세요 : ");
		new_dan = dan2.nextInt();
		
		for(int i=2; i<=9; i+=2) {
			System.out.println(new_dan + " X " + i + " = " + (new_dan*i));
		}
		
		
		
		
		int new_new_dan;
		Scanner dan3 = new Scanner(System.in);
		System.out.print("원하시는 단을 입력하세요 : ");
		new_new_dan = dan3.nextInt();
		
		for(int i = 1; i<=9; i+=2) {
			System.out.println(new_new_dan + " X " + i + " = " + (new_new_dan*i));
		}
		
		
		
		
		int if_dan;
		Scanner ifdan = new Scanner(System.in);
		System.out.print("원하시는 단을 입력하세요 : ");
		if_dan = ifdan.nextInt();
		if(if_dan%2==0) {
			for(int i=1; i<=9; i+=2) {
				System.out.println(if_dan + " X " + i + " = " + (if_dan*i));
			} 
		}else {
				for(int i = 2; i<=9; i+=2) {
					System.out.println(if_dan + " X " + i + " = " + (if_dan*i));
				}		
			
			
		}
		
		
		


	}

}


