<%@page import="com.VO.OttDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" src="./css/startmovie.css">
<title>Insert title here</title>


</head>
<body>

<% ArrayList<OttDTO> list = (ArrayList<OttDTO>)session.getAttribute("list"); %>


<section class ="youtube">
	<div class="youtube__area">
		<div id = "player"></div>
	</div>
	<div class="youtube__cover"></div>


<div class="container" style="margin-top: 100px;">
	
	<div class="container-head mt-2">
	<div class="pic-box">
	<style>
	.pic-box{
	background-image : url("<%=list.get(0).getVideo_img()%>");
	background-size: cover;
	</style>
	
}
	
	 </div>
	 <div class="pflex">
	<div class="pic-title mt-3"> <h3 id ="h3tag">
	<%=list.get(0).getVideo_title() %>
	</h3></div> 

	<div class="detail">
		<div class="list-group">
		<div class="list-group-item d-flex justify-content-between align-items-center">
			장르 | 미스터리
		</div>
		
	</div>
	<div class="detail">
		<div class="list-group">
		<div class="list-group-item d-flex justify-content-between align-items-center">
			국가 | <%=list.get(0).getVideo_country() %>
		</div>
		
	</div>


	<div class="detail">
		<div class="list-group">
		<div class="list-group-item d-flex justify-content-between align-items-center">
			등급 | <%=list.get(0).getVideo_rating() %> 세 이상
		</div>
		
	</div>
	<div class="detail">
		<div class="list-group">
		<div class="list-group-item d-flex justify-content-between align-items-center">
		<%if (list.get(0).getVideo_type().equals("1")){ %>
		
			상영날짜 | <%=list.get(0).getVideo_open_date() %>
			<%} else { %>
			종료날짜 | <%=list.get(0).getVideo_close_date() %>
			<%} %>
		</div>
		
	</div>

	</div>
	
	<div class="detail">
		<div class="list-group">
		<div class="list-group-item d-flex justify-content-between align-items-center">
			런타임 | <%=list.get(0).getVideo_runtime() %>분
		</div>
		
	</div>
	
	
	</div>
	
</div>
<div class="descrip">
	  <%=list.get(0).getVideo_content() %>
</div>
</section>
<script src = "js/youtube.js"></script>

</body>
</html>