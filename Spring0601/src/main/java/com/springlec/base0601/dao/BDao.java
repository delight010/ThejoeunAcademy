package com.springlec.base0601.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.base0601.dto.BDto;

public class BDao {
	
	DataSource dataSource;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// 초기화면(검색)
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}

	
	// 글작성	
	public void write(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "INSERT INTO mvc_board (bName, bTitle, bContent, bDate) values (?, ?, ?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 게시글 내용 보기
	public BDto contentView(String strId) {
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection(); 
			String query = "SELECT * FROM mvc_board WHERE bId = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strId));
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {//1번만 실행하기 위해 if문
				int bId = resultSet.getInt("bId"); // DB에서 불러오기, ==int bId = resultSet.getInt("1");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate"); //java.sql
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate); // ArrayList 생성
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close(); // 실행이 잘되었다면, 실행종료
				if(preparedStatement!=null) preparedStatement.close(); // 실행이 잘되었다면, 실행종료
				if(connection != null) connection.close(); //실행이 잘되었다면, 실행종료
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dto;
	}	
	
	
	//게시글 수정
	public void edit(String bName, String bTitle, String bContent, String strID) {
		
		Connection connection = null;// java.sql
		PreparedStatement preparedStatement = null; // java.sql
				
		try {
			connection = dataSource.getConnection(); // 연결
			
			String query = "update  mvc_board  set bName=?, bTitle=?, bContent=?, bDate=now() where bId = ?"; // 쿼리문 작성
			preparedStatement = connection.prepareStatement(query);
						
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(strID));
			
			
			preparedStatement.executeUpdate(); // update 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null) preparedStatement.close(); // 실행이 잘되었다면, 실행종료
				if(connection != null) connection.close(); //실행이 잘되었다면, 실행종료
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	// 글삭제
		public void delete(String strID) {
			
			Connection connection = null;// java.sql
			PreparedStatement preparedStatement = null; // java.sql
					
			try {
				connection = dataSource.getConnection(); // 연결
				
				String query = "delete from mvc_board where bId = ?"; // 쿼리문 작성
				
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(strID));
							
				preparedStatement.executeUpdate(); // update 실행
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement!=null) preparedStatement.close(); // 실행이 잘되었다면, 실행종료
					if(connection != null) connection.close(); //실행이 잘되었다면, 실행종료
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
	
	
	
	
} // BDao
