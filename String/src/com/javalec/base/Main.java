package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String str = "Hello";
		String str1 = "abcdefg";
		String str2 = "HIJKLMN";
		String str3 = "opqrstu";
		String str4 = " abc def ghi";
		
		
		System.out.println(str1.concat(str2)); // concat=글자를 이어주는 메소드
		//abcdefgHIJKLMN
		System.out.println(str1.substring(3)); // substring=str[3]번째부터 출력
		//defg
		System.out.println(str1.substring(3, 5)); // substring=[3~4] 출
		//de
		System.err.println(str1.length()); // length 글자갯수확인
		System.out.println(str1.toUpperCase()); // 대문자로 변환
		System.out.println(str2.toLowerCase()); // 소문자로 변환
		System.out.println(str1.charAt(3)); // 문자열에서 문자 하나씩 뽑아내기
		//d(소문자)
		
		//str1을 알파벳 하나씩 출력하기
		for(int i=0; i<str1.length(); i++) {
			System.out.println(str1.charAt(i));
		}
		
		System.out.println(str1.indexOf('c'));
		System.out.println(str1.equals(str3)); // str1과 str3가 같은가
		System.out.println(str4.trim());
		System.out.println(str.replaceAll("abc", "ZZZ"));
		System.out.println(str1);
		

	}

}
