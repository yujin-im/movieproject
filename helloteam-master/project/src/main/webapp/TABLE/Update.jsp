<%@page import="java.net.URL"%>
<%@page import="java.net.URI"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.VO.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<script defer src = "../OTT/js/nav.js"></script>
	<%@ include file = "./nav.jsp" %>
<link rel="stylesheet" href="../OTT/css/style.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div class="container" style="margin-top:200px">
	<div class="row">
		<form method="post" action="BoardUpdateCon.do?id=<%=session.getAttribute("seq1") %>">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글 수정 양식</th>						
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" class="form-control" placeholder="글 제목" name="Utitle" maxlength="50" value="<%=session.getAttribute("title1") %>"></td>
				</tr>
				<tr>
					<td><textarea class="form-control" placeholder="글 내용" name="Ucontent" maxlength="2048" style="height: 350px" ><%=session.getAttribute("content1") %></textarea></td>						
				</tr>
			</tbody>
		</table>
		<input type="submit" class="btn btn-primary pull-right" value="글수정">
		</form>						
	</div>
</div>



</body>
</html>