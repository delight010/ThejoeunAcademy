package com.javalec.base;

import java.util.HashMap;

public class Hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashMap
		HashMap<Integer,String> hashMap = new HashMap<Integer, String>();
		
		//HashMap에 data 넣기(정수,문자열)
		hashMap.put(10, "str0");
		hashMap.put(11, "str1");
		hashMap.put(21, "str2");
		hashMap.put(31, "str3");
		
		System.out.println(hashMap);
		//출력결과
		//{21=str2, 10=str0, 11=str1, 31=str3}
		System.out.println(hashMap.get(11));
		//출력결과
		//str1
		
		
		//----------------------------------------------------------------
		HashMap<String, String> hashMap2 = new HashMap<String, String>();
		//HashMap2에 data 넣기 (문자열,문자열)
		hashMap2.put("a", "apple");
		hashMap2.put("b", "banana");
		hashMap2.put("c", "coke");
		System.out.println(hashMap2);
		//출력결과
		//{a=apple, b=banana, c=coke}
		System.out.println(hashMap2.get("c"));
		//출력결과
		//coke
		
		hashMap2.remove("a");
		System.out.println(hashMap2);
		//출력결과
		//{b=banana, c=coke}
		
		hashMap2.clear(); //전체삭제
		
		
	}

}
