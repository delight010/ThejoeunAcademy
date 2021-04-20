package com.javalec.base;

public class Shop02 extends StoreHQ {
	
	//Field
	
	
	//Constructor
	public Shop02() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Method
	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 5,000원");
	}
	
	@Override
	public void orderBi() {
		System.out.println("비빔밥 : 5,000원");
	}
	
	@Override
	public void orsderSoon() {
		System.out.println("순대국 : 4,000원");
	}
	
	@Override
	public void orderKong() {
		System.out.println("공기밥 : 무료입니다.");
	}

}
