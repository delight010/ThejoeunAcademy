package com.javalec.base;

import java.util.Scanner;

public class Main_array06 {

	public static void main(String[] args) {
		// 몇 개의 숫자를 입력할 지 결정한 후, 숫자를 입력하고 이중 최대값의 위치와 최대값을 구하라.
		
		Scanner scanner = new Scanner(System.in);
		int max = 0;
		int min = 1000000;
		
		int bestMin = 0;

		
		
		//------------------------------------------------------------------------
		
		System.out.print("입력할 숫자의 갯수? (100개 미만) : ");
		int num = scanner.nextInt();
		int num2[] = new int[num];
		
		System.out.println(num + "개의 숫자를 입력하세요!");
		int j = 0;
		
		
		//-------------------------------------------------------------------------
		//최대값구하기
		for(int i=0; i<num2.length; i++) {
			num2[i] = scanner.nextInt(); // 입력되었으므로 밑의 for문에서는 재입력할 필요가 없음
			
			if(num2[i]>max) {				
				max = num2[i];
				j=i+1;				
			}
			
		}
		System.out.println("입력한 숫자 중 최대값은 " + max + "이고 " + j + "번째 값 입니다.");
		
		
		//-------------------------------------------------------------------------
		//최소값구하기		
		for(int i=0; i<num2.length; i++) {
						
			if(num2[i]<min) {				
				min = num2[i];
				j=i+1;				
			}
			
		}
		System.out.println("입력한 숫자 중 최소값은 " + min + "이고 " + j + "번째 값 입니다.");
		
		

	}

}
