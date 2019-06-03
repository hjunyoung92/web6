<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register page</title>
</head>
<body>
	<h1>register page</h1>
	
	<form action="/msg/register" method="post" enctype="multipart/form-data">
		<p>Sender<input type='text' name='sender' value="sender"></p>
		<p>Whom<input type='text' name='whom' value="${LOGINID}" readonly="readonly"></p>
		<p>MSG<input type='text' name='msg' value="밥먹고 하자"></p>
		<p>File<input type='file' name='files' multiple="multiple"></p>
		<p><input type='submit' value="메시지전송"></p>
	
	</form>
</body>
</html>