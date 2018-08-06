<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <%%> : 스키립틀릿 -->
	<%-- <%= %> : 표현식 --%>
	<%
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		;
		
	%>

	hello servlet world
	<br> current time :	<%=sdf.format(dt)%>
</body>
</html>

<!-- 
	localhost:8180/jsp/basic.jsp
 -->