<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link href="/css/common.css" rel="stylesheet">

<script>
	$(function(){
		$("table tbody tr").on("click",function(){
			//tr태그의 data-id 속성 값을 읽어서 input태그의 id값으로 설정
			//form 태그를 submit
			$("#id").val($(this).data("id"));
			$("#frm").submit();
		});
	});
</script>

</head>

<body>


	<%@ include file="/common/top.jsp"%>
	<form id="frm" action="/studentDetail" method="get">
		<input type="hidden" name="id" id="id">		
	</form>
	
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">학생</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>학생 ID</th>
									<th>학생 이름</th>
									<th>지명 횟수</th>
									<th>등록일자(yyyy-MM-dd)</th>
								</tr>
									<%
									List<StudentVo> studentList = (List<StudentVo>)request.getAttribute("studentList");
									List<StudentVo> studentSize = (List<StudentVo>)request.getAttribute("studentAll");
		
									int size = studentSize.size();
									int pageNum = Integer.parseInt(request.getParameter("page"));
									int pageSize = Integer.parseInt(request.getParameter("pagesize"));
									if(size%pageSize==0){
										size = size/pageSize;
									}else{
										size = size/pageSize +1;
									}
									for(StudentVo vo : studentList){
									%>
									<tr>
										<td><%=vo.getId() %></td>
										<td><%=vo.getName() %></td>
										<td><%=vo.getCall_cnt() %></td>
										<td><fmt:formatDate value="<%=vo.getReg_dt() %>" pattern="yyyy-MM-dd"/></td>
									</tr>
									<%}%>
							</table>
							<h2>표현식</h2>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>id</th>
										<th>name</th>
										<th>call_cnt</th>
									</tr>
								</thead>
								<tbody>
								<%
								for(StudentVo vo : studentList){
									pageContext.setAttribute("vo", vo);
								%>
								<tr>
									<th><%=vo.getId() %></th>			
									<th><%=vo.getName() %></th>			
									<th><%=vo.getCall_cnt() %></th>			
								</tr>
								<%}%>
								</tbody>
							</table>
						
							<br><br><hr><h2>EL</h2> 
							<table class="table table-striped">
								<thead>
									<tr>
										<th>id</th>
										<th>name</th>
										<th>call_cnt</th>
										<th>등록일자</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${studentList }" var="vo">
										<tr data-id="${vo.id}">
											<td>${vo.id}</td>
											<td>${vo.name}</td>
											<td>${vo.call_cnt}</td>
											<td>${vo.reg_dt}</td>
										</tr>
									</c:forEach>
								</tbody>
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
									  <a href="/studentList?page=<%=prevPage %>&pagesize=<%=pageSize%>" aria-label="Previous">
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
										<li <%=activeClass %>><a href="/studentList?page=<%=i%>&pagesize=<%=pageSize%>"><%=i %></a></li>
									
									<%-- <%=request.getAttribute("pageNavi") %> --%>
								<% }%>
								<li>
								   <a href="/studentList?page=<%=nextPage%>&pagesize=<%=pageSize %>" aria-label="Next">
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
