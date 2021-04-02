package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		// 10^0부터 10^10까지 나타내기
		
		int num = 10;
		long num2 = 1;
		
		for(int i=0; i<=10; i++) {
			for(int j=0; j<=i; j++) {
				
				num2 *= 10;
				
			}
			System.out.println(num + " ^ " + String.format("%2d",i) + " = " + String.format("%20d", num2)  );
			num2 = 1;
		}

	}

}
