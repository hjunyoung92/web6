<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		메시지 번호 ${vo.mno}
	</p>
	<p>
		sender ${vo.sender}
	</p>
	<p>
		whom ${vo.whom}
	</p>
	<p>
		msg ${vo.msg}
	</p>
	<ul>
	<c:forEach items="${vo.files }" var="fvo">
	<li> <a href='/download?fname=${fvo.savename}'>${fvo.originname }</a></li>
	</c:forEach>
	</ul>
</body>
</html>