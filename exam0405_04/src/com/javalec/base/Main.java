package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int array[] = new int[100];
		int insert = 0;
		
		System.out.print("입력할 숫자의 갯수? : "); // 숫자 갯수 입력
		int counter = scanner.nextInt();
		for(int i=0; i<counter; i++) {
			System.out.print(i+"의 숫자 :"); // 배열에 숫자 적용
			array[i] = scanner.nextInt();
		}
		
		System.out.print("숫자를 삽입하고자 하는 위치는 ? :"); // 위치 선정
		int place = scanner.nextInt();
		System.out.print("삽입하고자하는 숫자는? : "); // 넣을 숫자 선정
		int number = scanner.nextInt();
		
		
		for(int i =counter; i>=place; i--) {
			array[i]=array[i-1];
		}
		
		array[place-1] = number;
		
		System.out.println("---------결과----------");
		
		for(int i = 0; i<=counter; i++) {
			System.out.println(array[i]);
		}
		
	}

}
