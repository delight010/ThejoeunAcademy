package com.javalec.base;

public class APhone implements SmartPhone {

	@Override
	public void callSenderReceiver() {
		System.out.println("A Phone : Possible");
	}

	@Override
	public void telMethod() {
		System.out.println("A Phone : 3G");
	}

	@Override
	public void tvRemoteController() {
		System.out.println("A Phone : Not Applied");
	}

}
