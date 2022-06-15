package com.javalec.base;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		//Set
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("a");
		hashSet.add("b");
		hashSet.add("c");
		hashSet.add("d");
		
		System.out.println(hashSet);
		//출력결과
		//[a, b, c, d]


	}
}
