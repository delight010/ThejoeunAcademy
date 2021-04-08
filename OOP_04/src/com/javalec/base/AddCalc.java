package com.javalec.base;

public class AddCalc {
	
	//Field
	
	
	//Constructor
	public AddCalc() {
		// TODO Auto-generated method stub
	}
	
	//Method
	public int[] sumCalc(int[] arr) {
		int[] incNum = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			incNum[i] = arr[i] +1;
		}
		return incNum;
	}

}
