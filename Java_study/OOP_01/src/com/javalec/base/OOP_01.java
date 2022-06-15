package com.javalec.base;

public class OOP_01 {

	public static void main(String[] args) {
		// 1~10까지의 합을 구하여 출력하고, 그 합이 짝수인지 홀수인지 판단
		
		int sum = 0;
		
		//합계
		for(int i=1; i<=10; i++) {
			sum+=i;
		}
		System.out.println("1~10의 합 : " + sum);
		
		
		//출력
		if(sum%2==0) {
			System.out.println("짝수입니다.");
		}else {
			System.out.println("홀수입니다.");
		}
	
	}

}
