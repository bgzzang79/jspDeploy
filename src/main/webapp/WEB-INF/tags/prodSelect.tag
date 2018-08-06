<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="lgu" type="java.lang.String" required="true"%>
<br>
<%
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc09";
		String pass = "java";
		Connection conn;
		Statement stmt;
		ResultSet rs;

		String sql = "select prod_id,prod_name from prod where prod_lgu="+ "'lgu'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, pass);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		out.write("<select>");
		while (rs.next()) {
			out.write("<option>"+rs.getString("prod_lgu")+"</option>");
			
		}
		out.write("</select>");

		conn.close();
%>