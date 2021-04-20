package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("apple\nBanana\nGrape");
		System.out.println("apple\tBanana\tGrape");
		System.out.println("apple\"Banana\"Grape");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input your number : ");
		int start = scanner.nextInt();
		int end=start+3;

		
//		if(start>end) {
//			int temp = start;
//			start = end;
//			end = start;
//		}
		
			
		for(int i = 1; i<=9; i++) {

			for(int dan=start; dan<=end; dan++) {
				System.out.print(dan + " X " + i + " = " + (dan*i) + "\t" );
			}
			System.out.println("");
		}

	}
		
		

		

//		
//		for(i = 1; i<=9; i++) {
//			System.out.print(start + " X " + i + " = " + (start*i) + "\t" + "\n");
//		
//			for(start = 2; start<=9; start++) {
//				System.out.print(start + " X " + i + " = " + (start*i) + "\t" + "\n");
//
//			}
//
//		}
		
	

}






// --------------------------------------------------------
//참고용

//for(i = 1; i<=9; i++) {
//	for(start = 2; start<=9; start++) {
//		System.out.print(start + " X " + i + " = " + (start*i) + "\t");
//	}
//	System.out.print("\n");
//}


// --------------------------------------------------------


//if(start>end) {
//	int temp = start;
//	start = end;
//	end = start;
//}
//
//for(i = 1; i<=9; i++) {
//	System.out.print(start + " X " + i + " = " + (start*i) + "\t" + "\n");
//
//	for(start = 2; start<=9; start++) {
//		System.out.print(start + " X " + i + " = " + (start*i) + "\t" + "\n");
//
//	}