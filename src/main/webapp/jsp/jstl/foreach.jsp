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
	<table>
		<c:forEach items="${studentList}" var="vo" begin="2" end="5" step="2" varStatus="status">
			<tr>
				<td>${vo.id } / ${status.index}</td>
				<td>${vo.name }</td>
				<td>${vo.call_cnt }</td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>foreach map</h3>
	<%--
	 	map에 있는 값들을 전부 조회해서 출력
	 	map.get("name"), map.get("alias") 
	 --%>
	 <c:forEach items="${map }" var="entry">
	 	${entry.key} / ${entry.value }<br>
	 </c:forEach>
	 
	 <h3>forTokens</h3>
	 <c:forTokens items="${lineRangers }" delims="," var="ranger">
	 	${ranger }
	 </c:forTokens>
</body>
</html>