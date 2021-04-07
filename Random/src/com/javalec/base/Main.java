package com.javalec.base;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Random
		
//		for(int i=1; i<=6; i++) {
//		double d = Math.random();
//		int a = (int)(d*3) + 1;
//		System.out.println(a);
//		}
		Scanner scanner = new Scanner(System.in);
		
//		Random random = new Random();
//		int i = random.nextInt(3);
//		System.out.println(i+1);
		
		
		
		//----------------------
		//가위바위보
		Random random2 = new Random();
		int j = random2.nextInt(2);
		
		String str[] = {"가위","바위","보"};
		
		
		System.out.print("가위바위보!!:");
		String me = scanner.nextLine();
		System.out.println("You:" + me);
		System.out.println("Computer:" + str[j]);
		if(me == str[j]) {
			System.out.println("비겼습니다");
		}else if(me=="가위" && str[j]=="바위") {
			System.out.println("You Lose");			
		}else if(me=="바위" && str[j]=="보"){
			System.out.println("You Lose");
		}else if(me=="보" && str[j]=="가위") {
			System.out.println("You Lose");
		}else if(me=="가위" && str[j]=="보") {
			System.out.println("You Win");
		}else if(me=="바위" && str[j]=="가위"){
			System.out.println("You Win");
		}else if(me=="보" && str[j]=="바위") {
			System.out.println("You Win");
		}else {
			
		}
			
		
		
		
	}

}
