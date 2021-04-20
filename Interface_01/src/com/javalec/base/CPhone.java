package com.javalec.base;

public class CPhone implements SmartPhone {

	@Override
	public void callSenderReceiver() {
		System.out.println("C Phone : Possible");
	}

	@Override
	public void telMethod() {
		System.out.println("C Phone : 4G");
	}

	@Override
	public void tvRemoteController() {
		System.out.println("C Phone : Not Applied");
	}


}
