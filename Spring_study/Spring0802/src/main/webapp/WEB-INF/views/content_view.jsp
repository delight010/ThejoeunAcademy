<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객명단 수정 및 삭제</title>
</head>
<body>

<form action="edit" method="post">
	<table>
	<tr><td align="right">번호 : </td>
	<td><input type="text" name="seq" size="10" readonly="readonly" value="${ContentDto.seq }"> </td></tr>
	<tr><td align="right">성명 : </td>
	<Td><input type="text" name="name" size="10" value="${ContentDto.name }" > </Td></tr>
	<tr><Td align="right">전화번호 : </Td>
	<td><input type="text" name="tel" size="10" value="${ContentDto.tel }"></td></tr>
	<tr><td align="right">주소 : </td>
	<td><input type="text" name="address" size="40" value="${ContentDto.address }"></td></tr>
	<tr><td align="right">이메일 : </td>
	<td><input type="text" name="email" size="40" value="${ContentDto.email }"></td></tr>
	<tr><td align="right">관계 : </td>
	<td><input type="text" name="relation" size="40" value="${ContentDto.relation }"></td></tr>
	
	<tr>
	<Td><input type="submit" value="수정" ></Td>
	<td><a href="delete?seq=${ContentDto.seq }">삭제</a></td></tr>
	
	<tr>
		<Td><a href="list">목록으로</a></Td>
	</tr>
	</table>
	
	
	
	</form>

</body>
</html>