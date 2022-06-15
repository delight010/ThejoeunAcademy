package ceom.javalec.calc;

import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {

		// 사용자의 입력 데이터 받기
		Scanner scanner = new Scanner(System.in);
		String str      = "abc";
		
		System.out.print("숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		System.out.println("사용자 입력 숫자는 " + num + "입니다.");
		
		/*
		 *  Exercise
		 *  숫자를 입력해 주세요 : 12
		 *  입력하신 숫자는 3의 배수입니다.
		 *  
		 *  숫자를 입력해 주세요 : 12
		 *  입력하신 숫자는 3의 배수가 아닙니다.
		 *  
		 */
		
		Scanner doublee = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num2 = doublee.nextInt();
		System.out.println(num2%2==0 ? "입력하신 숫자는 3의 배수입니다." : "입력하신 숫자는 3의 배수가 아닙니다");
		
		
	}

}
