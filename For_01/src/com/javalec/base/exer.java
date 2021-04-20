package com.javalec.base;

import java.util.Scanner;

public class exer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 대각선길이구하기
		Scanner x = new Scanner(System.in);
		Scanner y = new Scanner(System.in);
		
		System.out.print("밑변을 입력하세요 : ");
		int x1 = x.nextInt();
		System.out.print("높이를 입력하세요 : ");
		int y1 = y.nextInt();
		int z = x1*y1/2;
		
		System.out.println("대각선의 길이는 " + z + " 입니다.");
		

	}

}
