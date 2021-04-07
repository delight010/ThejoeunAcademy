package com.javalec.base;

import java.util.Scanner;

public class array_07 {

	public static void main(String[] args) {
		int kor[] = new int[4];
		int eng[] = new int[4];
		int math[] = new int[4];
		
		int total[] = new int[4];
		int aver[] = new int[4];
		
		//---------------------------------------------------
		//성적 입력(kor)
		Scanner scanner = new Scanner(System.in);
		System.out.println("Korean의 성적을 입력 : ");
		for(int i=0; i<kor.length; i++) {
			System.out.print("No" + (i+1) + "의 성적은 : ");
			kor[i] = scanner.nextInt();
		}


		//성적 입력(eng)
		System.out.println("English의 성적을 입력 : ");
		for(int i=0; i<eng.length; i++) {
			System.out.print("No" + (i+1) + "의 성적은 : ");
			eng[i] = scanner.nextInt();
		}
		
		
		
		//성적 입력(math)
		System.out.println("Mathmatics의 성적을 입력 : ");
		for(int i=0; i<math.length; i++) {
			System.out.print("No" + (i+1) + "의 성적은 : ");
			math[i] = scanner.nextInt();
		}
		
		//------------------------------------------------
		//출력
		System.out.println("\t" + "Korean" + "\t" + "English" + "\t" + "Mathmatics" + "\t" + "Total" + "\t" + "Average");
		for(int i=0; i<=3; i++) {
			for(int j=0; j<=3; j++) {
				total[j] = kor[j]+eng[j]+math[j];
				aver[j] = (kor[j]+eng[j]+math[j])/3;
			}
			System.out.println("No" + (i+1) + "\t" + kor[i] + "\t" + eng[i] + "\t" + math[i] + "\t" + "\t" + total[i] + "\t" + aver[i]);
			
		}
		
		
		
		
		
	}

}
