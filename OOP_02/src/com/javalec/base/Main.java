package com.javalec.base;

import com.javalec.function.SumEvenOdd;
import com.javalec.function.SumEvenOdd2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i=1, j=10;
		
//		SumEvenOdd sumEvenOdd = new SumEvenOdd(); // class는 ()가 없음
//		int sum = sumEvenOdd.sumCalc(i, j);
//				
//		String chk = sumEvenOdd.evenOdd(sum);
//		
//		System.out.println(i + " ~ " + j + "의 합은 " + sum + "입니다.");
//		System.out.println(chk + "입니다.");
		
		
		SumEvenOdd2 seo = new SumEvenOdd2();
		seo.sumCalc(i,j);
		seo.evenOdd();
		
		
		
	}
	
	
	

}
