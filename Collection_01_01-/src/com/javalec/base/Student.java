package com.javalec.base;

public class Student {

	//Field
	String name;
	int score;
	
	//constructor
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	
	//method :: source - generate getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
