<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
</head>
<body>
	<h1>Register page</h1>
	${userList }
	
	<form action="/msg/register" method="post" enctype="multipart/form-data">
		<p>Sender<input type='text' name='sender' value="${LOGINID}" readonly="readonly"></p>
		<p>Whom<select name ="whom">
		<c:forEach items="${userList}" var="id">
		<option value="${id}">${id}
		</option>
		</c:forEach>
		</select>
		<p>MSG<input type='text' name='msg' value=""></p>
		<p>File<input type='file' name='files' multiple="multiple"></p>
		<p><input type='submit' value="메시지전송"></p>
	
	</form>
</body>
</html>