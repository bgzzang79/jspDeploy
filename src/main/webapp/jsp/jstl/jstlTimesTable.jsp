<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#top {
	background-color: lightblue;
}

td {
	border: 1px solid blue;
	text-align: center;
}
</style>
<body>
	<table>
		<tr id="top">
			<c:forEach var="top" begin="2" end="9">
				<td>${top}단</td>
			</c:forEach>
		</tr>
		<c:forEach var="table1" begin="1" end="9">
			<tr>
				<c:forEach var="table2" begin="2" end="9">
					<td>${table2} * ${table1} = ${table1*table2}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>