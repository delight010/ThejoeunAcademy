package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 10개의 점수(0점부터 00점)을 입력받아 점수의 분포를 10점 간격의 등급으로 된 히스토그램을 표시하라
		Scanner scanner = new Scanner(System.in);
		int[] score = new int[10];
		int[] hist = new int[10];
		
		
		System.out.print("Input score : " + "\n");
		
		for(int i = 0; i<10; i++) {
			System.out.print((i+1) + "의 score : " );	
			score[i] = scanner.nextInt();		
			hist[score[i]/10]++;	// 점수/10의 몫의 배열
			//histo[score[i] / 10]++;  이 부분이 70점일경우 histo[7]번째에 +1을 하라는 뜻
		}
		scanner.close();
		
		
		
		// 출력
		System.out.println("--------Histogram----------");
		for(int j = 90; j>=0; j-=10) {
			System.out.print(String.format("%2d",j) + " : " );
			for(int i=0; i<10; i++) {
				if((j+10)>score[i] && score[i]>=j) {
					System.out.print("#");
					
				}else {
				}
			}
			System.out.println("");
		}
		
		
		//for문만을 사용해서 출력
		System.out.println("--------Histogram----------");
		for(int i = (score.length-1); i>=0; i--) { // i=9부터 시작됨 
			System.out.print(String.format("%2d : ", i*10));
			for(int j = 1; j<=hist[i]; j++) { //hist가 j보다 크면
				System.out.print(hist[i]);
				System.out.print("#");
			}
			System.out.println("");
		}

		
	}

}
