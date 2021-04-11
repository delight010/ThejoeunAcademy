package com.javalec.base;

import java.util.ArrayList;

public class Main_Collection_exam {

	public static void main(String[] args) {
		
		//1~100까지 수 중 짝수만 골라서 arraylist를 만들고 arraylist를 읽어서 짝수의 합 구하기

		int sum = 0; //합계
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i = 2; i<=100; i+=2) {
			arrayList.add(i); //arrayList 값추가
		}
		
		for(int i=0; i<arrayList.size(); i++) {
			sum += arrayList.get(i); // arrayList값 불러오기
		}
		
		System.out.println(sum); // 1~100 짝수의 합 출력


	}

}
