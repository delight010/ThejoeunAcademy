package com.springlec.base0802.dao;

import java.util.ArrayList;

import com.springlec.base0802.dto.ContentDto;

public interface IDao {
	
	// 전체검색 (전체 내용 보기)
		public ArrayList<ContentDto> listDao();
		
		// 입력
		public void writeDao(String name, String tel, String address, String email, String relation);
		
		// 내용 보기
		public ContentDto contentViewDao(int seq);
		
		// 수정
		public ContentDto editDao(int seq, String name, String tel, String address, String email, String relation);
		
		
		// 삭제
		public void deleteDao(String mId);
		
		// 검색
		public ArrayList<ContentDto> listQuery(String query, String content);

}
