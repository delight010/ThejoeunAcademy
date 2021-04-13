package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StoreHQ storeHQ = new StoreHQ();
		Shop01 shop01 = new Shop01();
		StoreHQ shop02 = new Shop02();
		StoreHQ shop03 = new Shop03();
		
		
		System.out.println("HQ---------------");
		storeHQ.orderKim();
		storeHQ.orderBu();
		storeHQ.orderBi();
		storeHQ.orsderSoon();
		storeHQ.orderKong();
		
		System.out.println("Shop1---------------");
		shop01.orderKim();
		shop01.orderBu();
		shop01.orderBi();
		shop01.orsderSoon();
		shop01.orderKong();
		
		System.out.println("Shop2---------------");
		shop02.orderKim();
		shop02.orderBu();
		shop02.orderBi();
		shop02.orsderSoon();
		shop02.orderKong();
		System.out.println("Shop3---------------");
		shop03.orderKim();
		shop03.orderBu();
		shop03.orderBi();
		shop03.orsderSoon();
		shop03.orderKong();
		
		System.out.println("===========짧은 명령어로 출력============");
		
		StoreHQ[] store = {storeHQ, shop01, shop02, shop03};
		
		for(int i=0; i<store.length; i++) {
			store[i].orderKim();
			store[i].orderBu();
			store[i].orderBi();
			store[i].orsderSoon();
			store[i].orderKong();
			System.out.println(store[i] + "-------------------");
			
		}
		

	}

}
