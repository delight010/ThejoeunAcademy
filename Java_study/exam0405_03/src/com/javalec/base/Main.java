package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
				
		System.out.print("입력할 숫자의 갯수? : ");
		int number = scanner.nextInt();
		int array[] = new int[100];
		int search = 0;
		int s_num = 0;
		
		System.out.println(number + "개의 숫자를 입력하세요!:");
		for(int i=1; i<=number; i++) {
			System.out.print(i + "의 숫자 : ");
			array[i-1] = scanner.nextInt();
		}
		
		
		
		System.out.print("검색할 숫자는? : ");
		search = scanner.nextInt();
		
		for(int i =0; i<=number; i++) {
			
			if(search==array[i]) {
				System.out.println(search + "의 위치는" + (i+1) + "입니다.");
			}else {
				System.out.println(search + "는 존재하지 않습니다");
				break;
			}
		}
		
		
		//-----------------------------------------다른 방법
		
		String message = "는 존재하지 않습니다.";
		for(int data =0; data<number; data++) {
			if(array[data]==search) {
				message = (search + "의 위치는 " + (data+1) + "번째 입니다.");
				break;
			}
			System.out.println(message);
		}
		
		
	}

}
