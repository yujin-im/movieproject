<%@page import="com.DAO.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.VO.BoardVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<script defer src = "../OTT/js/nav.js"></script>
	<%@ include file = "./nav.jsp"%>

<link rel="stylesheet" href="../OTT/css/style.css">

<style>
	a{
		text-decoration : none;
		color:white;
		transition:1.3s all;
		
	}
	a:hover{
		color: white;
		border-bottom : 1px solid white;
		}
</style>
<% %>
<% int pageNumber =1; 
	if(request.getParameter("pageNumber")!=null){
		pageNumber= Integer.parseInt(request.getParameter("pageNumber"));
		
	}
%>
<% BoardDAO dao = new BoardDAO(); 
System.out.println("number22 ==>"+pageNumber);
	ArrayList<BoardVO> list = dao.getList(pageNumber);
%>
	<div class="container" style="margin-top:100px"> 
	<h1 style="color:white ;">전체글보기</h1>
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center; width:10%">Number</th>
						<th style="background-color: #eeeeee; text-align: center; ">Title</th>
						<th style="background-color: #eeeeee; text-align: center; width:10%">Writer</th>
						<th style="background-color: #eeeeee; text-align: center; width:10%">WriteDate</th>
						<th style="background-color: #eeeeee; text-align: center; width:10%">View</th>
					</tr>
				</thead>
				<tbody>
				
					
					<%for(int i=0; i<list.size(); i++) {%>						
					<tr style="color:white">
						<td style="color:white"><%=list.get(i).getArticle_seq() %></td>
						<td style="color:white"><a href="BoardCon.do?seq=<%=list.get(i).getArticle_seq()%>"><%=list.get(i).getArticle_title() %> </a></td>
						<td style="color:white"><%=list.get(i).getMb_id() %></td>
						<td style="color:white"><%=list.get(i).getArticle_date().substring(0,10) %></td>
						<td style="color:white"><%=list.get(i).getArticle_count() %></td>
					
					</tr>
				
				 <%} %>
				 
				
				 
				</tbody>
			</table>
			
		<!--  페이징 처리 -->
		<% if(pageNumber !=1){ %>
			<a href="board.jsp?pageNumber=<%=pageNumber -1 %>"
				class="btn btn-success btn-arraw-left">이전</a>
		<%} if(dao.nextPage(pageNumber+1)){ %>
			<a href="board.jsp?pageNumber=<%=pageNumber +1 %>"
				class="btn btn-success btn-arraw-left">다음</a>
		<%} %>
		<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
			
			
			
		</div>
	</div>
