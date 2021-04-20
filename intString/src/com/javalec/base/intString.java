package com.javalec.base;

public class intString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 123;
		String str1 = "12345";
		String str2 = "abcde";
		
		String str3 = Integer.toString(num1); // 정수->문자열로
		System.out.println(str3 + str1); // 12312345
		
		int num2 = Integer.parseInt(str1); // 문자열->정수
		System.out.println(num1+num2); // 12468
		
	}

}
