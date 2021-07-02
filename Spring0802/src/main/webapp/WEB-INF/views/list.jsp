<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객명단 리스트 검색</title>
</head>
<body>
	<h3>MyBatis 고객명단 리스트 검색</h3>
		

	<form action="listQuery" method="post">
		검색선택 : 
		<select name="query">
			<!-- MyBatis를 쓰므로 value 값은 대문자로 -->
			<option value="ADDRESS">주소</option>
			<option value="RELATION">관계</option>
		</select> &nbsp;&nbsp;&nbsp;
		<input type="text" name="CONTENT" size="30">
		<input type="submit" value="검색">
	</form>
	
	
	
	<table border="1">
		<tr>
			<th>번호</th><th>이름</th><th>전화번호</th><th>주소</th><th>이메일</th><th>관계</th>
		</tr>
	<c:set var="cnt" value="0" /> <!-- int cnt = 0; 갯수를 세기 위함 -->	
	<c:forEach items="${list }" var="contentDto">
		<tr>
			<td><a href="content_view?seq=${contentDto.seq }">${contentDto.seq }</a></td>
			<td>${contentDto.name }</td>
			<td>${contentDto.tel }</td>
			<td>${contentDto.address }</td>
			<td>${contentDto.email }</td>
			<td>${contentDto.relation }</td>
		</tr>
	<c:set var="cnt" value="${cnt=cnt+1 }" />
	</c:forEach>
	</table>

		<br><Br>
		<p>검색 결과는 <b>${cnt }</b>명 입니다.</p>
		
		<a href="write_view">주소록 작성</a>
</body>
</html>