<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table border="1">
		<form action="edit" method="post">
		<input type="hidden" name="bId" value="${content_view.bId }">
		
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="bName" size="20" value="${content_view.bName }"></td>
			</tr>
			
			<tr>
				<td>����</td>
				<td><input type="text" name="bTitle" size="50" value="${content_view.bTitle }"></td>
			</tr>
			
			<tr>
				<td>����</td>
				<td><textarea rows="10" cols="50" name="bContent">${content_view.bContent }</textarea></td>  <!--  ���� �� --> 
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="����">&nbsp;&nbsp;&nbsp;<a href="list">��Ϻ���</a>
				&nbsp;&nbsp;&nbsp;<a href="delete?bId=${content_view.bId }">����</a></td>
			</tr>
		</form>
	</table>


</body>
</html>