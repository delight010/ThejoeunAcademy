package com.javalec.function;

import java.util.Scanner;

public class Gugu {

	
	//field
	Scanner scanner = new Scanner(System.in);
	public int dan = 0;
	
	
	
	//Constructor
	public Gugu() {
		// TODO Auto-generated method stub
	}
	
	

	//Method
	public void guguDan() {
		System.out.print("구구단을 출력할 숫자를 입력하세요:");
		dan = scanner.nextInt();
		for(int i=1; i<=9; i++) {
			System.out.println(dan + " X " + i + " = " + (dan*i));
		}
	}
	
	
}
