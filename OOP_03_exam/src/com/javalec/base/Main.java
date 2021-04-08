package com.javalec.base;

import java.util.Scanner;

import com.javalec.function.AddNum;
import com.javalec.function.DivisionNum;
import com.javalec.function.MultiplyNum;
import com.javalec.function.SubtractNum;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력하세요");
		int num1 = scanner.nextInt();
		System.out.println("두번째 숫자를 입력하세요");
		int num2 = scanner.nextInt();
		
		//method의 매개변수로 호출
		System.out.println("----method의 매개변수로 호출----");
		//덧셈
		AddNum addNum = new AddNum();
		int resultNum = addNum.AddAction(num1,num2);
//		System.out.println(resultNum);
		addNum.addPrint(num1,num2); // 결과값을 subclass에서 실행
		
		//뺄셈
		SubtractNum subtractNum = new SubtractNum();
		String resultNum_s = subtractNum.SubAction(num1,num2); // String을 이용함
//		System.out.println(resultNum_s);
		subtractNum.subPrint(num1,num2); // 결과값을 subclass에서 실행
		
		//곱셈
		MultiplyNum multiplyNum = new MultiplyNum();
		multiplyNum.MulAction(num1,num2);

		//나눗셈
		DivisionNum divisionNum = new DivisionNum();
		divisionNum.divAction(num1,num2);

		
		
		
		// Constructor로 호출
		System.out.println("----Constructor로 호출----");
		//덧셈
		
		AddNum addNum2 = new AddNum(num1,num2);
		int resultnum2 = addNum2.addAction2();
		System.out.println(resultnum2);
		
		
		//뺄셈
		SubtractNum subtractNum2 = new SubtractNum(num1,num2);
		String resultNum_s2 = subtractNum2.SubAction2();
		System.out.println(resultNum_s2);
		
		//곱셈
		MultiplyNum multiplyNum2 = new MultiplyNum(num1,num2);
		multiplyNum2.MulAction2();
//		System.out.println(resultNum_m2);
		
		//나눗셈
		DivisionNum divisionNum2 = new DivisionNum(num1,num2);
		divisionNum2.divAction2();
//		System.out.println(resultNum_d2);
		
		
	}

}
