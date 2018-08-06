<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/jsp/jsp/scope/scopeSetAttr.jsp" method="post">
		<input type="text" name="pageScope" value="pageScopeValue"/><br>
		<input type="text" name="requestScope" value="requestScopeValue"/><br>
		<input type="text" name="sessionScope" value="sessionScopeValue"/><br>
		<input type="text" name="applicationScope" value="applicationScopeValue"/><br>
		<input type="submit" value="전송"><br>
	</form>
</body>
</html>