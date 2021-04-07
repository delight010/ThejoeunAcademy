package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int[] inputValue = new int[3]; // 배열 inputValue 생성, 배열길이는 3이다.(자료형 정수)
		int tot = 0; // 합계를 저장할 곳 생성(자료형 정수)
		double avg = 0; // 평균을 저장할 곳 생성(자료형 실수)
		
		//----------------------------------------------------------------------------------
		// 사용자로부터 정보 입력 받아서 배열에 넣기
		Scanner scanner = new Scanner(System.in); // 스캔 명령어
				
		System.out.println("계산할 숫자 3개를 넣으세요");
		
		for(int i=0; i<inputValue.length; i++) { // 0부터 배열길이까지
			inputValue[i] = scanner.nextInt();	 // 스캔 명령어로 입력값을 배열에 넣어준다
		}
		
		//----------------------------------------------------------------------------------
		// 입력한 정보의 합계 구하기
		for(int i=0; i<inputValue.length; i++) { // 0부터 배열길이까지
			tot += inputValue[i];				 // 배열값을 0부터 배열길이(3)까지 불러와서 합산한다.
		}
		
		
		//----------------------------------------------------------------------------------
		// 입력한 정보의 평균 구하기
		avg = (double)tot / inputValue.length; // 평균:합산된 숫자(tot)를 배열길이로 나눈다.
			
		
		//----------------------------------------------------------------------------------
		// 입력한 정보 출력하기
		System.out.println("귀하가 입력한 정보는 다음과 같습니다");
		System.out.println("---------------------------");
		
		for(int i=0; i<inputValue.length; i++) {	// 0부터 배열길이까지
			System.out.print(inputValue[i] + "\t"); // 스캔명령어로 배열에 넣은 값을 출력한다.
		}
		System.out.println();
		System.out.println("입력한 정보의 총합은 " + tot + "입니다."); // 합계값을 출력한다.
		System.out.println("입력한 정보의 평균은 " + String.format("%10.3f", avg) + "입니다.");
		// 평균값은 공란은 10주고 소숫점은 3자리까지 출력한다.
		

	}

}
