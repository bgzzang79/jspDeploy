<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- DB CONNECTION 얻는 방법 3가지
		1.jdbc
		2.application connection pool
		3.was connection pool (jndi)
		
		각 방법별로 커넥션을 생성하는 시간 profiling 
	 -->

	<%
		//db 설정에 대한 값 설정
		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "pc09";
		String pw = "java";
		
		Connection conn = null;

		Class.forName(driverClassName);

		try{
			long startTime = System.currentTimeMillis();
			//커넥션을 100번 얻어오고 해제
			for (int i = 0; i < 50; i++) {
				conn = DriverManager.getConnection(url, userName, pw);
				out.write("Schema : "+conn.getSchema()+"<hr>");			
			}
			long endTime = System.currentTimeMillis();
			
			out.write("during : "+(endTime-startTime)+"ms");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn!=null)try{conn.close();}catch(SQLException e2){e2.printStackTrace();}
		}
	%>
</body>
</html>