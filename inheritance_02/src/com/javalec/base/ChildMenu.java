package com.javalec.base;

public class ChildMenu extends ParentsMenu {

	// Field
	
	
	
	// constructor
	public ChildMenu() {
		// TODO Auto-generated constructor stub
	}
	
	
	// method
	public void makeBeefChung() {
		System.out.println("소고기 청국장");
	}
	
	public void makeHotDoen() {
		System.out.println("얼큰 된장");
	}
	
	@Override
	public void makeChung() { // Parents의 메소드 사용
		// TODO Auto-generated method stub
		// super.makeChung();
		System.out.println("냄새 없는 청국장");
	}
	
	
	
	
} //-----
