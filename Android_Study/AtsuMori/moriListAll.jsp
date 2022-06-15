<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String url_mysql = "jdbc:mysql://localhost/atsuMori?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
 	String id_mysql = "root";
 	String pw_mysql = "qwer1234";
    String WhereDefault = "select code, profile, name, gender, chara, birth from moriList";
        int count = 0;
    
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
        Statement stmt_mysql = conn_mysql.createStatement();

                ResultSet rs = stmt_mysql.executeQuery(WhereDefault); //
%>
        {
              "moriList_info"  : [
<%
        while (rs.next()) {
            if (count == 0) {

            }else{
%>
            ,
<%
            }
%>
            {
            "code" : "<%=rs.getInt(1) %>",
            "profile" : "<%=rs.getString(2) %>",
            "name" : "<%=rs.getString(3) %>",
            "gender" : "<%=rs.getString(4) %>",
            "chara" : "<%=rs.getString(5) %>",
            "birth" : "<%=rs.getString(6) %>"
            }

<%
        count++;
        }
%>
          ]
        }
<%
        conn_mysql.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
%>
