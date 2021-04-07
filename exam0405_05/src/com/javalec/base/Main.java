package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int count;
		int array[] = new int[100];
		int place;
		
		System.out.print("입력할 숫자의 갯수? : ");
		count = scanner.nextInt();
		
		for(int i = 0; i<count; i++) {
			System.out.print((i+1) + "의 숫자 : ");
			array[i] = scanner.nextInt();
		}
		
		
		System.out.print("몇번째의 숫자를 삭제하시겠습니까? : ");
		place = scanner.nextInt();
		
		for(int i=place; i<count; i++) {
			array[place-1] = array[i];
			place++; // ++해줌으로써 기본값(위치값)을 늘려준다.
		}
		
		
		System.out.println("-------결과--------");
		for(int i=0; i<count-1; i++) {
			System.out.println(array[i]);
		}
		

	}

}
