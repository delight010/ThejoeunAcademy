package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		// 배열 call by reference(참조호출)
		int[] array1 = {10, 20, 30, 40 ,50}; // 10,20,30,40,50의 입력값을 받는 배열 array1생성(자료형정수)
		int[] array2 = array1; 				 // array1의 입력값을 받는 array2 배열 생성(자료형 정수)
		
		
		for(int i=0; i<array1.length; i++) {
			System.out.print("array1 : " + array1[i] + "/ \t");
			System.out.println("array2 : " + array2[i]);
		}
		
		
		array2[0] = 100;
		array2[1] = 200;
		array2[2] = 300;
		array2[3] = 400;
		array2[4] = 500;
		
		
		for(int i=0; i<array1.length; i++) {
			System.out.print("array1 : " + array1[i] + "/ \t");
			System.out.println("array2 : " + array2[i]);
		}
		
		
		int[] array3 = new int[array1.length];

		// 배열 call by value (매개변수)
		for(int i=0; i<array1.length; i++) { 
			array3[i] = array1[i];
			
		}
		
		
		for(int i=0; i<array1.length; i++) {
			System.out.print("array1 : " + array1[i] + "/ \t");
			System.out.println("array3 : " + array3[i]);
		}
		
		
	}

}
