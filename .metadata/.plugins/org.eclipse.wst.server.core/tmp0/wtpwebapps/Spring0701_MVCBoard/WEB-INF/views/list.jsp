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

	<table border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			</tr>
			<c:forEach items="${list }" var = "dtos">
			<tr>
			<td>${dtos.bId }</td>
			<td>${dtos.bName }</td>
			<td><a href="content_view?bId=${dtos.bId }">${dtos.bTitle }</a></td>
			<td>${dtos.bDate }</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><a href="write_view">글작성</a></td>
			</tr>
	
	
	</table>

</body>
</html>