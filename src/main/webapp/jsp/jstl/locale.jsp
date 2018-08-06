<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
	작성된 msg파일
	msg.properties
	msg_ko.properties
	msg_en.properties
	msg_ja.propertiesw
--%>
<%
// 	pageContext.setAttribute("userId", "브라운");
%>
	<c:set value="브라운" var="userId"></c:set>

	<fmt:setLocale value="ja"/>

	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/><br>
		<fmt:message key="visitor">
			<fmt:param value="${userId}"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	
	<h3>setBundle</h3>
	<fmt:setLocale value="en"/>
	<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg"/>
	<fmt:message bundle="${msg}" key="hello"/><br>
	<fmt:message bundle="${msg}" key="visitor">
		<fmt:param value="${userId}"/>
	</fmt:message>
</body>
</html>