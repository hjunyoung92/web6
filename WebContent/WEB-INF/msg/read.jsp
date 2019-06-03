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
메시지 번호${vo.mno}
</p>
<p>
Sender${vo.sender}
</p>
<p>
whom${vo.whom}
</p>
<p>
MSG${vo.msg}
</p>
<u1>
<c:forEach items="${vo.files}" var="fvo">
<li><a href='/download?fname=${fvo.savename}'>${fvo.originname} </a></li>
</c:forEach>
</u1>
</body>
</html>