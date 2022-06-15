package com.javalec.variable_03;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10;
		int j = 2, k = 5;
		
		System.out.println("<-- 산술 연산자 -->");
		System.out.println("덧셈:" + i + " + " + j + " = " + (i+j));
		System.out.println("뺄셈:" + i + " - " + j + " = " + (i-j));
		System.out.println("곱셈:" + i + " * " + j + " = " + (i*j));
		System.out.println("나눈 몫:" + i + " / " + j + " = " + (i/j));
		System.out.println("나눈 나머지:" + i + " % " + j + " = " + (i%j));
		
		
		System.out.println("<-- 자동 증감 연산자 -->");
		System.out.println(i+1);
		System.out.println(i);
		i = i+1; // i+=1; , i++;
		System.out.println(i);
		
		j = j-1;
		System.out.println(j);
		j--; // j = j-1; j-= 1;
		System.out.println(j);
		
		System.out.println("<-- 동등 비교 관계 연산자 -->");
		System.out.println("i == j :" + (i==j));
		System.out.println("i != j :" + (i!=j));
		System.out.println("i > j :" + (i>j));
		System.out.println("i < j :" + (i<j));
		System.out.println("i >= j :" + (i>=j));
		System.out.println("i <= j :" + (i<=j));
		
		
		System.out.println("<-- 논리 연산자 -->");
		System.out.println((i>j) && (j>k));
		System.out.println((i>j) || (j>k));
		
		
		System.out.println("<-- 삼항 연산자 -->");
		System.out.println(k==5 ? "k==5" : "k!5");
		
		// Exercise : i가 홀수 인지 짝수 인지 출력하시오
		System.out.println(i%2==0 ? "짝수" : "홀수");
		System.out.println(i%2);
		
	}

}
