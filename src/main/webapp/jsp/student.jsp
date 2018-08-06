<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- oracle db의 student 테이블을 조회하여 화면에 출력 -->
	<%
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc09";
		String pass = "java";
		Connection conn;
		Statement stmt;
// 		PreparedStatement pstmt;
		ResultSet rs;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, pass);
		stmt = conn.createStatement();
// 		pstmt = conn.prepareStatement("select * from lprod");
		rs = stmt.executeQuery("select * from lprod");
		out.println("<table border=\"1\">");
		while (rs.next()) {
			out.println("<tr>");
			out.println("<td>" + rs.getString("lprod_id") + "</td>");
			out.println("<td>" + rs.getInt(1) + "</td>");
			out.println("<td>" + rs.getString("lprod_gu") + "</td>");
			out.println("<td>" + rs.getString("lprod_nm") + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");

		conn.close();
	%>
</body>
</html>