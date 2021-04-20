package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		
		int tot = 0;
		
//		for(int i=1; i<=100; i++) {
//			tot +=i;
//		}
		
		int i = 1;
		
		
//		while(i<=100) {
//			tot+=i;
//			i++;
//		}
		
		
		
		
//		while(true) {
//			tot+=i;
//			i++;
//			if(i>=100) {
//				break;
//			}
//		}
//		
//		System.out.println(tot);
		
		
		
		while(true) {
			if(i%2==1) {
				System.out.println(i);
			}else {
				continue;
			}
			i++;
			
			if(i>10) {
				break;
			}
		}
		
		
		
		
		
		
		
		
		
	}

}
