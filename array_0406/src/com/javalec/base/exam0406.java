package com.javalec.base;

import java.util.Scanner;

public class exam0406 {

	public static void main(String[] args) {
		
		int host[] = new int [5]; //고객정보 및 계좌
		int doIt = 0;
		int account = 0;
		int money = 0;
	
	//--------------------------------------------
	
	Scanner scanner = new Scanner(System.in);
	
	while(doIt!=4) {
	System.out.println("1.입금");
	System.out.println("2.출금");
	System.out.println("3.현황");
	System.out.println("4.종료");
	System.out.print("번호를 선택하세요! "); // 
	
	doIt = scanner.nextInt(); // 실행할 번호 입력
	
	//-------------------------------------------
	
		if(doIt==1) {
			System.out.print("고객번호 : "); 
			account = scanner.nextInt(); //고객 계좌 입력
			
			System.out.print("금액 : ");
			money = scanner.nextInt(); // 금액 입력
			
			host[account-1] += money; // 계좌 입금
			
			System.out.println("입금 결과 : 고객번호 : " + account + "잔액 : " + host[account-1]);
			System.out.println("--------------------------------------------");
		}else if(doIt==2){
			System.out.print("고객번호 : "); 
			account = scanner.nextInt(); //고객 계좌 입력
			
			System.out.print("금액 : ");
			money = scanner.nextInt(); //금액 입력
			
			if(host[account-1]<money) { // 계좌잔액<출금금액
			System.out.println("잔액이 부족합니다!");
			
			}else {
				host[account-1] -= money; // 계좌 출금
				System.out.println("입금 결과 : 고객번호 : " + account + "잔액 : " + host[account-1]);
			}
			
			System.out.println("--------------------------------------------");
		}else if(doIt==3) {
			System.out.println("고객명" + "\t" + "잔액");
			System.out.println("----" + "\t" + "----");
			for(int i = 0; i<5; i++) {
				
				System.out.println((i+1) + "   " + String.format("%7d", host[i]) );
			}
			System.out.println("--------------------------------------------");
		}
		
	
	}
	System.out.println(">>>>> Thank you <<<<<");
	
	

	}

}
