package com.javalec.fuction;

import java.util.Scanner;

public class Gugu {
	
	//field
		Scanner scanner = new Scanner(System.in);
		public int dan = 0;
		
		
		
		//Constructor
		public Gugu() {
			// TODO Auto-generated method stub
		}
		
		

		//Method
		//if문
		public void guguDan() {
			System.out.print("구구단을 출력할 숫자를 입력하세요:");
			dan = scanner.nextInt();
			for(int i=1; i<=9; i++) {
				if(i%2==0) {
					String star="*";
					System.out.println(dan + " X " + star + " = " + (dan*i) );
				}else {
				System.out.println(dan + " X " + i + " = " + (dan*i));
				}
			}
		}
		
		
		//삼항연산자
		public void guguDan2() {
			System.out.print("구구단을 출력할 숫자를 입력하세요:");
			dan = scanner.nextInt();
			for(int i=1; i<=9; i++) {
				System.out.println(dan + " X " + (i%2==0? "*" : i) + " = " + (dan*i) );
			}
		}
		
		
		//while문
		public void guguDan3() {
			System.out.print("구구단을 출력할 숫자를 입력하세요:");
			dan = scanner.nextInt();
			int i = 1;
			while(i<=9) {
				System.out.println(dan + " X " + (i%2==0? "*":i) + " = " + (dan*i));
				i++;
			}
		}
		

}
