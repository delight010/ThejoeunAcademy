<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<table border="1">
	<tr>
	<td>이름</td>
	<td><input type="text" name="bName" size="50" value="${content.bName }"><input type="hidden" name="bId" size="50" value="${content.bId }"></td>
	</tr>
	<tr>
	<td>제목</td>
	<td><input type="text" name="bTitle" size="50" value="${content.bTitle }"></td>
	</tr>
	<tr>
	<td>내용</td>
	<td><textarea name="bContent" rows="10">${content.bContent }</textarea></td>
	</tr>
	<tr>
	<td colspan="2"><input type="submit" value="완료">&nbsp; &nbsp;<a href="list">돌아가기</a> </td>
	</tr>
	
</table>
</form>
</body>
</html>