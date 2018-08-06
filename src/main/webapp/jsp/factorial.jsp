<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!public int factorial(int fac) {
		if (fac < 0)
			return 0;
		if (fac < 2)
			return 1;
		else
			return fac * factorial(fac - 1);
	}%>
	<h2>0-8 factorial</h2>
	<%for(int i=8; i>=0; i--){%>
		<%="factorial("+i+")"+" = "+ factorial(i) %><br>
	<%}%>
</body>
</html>