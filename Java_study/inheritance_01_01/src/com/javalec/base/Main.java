package com.javalec.base;

import com.javalec.function.DmbCellPhone;

public class Main {

	public static void main(String[] args) {
		
		// DmbCellPhone의 Instance를 생성
		//클래스 + 인스턴스이름 = new 생성자(한줄로 할 때)
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰","검정",10);
		
		
		//두 줄로 할때
		//--------------
		//DmbCellPhone dmbCellPhone = new DmbCellPhone();
		//dmbCellPhone.model = "자바폰";
		//dmbCellPhone.color = "검정";
		//dmbCellPhone.channel = 10;
		//--------------
		
		
		
		
		
		System.out.println("모델 : " + dmbCellPhone.model);
		System.out.println("색상 : " + dmbCellPhone.color);
		System.out.println("채널 : " + dmbCellPhone.channel);
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동인데요");
		dmbCellPhone.sendVoice("아! 반갑습니다 그럼 안녕히~~~");
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
		

	}

}
