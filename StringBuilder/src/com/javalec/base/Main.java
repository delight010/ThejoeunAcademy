package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		// String의 문제점을 해결하기 위해 나온 문자열 선언들
		String string = new String("abcdef");
		
		StringBuilder stringBuilder = new StringBuilder("abcdef");
		stringBuilder.append("hijklmn"); // 끝에 hijklmn 추가
		System.out.println(stringBuilder);
		
		stringBuilder.insert(3, "zzz"); // 4번째에 zzz 추가
		System.out.println(stringBuilder);
		
		stringBuilder.delete(3,6); // 4번째부터 6번째까지 삭제
		System.out.println(stringBuilder);
		
		//-----------------
		
		StringBuffer stringBuffer = new StringBuffer("abcdef");
		
		stringBuffer.append("hijklmn"); // 끝에 hijklmn 추가
		System.out.println(stringBuffer);
		
		stringBuffer.insert(3, "zzz"); // 4번째에 zzz 추가
		System.out.println(stringBuffer);
		
		stringBuffer.delete(3,6); // 4번째부터 6번째까지 삭제
		System.out.println(stringBuffer);

	}

}
