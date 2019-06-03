<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive page</title>
</head>
<body>

	<style>
    .read {
	text-decoration: line-through;
}
</style>
	<ul>
		<c:forEach items="${list }" var="vo">
			<li><a href="/msg/read?mno=${vo.mno}">${vo.mno}</a> <span
				class='${vo.gubun eq "Y"?"read":"" }'>${ vo.msg }</span>
			<fmt:formatDate value="${ vo.regdate}" pattern="yy-MM-dd hh:mm"
					type="both" /><br></li>
		</c:forEach>
	</ul>

	<script type="text/javascript">
		setTimeout(function() {
			Console.log('..........');
			self.location = self.location
		}, 10000);
	</script>
</body>
</html>