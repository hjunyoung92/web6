<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지 입니다.</h1>
	<form action="/member/join" method="post">
	<p>
	MID <input type='text' name='mid'>
	</p>
	<p>
	MPW <input type='password' name='mpw'>
	</p>
	<p>
	MNAME <input type='text' name='mname'>
	</p>
	<p>
	<button>가입</button>
	</p>
	</form>
	
</body>
</html>