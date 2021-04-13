package com.javalec.base;

public class Shop01 extends StoreHQ {
	
	//Field
	
	
	//Constructor
	public Shop01() {
		// TODO Auto-generated constructor stub
	}
	
	//Method
	@Override
	public void orderKim() { // 오버라이딩 : orderKim + ctrl + space
		System.out.println("김치찌개 : 4,500원");
	}
	
	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 5,000원");
	}
	
	@Override
	public void orsderSoon() {
		System.out.println("순대국 : 판매하지 않습니다.");
	}
	
	
	
	

}
