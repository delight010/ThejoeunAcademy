package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] name = {"James" , "Cathy", "Kenny", "Martin", "Crystal"}; // name 배열 생성(자료형 string)
		int tall[] = new int[name.length]; // tall 배열생성, 자료길이=name배열길이(자료형 int)
		
		int high = 0;						//최대
		String high_name="";				//최대값의 사람
		int low = 1000;						//최소값
		String low_name="";					//최소값의 사람
		int tall_sum=0;						//신장의 합계
		double tall_avg;						//평균신장

		
		Scanner scanner = new Scanner(System.in); // scanner에 입력값 받기
		for(int i=0; i<name.length; i++) { 		  // (i=0)~(name배열길이-1)를 만족할때까지 i++
			System.out.print(name[i] + "의 신장을 입력하세요!"); 
			tall[i] = scanner.nextInt();		  // 배열 tall에 입력값 적용
			tall_sum+= tall[i];					  // tall_sum =신장합계
		}

		
		//--------------------------------------------------------------------
		//평균 구하기
		
		tall_avg = tall_sum/name.length;  			// 평균신장 = 신장합계/name배열길이
		
		

		//---------------------------------------------------------------------
		//최대값 구하기
		for(int i=0; i<tall.length; i++) {			//0부터 (tall배열길이-1)를 만족할 때까지 i++
			if(high<tall[i]) {						//high < tall[i]를 만족할 때
				high = tall[i];						//high값 = tall[i]
				high_name = name[i];				//high_name = name[i]
			}
			
		}
		
		
		
		//----------------------------------------------------------------------
		//최소값 구하기		
		for(int i=0; i<tall.length; i++) {			//0부터 (tall배열길이-1)를 만족할 때까지 i++
			if(low>tall[i]) {						//low > tall[i]를 만족할 때
				low = tall[i];						//low값 = tall[i]
				low_name = name[i];					//low_name = name[i]
			}
		}
		
		
		//-----------------------------------------------------------------------
		//출력
		System.out.println("평균신장은 : " + String.format("%.2f", tall_avg)); 
		System.out.println("가장 큰 학생은" + high_name + "이고" + "그 학생의 키는 " + high);		
		System.out.println("가장 작은 학생은" + low_name + "이고" + "그 학생의 키는 " + low);
	}

}
