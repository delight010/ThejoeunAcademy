package com.springlec.base0801.dto;

public class ContentDto {
	
	private int mId;
	private String mWriter;
	private String mContent;
	
	// 빈 생성자
	public ContentDto() {
		super();
	}


	// 생성자
	public ContentDto(int mId, String mWriter, String mContent) {
		super();
		this.mId = mId;
		this.mWriter = mWriter;
		this.mContent = mContent;
	}


	// Getters and Setters
	public int getmId() {
		return mId;
	}


	public void setmId(int mId) {
		this.mId = mId;
	}


	public String getmWriter() {
		return mWriter;
	}


	public void setmWritre(String mWriter) {
		this.mWriter = mWriter;
	}


	public String getmContent() {
		return mContent;
	}


	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	
	

} // ContentDto
