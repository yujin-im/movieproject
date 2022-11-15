
<%@page import="com.VO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<script>
console.log("img->",document.getElementsByTagName("img").style);
</script>
<script src="../jquery-3.6.0.min.js"></script>

<script src = "js/nav.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.11.1/gsap.min.js" integrity="sha512-Mf/xUqfWvDIr+1B6zfnIDIiG7XHzyP/guXUWgV6PgaQoIFeXkJQR5XWh9fqAiCiRCpemabt3naV4jhDWVnuYDQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<%@include file = "nav.jsp"%>
<% String gen = (String) session.getAttribute("gen"); %>
<style>
.header{
	width:100%;
	height: 33vh;
	background-image : url("https://www.themoviedb.org/t/p/original/tTrZap8lEJsdpnab5yIR3d9bedg.jpg");
	background-size: cover;
	background-repeat : no-reqeat;
	background-attachment: fixed;
	background-position:center;
}

.black{
	width:100%;
	height:33vh;
	background-color: linear-gradient(90deg, rgba(24, 24, 24, 1), rgba(24, 24, 24, 0) 100%);
	position:absolute;
	top:0px;
	left:0px;
}

.inputbox{position:absolute; top:100px;}
</style>

<div class="session">


<input type="hidden" id="gen" value="<%=gen%>">

 <div class="header">
   	<div class="container">
   	
   	</div>
   </div>
   <div class="black"></div>
	<%@ include file="./searchForm.jsp" %>


<%@include file = "./indexMain.jsp"%>
</div>
