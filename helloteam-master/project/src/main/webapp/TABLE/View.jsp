<%@page import="com.VO.CommentVO"%>
<%@page import="com.DAO.BoardDAO"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URI"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.VO.BoardVO"%>
<%@page import="com.VO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script defer src = "../OTT/js/nav.js"></script>
	 <%@ include file = "./nav.jsp" %>
<link rel="stylesheet" href="../OTT/css/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale"="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP 게시판 웹 사이트</title>
<style>

.table{
	color : white;
}
.table-striped>tbody>tr:nth-of-type(odd)>* {
	color:white;
}
</style>
</head>
<body>
	<!--  getparameter id값 가져옴 -->
	<%
	MemberDTO inf = (MemberDTO) session.getAttribute("vo");
	%>
	<div class="container" style="margin-top: 200px">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #DDDDDD">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #EEEEEE; text-align: center; color:black;">게시판
							글보기</th>
					</tr>
				</thead>
				<tbody>
					<tr style="color: white">
						<td style="width: 20%;">제목</td>
						<td colspan="2"><%=session.getAttribute("title1")%></td>
					</tr>
					<tr style="color: white">
						<td>작성자</td>
						<td colspan="2" class="names"><%=session.getAttribute("name1")%></td>
					</tr>
					<tr style="color: white">
						<td>작성일자</td>
						<td colspan="2"><%=session.getAttribute("date1") %></td>
					</tr>
					<tr style="color: white">
						<td>내용</td>
						<td colspan="2"  style="min-height: 500px; text-align: left;"><%=session.getAttribute("content1")%></td>
					</tr>
				</tbody>
			</table>
			
<%
	System.out.println("seq2 == >"+session.getAttribute("seq1"));
	String seq2 = String.valueOf(session.getAttribute("seq1")); //int to String 형변환
%>
                	
                	
			<!-- 댓글 불러오기 -->
			<div class="container" style="margin:100px 0px;">
	<div class="row">
		<table class="table table-striped" style="text-align: center; border: 1px solid #DDDDDD">
			<tbody>
				<h4 style="color:white;"> 댓글 </h4>
					
						
				   <%
				
				 BoardDAO dao = new BoardDAO();
				ArrayList<CommentVO> co = dao.Comment(seq2);
					for(int i=0; i<co.size(); i++){
				%>
				
				<div class="card border-secondary mb-3 bg-dark" style="max-width: 100%; color:white;">
				
  					<div class="card-header">
  					<div class="left" style="float:left;"><%= co.get(i).getM_id() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=co.get(i).getCmt_date()%></div>
  					<%
						if(co.get(i).getM_id() != null && co.get(i).getM_id().equals(inf.getMb_id())){   //댓글 쓴사람과 지금 유저가 같을 때 삭제를 가능하게 함
					%>
  					<div class="right" style="float:right;">
  					<a class="btn btn-danger" onclick="return confirm('정말로 삭제하시겠습니까?')" href = "BoardCommentDeleteCon.do?commentID=<%= co.get(i).getCmt_seq()%>">삭제
  					</a>
  					</div>
  					<%} %>
  					</div>
 					 <div class="card-body">
    				<h4 class="card-title"><%=co.get(i).getCmt_content() %></h4>
    				
  					</div>
				</div>


		
						<%
							}
						%>
				</tr>
		</table>
	</div>
</div>
			<!--  댓글 작성 영역 -->
			<div class="container">
				<div class="form-group">
					<form method="post"	action="BoardCommentCon.do?userID=<%=inf.getMb_id()%>&article_seq=<%=seq2%>">
						<table class="table table-striped"
							style="text-align: center; border: 1px solid #DDDDDD">
							<tr>
								<td style="border-bottom: none;" valign="middle"><br>
									<br></td>
								<td><input type="text" style="height: 100px;"
									class="form-control" placeholder="댓글창" name="commentText"></td>
								<td><br> <br> <input type="submit"
									class="btn-primary pull" value="댓글 작성"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<a href="board.jsp" class="btn btn-primary">목록</a>
			<%
			if (inf.getMb_id() != null && inf.getMb_id().equals(session.getAttribute("name1"))) {
			%>
			<a href="Update.jsp?id=<%=session.getAttribute("seq1")%>"
				class="btn btn-primary">수정</a> <a
				onclick="return confirm('정말로 삭제하시겠습니까?')"
				href="BoardDeleteCon.do?id=<%=session.getAttribute("seq1")%>"
				class="btn btn-primary">삭제</a>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>