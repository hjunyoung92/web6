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
<h1>받은 메시지
</h1>

	
	<style>
	.read{
		text-decoration: line-through;
	}
	
	</style>
<ul>
	<c:forEach items="${list }" var="vo">
		<li><span class='${vo.gubun eq "Y"?"read":"" }'><a href="/msg/read?mno=${vo.mno}">${vo.mno}</a> ${ vo.msg }<fmt:formatDate value="${ vo.regdate}" pattern="yy-MM-dd hh:mm" type="both"/></span><br>
		</li>
	</c:forEach>
</ul>

<script type="text/javascript">
	setTimeout(function()  {
		console.log('..........');
		self.location = self.location
	}, 10000);
</script>

<style>
.paging { 
	display: flex;
	
	}
.paging li {
	margin: 0.5em;
	background-color: skyblue;
	width: 3em;
	align-content: center;
	text-align: center;
	border-radius: 0.5em;
	font-weight: bold;
	border: 0px;
    list-style-type: none;
	
}


.paging li.now {
	background-color:red;
    list-style-type: none;

}


</style>

<ul class='paging'>
	<c:if test="${pageManager.prev }">
	<li><a href='/msg/receive?page=${pageManager.start-1 }'><c:out value="<<"></c:out></a>
	</li>
	</c:if>
	
	<c:forEach begin="${pageManager.start }" end="${pageManager.end }" var="step">
	<li class='${pageManager.current == step? "now":"" }'><a href='/msg/receive?page=${step}'>${step}</a></li>
	</c:forEach>
	
	
	<c:if test="${pageManager.next}">
	<li><a href='/msg/receive?page=${pageManager.end+1}'><c:out value=">>"></c:out></a>	
	</li>
	</c:if>
</ul>


</body>
</html>