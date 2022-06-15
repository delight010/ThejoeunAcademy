package com.springlec.base0801.dao;

import java.util.ArrayList;

import com.springlec.base0801.dto.ContentDto;

//우리가 아는 그 dao가 아니라 간단한 dao일 것이다.
public interface IDao {
	
	
	// 전체검색 (전체 내용 보기)
	public ArrayList<ContentDto> listDao();
	
	// 입력
	public void writeDao(String mWriter, String mContent);
	
	
	// 삭제
	public void deleteDao(String mId);
	
} // IDao
