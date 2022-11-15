<%@page import="com.VO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<script defer src = "../OTT/js/nav.js"></script>
<%@ include file = "./nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%	MemberDTO inf = (MemberDTO) session.getAttribute("vo");%>
<% 

	String seq2 = String.valueOf(session.getAttribute("seq1")); //int to String 형변환
%>



<div class="container">
	<div class="form-group">
		<form method="post" encType = "multipart/form-data" action="BoardCon.do?userID=<%=inf.getMb_id() %>&article_seq=<%=seq2%>">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<tr>
					<td style="border-bottom:none;" valign="middle"><br><br><%=inf.getMb_id() %></td>
					<td><input type="text" style="height:100px;" class="form-control" placeholder="상대방을 존중하는 댓글을 남깁시다." name = "commentText"></td>
					<td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="file" name="fileName"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>