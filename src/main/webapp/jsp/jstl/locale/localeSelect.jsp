<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/common/jquery.jsp" %>
<script>
// 	select box 변경시 요청이 되도록 수정
$(function(){
	//페이지 로딩시 select box 설정
	$("select[name=locale]").val("${locale}").prop("selected",true);
	//select box 변경 이벤트
	$("select[name=locale]").change(function(){
		$("form").submit();
	});
});
</script>

</head>
<body>

	<c:set value="브라운" var="userId"></c:set>
	
	<form action="localeSelect" method="get">
		<select name="locale">
			<option value="ko">한국어</option>
			<option value="ja">日本語</option>
			<option value="en">english</option>
		</select>
	</form>
	
	<br>

	<fmt:setLocale value="${param.locale}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/><br>
		<fmt:message key="visitor">
			<fmt:param value="${userId}"></fmt:param>
		</fmt:message>
	</fmt:bundle>

</body>
</html>