<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String url_mysql = "jdbc:mysql://localhost/atsuMori?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
 	String id_mysql = "root";
 	String pw_mysql = "qwer1234";
    int count = 0;
    String WhereDefault = "select name, gender, chara, birth from moriList where code=1";
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
        Statement stmt_mysql = conn_mysql.createStatement();

        ResultSet rs = stmt_mysql.executeQuery(WhereDefault); // 
%>
		
<%
        while (rs.next()) {
            if (count == 0) {

            }else{
%>
            
<%
            }
%>            
			{
			"name" : "<%=rs.getString(1) %>",
			"gender" : "<%=rs.getString(2) %>",
			"chara" : "<%=rs.getString(3) %>",
			"birth" : "<%=rs.getString(4) %>"
			}

<%		
        count++;
        }
%>
		  
		
<%		
        conn_mysql.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
	
%>
