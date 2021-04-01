package com.javalec.base;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// 비교문 #1
		int i = 10;
		int j = 20;
		int k = 10;
		
//		if(i>j) {
//			System.out.println("i가 j보다 큽니다.");
//				
//			
//		}
//		
//		System.out.println(">>>END<<<");
//
//	}
//


		// 비교문 #2 : 비교문으로 입력한 숫자 크기의 차이 구하기
		
//		if(i>j) {
//			System.out.println("i는 j보다" + (i-j) + "만큼 큽니다.");
//		}else {
//			System.out.println("j는 i보다" + (j-i) + "만큼 큽니다.");
//		}
//		
//		System.out.println(">>> End <<<");
		
		
		
		// 비교문 #3 : 비교문으로 크다, 작다, 같다의 3종료 이상의 비교문
//		if(i<j) {
//			System.out.println("i가 j보다 큽니다.");
//		}else if(i==j) {
//				System.out.println("i와 j 같습니다.");
//		}else {
//			System.out.println("i가 j보다 작습니다.");
//			}
				
		
		
		int price = 5000;
		if(price > 8000) {
			System.out.println("너무 비쌉니다");
			}else if(price>5000) {
				System.out.println("조금 비쌉니다");
			}else if(price > 3000) {
				System.out.println("적당한 금액입니다");
			}else {
				System.out.println("싼편 입니다");
			}
		
		System.out.println("구매 하실래요?");
		
		
		/*
		 * 성적을 입력하세요 : 90
		 * 귀하의 학점은 A학점 입니다. 
		 * 
		 * 성적을 입력하세요 : 80
		 * 귀하으이 학점은 B학점 입니다.
		 * 
		 * 성적을 입력하세요 : 40
		 * 귀하의 학점은 F학점입니다.
		 */

			
//		Scanner Score = new Scanner(System.in);
//		
//		System.out.print("성적을 입력하세요 : ");
//		int Score2 = Score.nextInt();
//	    if(Score2>=90) {
// 	    	System.out.println("귀하의 학점은 A 학점입니다. ");
//	    }else if(Score2>=80) {
// 	    	System.out.println("귀하의 학점은 B 학점입니다. ");
//	    }else if(Score2>=40) {
// 	    	System.out.println("귀하의 학점은 F 학점입니다. ");
//	    }else {
//	    	System.out.println("귀하의 학점은 큰일입니다.");
//	    	
//	    }
		
		
		
		
//		Scanner grade = new Scanner(System.in);
//		
//		System.out.print("성적을 입력하세요 : ");
//		int grade2 = grade.nextInt();
//		String grade3;
//	    if(grade2>=90) {
// 	    	grade3 = "A";
//	    }else if(grade2>=80) {
// 	    	grade3 = "B";
//	    }else if(grade2>=0) {
// 	    	grade3 = "F";
//	    }else {
//	    	grade3 = ("error");
//	    	
//	    
//	    	if(grade3 =="error") {
//	    		System.out.println("점수가 잘못 입력되었습니다.");
//	    	}else {
//	    		System.out.println("귀하의 학점은 " + grade3 + "입니다.");
//	    	
//	    }

		
	    
	    	Scanner grade_korean = new Scanner(System.in);
	    	Scanner grade_english = new Scanner(System.in);
	    	Scanner grade_math = new Scanner(System.in);
	    	
	    	System.out.println("국어 점수를 입력하세요!");
	    	int kor = grade_korean.nextInt();    	
	    	System.out.println("영어 점수를 입력하세요!");
	    	int eng = grade_english.nextInt();
	    	System.out.println("수학 점수를 입력하세요!");
	    	int math = grade_math.nextInt();
	    	int regrade = (kor + eng + math)/3;
	    	
	    	System.out.println("평균점수 : " + regrade);
	    	
	    	if(kor>regrade) {
	    		System.out.println("국어 점수는 평균 보다 높습니다");
	    	}else if(kor==regrade) {
	    		System.out.println("국어 점수는 평균 점수입니다.");
	    	}else {
	    		System.out.println("국어 점수는 평균 보다 낮습니다.");
	    	}
	    	
	    	if(eng>regrade) {
	    		System.out.println("국어 점수는 평균 보다 높습니다");
	    	}else if(eng==regrade) {
	    		System.out.println("국어 점수는 평균 점수입니다.");
	    	}else {
	    		System.out.println("국어 점수는 평균 보다 낮습니다.");
	    	}
	    	
	    	if(math>regrade) {
	    		System.out.println("국어 점수는 평균 보다 높습니다");
	    	}else if(math==regrade) {
	    		System.out.println("국어 점수는 평균 점수입니다.");
	    	}else {
	    		System.out.println("국어 점수는 평균 보다 낮습니다.");
	    	}
	    	
		
		
	    }
	}


	
