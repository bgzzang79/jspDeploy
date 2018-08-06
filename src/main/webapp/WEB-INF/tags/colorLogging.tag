<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="size" type="java.lang.Integer" required="false"%>

<%-- size 속성이 들어오지 않으면 기본값으로 30 --%>

<font color="${color}">
<c:if test="${size eq null}">
	<c:set var="size" value="30"></c:set>
</c:if>
<c:forEach begin="0" end="${size}">=</c:forEach>
</font> 