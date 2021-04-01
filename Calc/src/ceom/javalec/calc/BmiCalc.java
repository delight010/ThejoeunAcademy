package ceom.javalec.calc;

import java.util.Scanner;

public class BmiCalc {

	public static void main(String[] args) {
		Scanner Bmi_kg = new Scanner(System.in), Bmi_tall = new Scanner(System.in);
		
				
		System.out.println("몸무게를 입력하세요");
		int kg = Bmi_kg.nextInt();
		System.out.println("키를 입력하세요");
		int tall = Bmi_tall.nextInt();
		int Bmi = kg / tall * tall;
		
		System.out.println("당신의 BMI는 " + Bmi + "입니다.");
		if(Bmi>=40) {
			System.out.println("당신은 고도비만입니다.");
		}else if(Bmi>=35) {
			System.out.println("당신은 경도비만입니다.");
		}else if(Bmi>=20) {
			System.out.println("당신은 표준입니다.");
		}else if(Bmi>=0) {
			System.out.println("당신은 표준이하입니다.");
		}else {
			System.out.println("수치가 잘못되었습니다.");
		}
				
		
	}

}
