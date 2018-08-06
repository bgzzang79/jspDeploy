<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
th {
	border: 1px solid blue;
}

 #a{
	background-color: pink;
}
</style>
<body>
	<%
		List<BoardVo> boardList = (List<BoardVo>)session.getAttribute("boardList");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<table>
		<th id="a">제목</th>
		<th id="a">내용</th>
		<th id="a">아이디</th>
		<th id="a">닉네임</th>
		<th id="a">날짜</th>
		<%
			for(int i=0; i<boardList.size(); i++){
				String date = sdf.format(boardList.get(i).getRegDt());
		%>
		<tr>
			<th><%=boardList.get(i).getTitle()%></th>
			<th><%=boardList.get(i).getContent()%></th>
			<th><%=boardList.get(i).getUserId()%></th>
			<th><%=boardList.get(i).getAlias()%></th>
			<th><%=date%></th>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>