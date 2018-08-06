<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>request</h3>
	표현식 : <%=request.getAttribute("requestScop") %><br>
	EL : ${requestScope.requestScop}<br>
	EL : ${requestScop}<hr>
	
	<h3>session</h3>
	표현식 : <%=session.getAttribute("sessionScop") %><br>
	EL : ${sessionScope.sessionScop}<br>
	EL : ${sessionScop}<hr>
	
	<h3>application</h3>
	표현식 : <%=application.getAttribute("applicationScop") %><br>
	EL : ${applicationScope.applicationScop }<br>
	EL : ${applicationScop}<hr>
	
	<h3>sameName</h3>
	EL : ${sameName} --> 가장 작은 영역에서부터 큰 영역으로 검색 pageContext -> request -> session -> application<hr>
	
	<h3>studentList</h3>
	표현식 : <%=request.getAttribute("studentList") %><br><br>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>call_cnt</th>
		</tr>
		<%
			List<StudentVo> studentList = (List<StudentVo>)request.getAttribute("studentList");
			for(StudentVo vo : studentList){
				pageContext.setAttribute("vo", vo);
		%>
		<tr>
			<th><%=vo.getId() %></th>			
			<th><%=vo.getName() %></th>			
			<th><%=vo.getCall_cnt() %></th>			
		</tr>
		<%}%>
	</table>
	<br><br><hr>EL : 
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>call_cnt</th>
		</tr>
		<c:forEach items="${studentList }" var="vo">
			<tr>
				<td>${vo.id} </td>
				<td>${vo.name} </td>
				<td>${vo.call_cnt} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>