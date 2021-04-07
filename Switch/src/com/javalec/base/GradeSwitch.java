package com.javalec.base;

import java.util.Scanner;

public class GradeSwitch {

	public static void main(String[] args) {
		Scanner inputGrade = new Scanner(System.in);
		int score = 0;
		String gradeResult = "";
		
	
		System.out.println("성적을 입력하세요");
		score = inputGrade.nextInt(); // 성적 입력	)
			if(score<0 || score>100) {
				System.out.println("다시 입력해 주세요");
				}else {
					switch(score / 10 ) {
						case(10) :
						case(9) :
							gradeResult = "A";
							break;
						case(8) : 
							gradeResult = "B";
							break;
						case(7) :
							gradeResult = "C";
							break;
						case(6) :
							gradeResult = "D";
							break;
						default :
							gradeResult = "F";
							break;
						}
					System.out.println("귀하의 성적은 " + gradeResult + "입니다");
				}
		}
	}
