<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<form action="write" method="post">
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="bName" size="50"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="bTitle" size="50"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><Textarea name="bContent" rows="10"></Textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�Է�">&nbsp;&nbsp;<a href="list">���</a></td>
			</tr>
		</form>
	</table>

</body>
</html>