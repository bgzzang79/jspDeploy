<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--jstl 사용을 하기위해 taglib 지시자 작성 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

request.userId : ${userId} / ${requestScope.userId}<br>

<!-- set : 특정영역에 변수를 새로생성 (default : page) -->
<%
	pageContext.setAttribute("test", "testvalue");
%>
c:set : <c:set var="test" value="testValue"/>${test} / ${pageScope.test}<br>
<!-- 위 아래 같은 의미 -->
pageContext.getAttribute("test") : <%=pageContext.getAttribute("test") %>

<h3>c:set scope</h3>
<c:set var="test" value="testSessionValue" scope="session"/>${test} / ${sessionScope.test }

<!--
	 el은 영역이 작은 곳부터 큰 곳으로 순차 검색
	page -> request -> session -> application
 -->
<h3>c:set target, property</h3>
${studentVo } <br>

<c:set target="${studentVo}" property="name" value="브라운"/>

${studentVo } <br>

</body>
</html>