package com.javalec.base;

public class main {

	public static void main(String[] args) {
		int num10 = 10;
		double ans = 0;
		for(int i=0; i<=10; i++) {
			ans = Math.pow(num10, i);
			System.out.println(num10 + " ^ " + i + " = " +  ans);
		}

	}
}
