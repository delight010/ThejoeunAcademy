<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객명단 작성</title>
</head>
<body>

<form action="write" method="post">
	<table>
	<tr><td align="right">성명 : </td>
		<Td><input type="text" name="name" size="10" ></Td></tr>
	<tr><Td align="right">전화번호 : </Td>
		<td><input type="text" name="tel" size="10" ></td></tr>
	<tr><td align="right">주소 : </td>
		<td><input type="text" name="address" size="40"></td></tr>
	<tr><td align="right">이메일 : </td>
		<td><input type="text" name="email" size="40" ></td></tr>
	<tr><td align="right">관계 : </td>
		<td><input type="text" name="relation" size="40" ></td></tr>
	
	<tr>
	
	<Td><input type="submit" value="작성"></Td>
	<td rowspan="2"><a href="list">목록보기</a><br></td></tr>
	</table>
	
	
	
	</form>

</body>
</html>