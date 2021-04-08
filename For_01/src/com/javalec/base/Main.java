package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//
		
		Scanner scanner_start = new Scanner(System.in);
		Scanner scanner_finish = new Scanner(System.in);
		
		System.out.print("시작하실 단을 입력하세요 :");
		int dan_start = scanner_start.nextInt();
		System.out.print("끝내실 단을 입력하세요 : ");
		int dan_finish = scanner_finish.nextInt();
		
		// 시작과 끝을 자동으로 변환
		
		if(dan_start > dan_finish) {
			int temp = dan_start;
			dan_start = dan_finish;
			dan_finish = temp;

		}
		
		
		
		// 사용자의 입력정보 체크
		if(dan_start>dan_finish) {
			System.out.println("입력정보를 확인하세요");
			
//			for(int danS = dan_start; danS<=dan_finish; danS++) {
//				System.out.println("------" + danS + "단" + "-----");
//				for(int i=(danS%2==0; ? 2:1); i<=9; i+=2) {
//						//	자료형 변환
//							System.out.println(danS + " X "+ i + " = " + String.format("%02d",(danS*i)));
//						}
			
		
		}else {
			for(int danS = dan_start; danS<=dan_finish; danS++) {
				System.out.println("------" + danS + "단" + "-----");
				if(danS%2==0) {
					for(int i=2; i<=9; i+=2) {
						//	자료형 변환
							System.out.println(danS + " X "+ i + " = " + String.format("%02d",(danS*i)));
						}
				}else {
					for(int i=1; i<=9; i+=2) {
						//	자료형 변환
							System.out.println(danS + " X "+ i + " = " + String.format("%02d",(danS*i)));
						}
					
				}
				
			}
		}
	}
}
