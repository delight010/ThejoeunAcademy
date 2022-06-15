package com.javalec.base;

import java.util.Scanner;

public class gugu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scanner = new Scanner(System.in);
				
		System.out.print("단을 입력하세요 : ");
		
		int dan = scanner.nextInt(); 
			for(int i=1; (i<=9)&&(dan<=9); dan++) {
				System.out.print(dan + " X " + i + " = " + (dan*i) + "\t" );
				System.out.print(dan + " X " + (i+1) + " = " + (dan*(i+1)) + "\t" );
				System.out.print(dan + " X " + (i+2) + " = " + (dan*(i+2)) + "\n" );
		}
		
	}

}



// 3개씩 끊어서 출력하기
//for(int i=1; i<=9; i+=3) {
//	System.out.print(dan + " X " + i + " = " + (dan*i) + "\t" );
//	System.out.print(dan + " X " + (i+1) + " = " + (dan*(i+1)) + "\t" );
//	System.out.print(dan + " X " + (i+2) + " = " + (dan*(i+2)) + "\n" );
//}