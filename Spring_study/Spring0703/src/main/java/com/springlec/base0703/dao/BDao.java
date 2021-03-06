package com.springlec.base0703.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0703.dto.BDto;
import com.springlec.base0703.util.Constant;

public class BDao {

	DataSource dataSource;
	// servlet-context.xml 에서 만들어준 template
	private JdbcTemplate template;
	
	public BDao() {
		this.template = Constant.template;
	}
	
	
	// 초기화면 리스트(검색)
	public ArrayList<BDto> list(){
		//2줄로 줄이기
		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
		//ArrayList return 
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
		//5줄로 줄이기
//		ArrayList<BDto> dtos = null;		
//		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";		
//		template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//	    dtos = (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//		return dtos;
		
	}
	
	
	
	// 게시글 내용 보기 
	public BDto content_View(int id) {
		String query = "SELECT * FROM mvc_board WHERE bId = " + id;
		//BDto return ( 1개만 리턴) queryForObject
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));

	}
	
	
	// 글작성
	public void write(final String bName, final String bTitle, final String bContent) { // Dao에서 바꿀 수 없음		
		// 짧게 줄이기
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values (?,?,?,now())";
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, bName);
				preparedStatement.setString(2, bTitle);
				preparedStatement.setString(3, bContent);
				
				return preparedStatement;
			}
		});
		
	}
	
	
	// 글 수정
	public void edit(final int id, final String bName, final String bTitle, final String bContent) { // Dao에서 바꿀 수 없음
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?, bDate = now() where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, id);
				
			}
		});
	}
	
	
	// 글 삭제
	public void delete(final int id) {
		String query = "delete from mvc_board where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, id);				
			}
		});
	}
	
	
	
}
