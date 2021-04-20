package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 10;
		int j = 0;
		
		System.err.println("Add : " + (i+j));
		System.err.println("Sub : " + (i-j));
		System.err.println("Mul : " + (i*j));
		try {
			System.err.println("Div : " + (i/j));			
		}catch(Exception e) { // int i와 같은 변수
//			System.out.println(e.getMessage());
			System.out.println("숫자를 확인하세요!");
		}
		
	}

}
