<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 각 영역에 설정된 속성을 출력 -->
page : <%=pageContext.getAttribute("pageScope") %><hr>
request : <%=request.getAttribute("requestScope") %><hr>
session : <%=session.getAttribute("sessionScope") %><hr>
application : <%=application.getAttribute("applicationScope") %><hr>
</body>
</html>
<%-- 
	시나리오
	1. localhost:8180/jsp/jsp/scope/scopeInput.jsp 접속
	2. 각 영역에 설정할 값을 입력(이미 입력되어있음)을 전송 --> scopeSetAttr.jsp
	3. scopeSetAttr.jsp에서는 각 영역에 속성을 설정
	4. dispatcher를 이용하여 scopeResult.jsp 화면 출력 기능 위임
	5. 브라우저의 화면 결과를 확인한다.
	
	시나리오2
	1. 같은 브라우저의 신규 tab을 열어서 결과 화면으로 직접 이동한다.
	(scopeSetAttr.jsp를 거치지 않는다.)
	localhost:8180/jsp/jsp/scope/scopeResult.jsp 접속
	
	시나리오3
	1. 새로운 브라우저(인터넷 익스플로어)를 실행하여 결과 화면으로 직접 이동한다.
 --%>