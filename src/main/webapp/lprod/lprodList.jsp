<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">Lprod</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>lprod ID</th>
									<th>lprod gu</th>
									<th>lprod nm</th>
								</tr>
								<%
									List<LprodVo> lprodList = (List<LprodVo>)request.getAttribute("lprodList");
									List<LprodVo> lprodSize = (List<LprodVo>)request.getAttribute("lprodAll");
		
									int size = lprodSize.size();
									int pageNum = Integer.parseInt(request.getParameter("lpage"));
									int pageSize = Integer.parseInt(request.getParameter("lpagesize"));
									if(size%pageSize==0){
										size = size/pageSize;
									}else{
										size = size/pageSize+1;
									}
									for(LprodVo vo : lprodList){
								%>
									<tr>
										<td><%=vo.getLprod_id() %></td>
										<td><%=vo.getLprod_gu() %></td>
										<td><%=vo.getLprod_nm() %></td>
									</tr>
								<%}%>
							</table>
							<h2>표현식</h2>
							<table class="table table-striped">
								<tr>
									<th>lprod ID</th>
									<th>lprod gu</th>
									<th>lprod nm</th>
								</tr>
								<%
								for(LprodVo vo : lprodList){
									pageContext.setAttribute("vo", vo);
								%>
								<tr>
									<td><%=vo.getLprod_id() %></td>
									<td><%=vo.getLprod_gu() %></td>
									<td><%=vo.getLprod_nm() %></td>
								</tr>
								<%} %>
							</table>
							
							<br><br><hr><h2>EL</h2>
							<table class="table table-striped">
								<tr>
									<th>lprod ID</th>
									<th>lprod gu</th>
									<th>lprod nm</th>
								</tr>
								<c:forEach items="${lprodList}" var="vo">
									<tr>
										<td>${vo.lprod_id}</td>
										<td>${vo.lprod_gu}</td>
										<td>${vo.lprod_nm}</td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
							<%
								int prevPage = pageNum ==1 ? 1: pageNum -1;
								int nextPage = pageNum == size ? pageNum : pageNum+1;
							%>
								<li>
									  <a href="/lprodList?lpage=<%=prevPage %>&lpagesize=<%=pageSize%>" aria-label="Previous">
									    <span aria-hidden="true">&laquo;</span>
									  </a>
								</li>
								<%
									for(int i=1; i<=size; i++){ 
										String activeClass = "";
								%>
									<%if(i==pageNum){
										activeClass="class=\"active\"";
									}%>
										<li <%=activeClass %>><a href="/lprodList?lpage=<%=i%>&lpagesize=<%=pageSize%>"><%=i %></a></li>
								<% }%>
								<li>
								   <a href="/lprodList?lpage=<%=nextPage%>&lpagesize=<%=pageSize %>" aria-label="Next">
								     <span aria-hidden="true">&raquo;</span>
								   </a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
