package com.javalec.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		//ArrayList
		ArrayList<String> arrayList = new ArrayList<String>(); //<자료형>
		
		System.out.println("<<< ArryaList>>>");
		//ArrayList에 Data추가
		arrayList.add("str1");
		arrayList.add("str2");
		arrayList.add("str3");
		arrayList.add("str4");
		
		System.out.println(arrayList);

		//ArrayList의 Data 불러오기
		String str1 = arrayList.get(3);
		System.out.println("Index 3 : " + str1);
		
		//ArrayList의 특정 index의 data를 수정하기
		arrayList.set(1, "str2222");
		System.out.println(arrayList);
		
		//ArrayList의 크기 확인하기
		int size = arrayList.size();
		System.out.println("Size : " + size);
		
		//ArrayList의 내용 삭제하기
		arrayList.remove(1);
		System.out.println(arrayList);
		arrayList.remove("str4");
		System.out.println(arrayList);
		
		//ArrayList의 내용 전부 초기화하기
		arrayList.clear();
		System.out.println(arrayList);
		
		//----------------------------------------------------------------------
		
		//Linked List
		LinkedList<String> linkedList = new LinkedList<String>();
		System.out.println(">>>Linked List<<<");
		linkedList.add("str1");
		linkedList.add("str2");
		linkedList.add("str3");
		linkedList.add("str4");
		
		System.out.println(linkedList);
		
		//LinkedList의 Data 불러오기
		String str11 = linkedList.get(3);
		System.out.println("Index 3 : " + str11);
		
		//LinkedList의 특정 index의 data를 수정하기
		linkedList.set(1, "str2222");
		System.out.println(linkedList);
		
		//LinkedList의 크기 확인하기
		int size1 = linkedList.size();
		System.out.println("Size : " + size1);
		
		//LinkedList의 내용 삭제하기
		linkedList.remove(1);
		System.out.println(linkedList);
		linkedList.remove("str4");
		System.out.println(linkedList);
				
		//LinkedList의 내용 전부 초기화하기
		linkedList.clear();
		System.out.println(linkedList);
		
		
		//----------------------------------------------------------------------
		
		//Vector
		Vector<String> vector = new Vector<String>();
		System.out.println(">>>Vector List<<<");
		vector.add("str1");
		vector.add("str2");
		vector.add("str3");
		vector.add("str4");
		
		System.out.println(vector);
		
		//Vector의 Data 불러오기
		String str111 = vector.get(3);
		System.out.println("Index 3 : " + str111);
			
		//Vector의 특정 index의 data를 수정하기
		vector.set(1, "str2222");
		System.out.println(vector);
				
		//Vector의 크기 확인하기
		int size11 = vector.size();
		System.out.println("Size : " + size11);
		
		//Vector의 내용 삭제하기
		vector.remove(1);
		System.out.println(vector);
		vector.remove("str4");
		System.out.println(vector);
						
		//Vector의 내용 전부 초기화하기
		vector.clear();
		System.out.println(vector);
		
		
		
	}

}
