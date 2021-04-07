package com.javlec.base;

public class For {

	public static void main(String[] args) {
//				System.out.println(1);
//				System.out.println(2);
//				System.out.println(3);
//				System.out.println(4);
//				System.out.println(5);
//				System.out.println(6);
//				System.out.println(7);
//				System.out.println(8);
//				System.out.println(9);
//				System.out.println(10);
//				
//				
//				for(int i = 1; i<=10; i++) {
//					System.out.println(i);
				}
				
				// 1부터 10까지 합계 구하기
//				int tot = 0; // 누적변수
//				for(int i = 1; i<=10; i++) {
//					tot = tot + i;
//				}
//				System.out.println("1부터 10까지의 합은 " + tot + "입니다.");
				
				
				// Exercise
				// 1부터 100까지의 수중 짝수의 합을 구하시오 (단, if문 사용)
				int totEven = 0;
				int totOdd = 0;
				
				for(int i = 1; i<=100; i++) {
					if(i % 2 == 0) {
						totEven += i;
					}else{
						totOdd += i;
					}
				}
				
}
			
}

				
				
			
				
