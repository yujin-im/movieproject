<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<style>
	.container{
	

	}
	h1{
		color:white;
		text-align:center;
	}
</style>
<% String value =  request.getParameter("val");%>

	<div class="container">
		<h1> <%= value %> 검색결과 </h1>
	</div>
	<script src = "js/search.js"></script>

    