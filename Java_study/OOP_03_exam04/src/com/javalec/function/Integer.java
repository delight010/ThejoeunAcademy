package com.javalec.function;

import java.util.Scanner;



public class Integer {

	
	//Field
	Scanner scanner = new Scanner(System.in);
	int remainder = 0;
	int number = 0;
	int sum = 0;
	
	//Constructor
	// TODO Auto-generated method stub
	
	
	//Method
	public void sumInteger() {
		System.out.print("Enter an integer(0 ~ 9) : " );
		number = scanner.nextInt();
		while(number!=0) {
			remainder = number%10;
			sum += remainder;
			number/=10;
		}
		System.out.println("Sum of digits = " + sum);
	}
	
	
	
	public void sumPrint() {
		System.out.print("Enter an integer(0 ~ 9) : " );
		String number = scanner.next();
		
		for(int i=0; i<=number.length(); i++) {
			sum += Character.getNumericValue(number.charAt(i));
			
			
		}
	 
		
		
	}


}
	
