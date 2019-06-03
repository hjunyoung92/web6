<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="/member/login" method="post">
		<input type='text' name='uid'>
		<input type='text' name='upw'>
		<button>로그인</button>
	</form>
</body>
</html>