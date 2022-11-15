<%@page import="com.VO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="../jquery-3.6.0.min.js"></script>
      <link rel="stylesheet" href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css" />
  <script src="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 	
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

   <link rel="stylesheet" href="../OTT/css/rank.css" />
    <link rel="stylesheet" href="../OTT/css/style.css" />
<link rel="stylesheet" href="../OTT/css/startmovie.css">

<link rel="stylesheet" href="../OTT/css/about.css">


    <style>
    .dropdowna {
	position : relative;
	display : inline-block;
}


.dropbtn {
  background-color: transparent;
  color: black;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  width:100%;
  
}



.dropdown-content {
	display : none;
	position: absolute;
	right:158px;
	top: 20px;
	background-color: #f1f1f1;
	width:100%;
	z-index : 1;
	
	
}

.dropdown-content.b {
	top:170px;
	
	
}

.dropdowna:hover .dropdown-content{
	display:flex;
	flex-direction:column;

}

.dropdownb:hover .dropdown-content{
	display:flex;
	flex-direction:column;
}

.dropdown-content a{
	color : black;
	padding : 12px 16px;
	text-decoration : none;
	width: 100%;
	
}

   
#myDropdown>a:hover{
	background-color:#ddd;
}

.user{
	
	height:70px;
	position:fixed;
	right:140px;

	justify-content:flex-end;
	align-items:center;
	left: 50%;
	display:flex;

	
}

div.user>div.user-item{
	position:absolute;

	color:white;
	max-width:60px;
	height:70px;
	
	display:flex;
	justify-content:center;;
	align-items:center;
	text-align:center;
	cursor : pointer;
	
}

div.user>div.user-item i.fa-circle-user{
	font-size:40px;
}

    </style>


</head>
<body>
<%		MemberDTO vo = (MemberDTO)session.getAttribute("vo");	%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style = "height: 70px;width:100%;">
  <div class="container-fluid">
    <a class="navbar-brand" style="font-size:30px; font-weight:700;" href="../OTT/index.jsp"><img src="../OTT/img/logo5.png"style="width:420px; position:absolute; top:-30px; left:-100px; transform:rotate(-45deg)"></a>
<%if (vo != null) { %>
	

  <div class="user">
  <div class="user-item" onclick='location.href="../template/pages/samples/Edit.jsp"'>
  <i class="fa-solid fa-circle-user fa-2xl"></i></div></div>
 <%} %>
      <ul class="navbar-nav">
		
        <li class="nav-link active dropdown" >
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false"><i class="fa-solid fa-bars fa-2xl"></i></a>
          <div class="dropdown-menu one" style = "position: fixed; display:none; right:10px; color:black;">
          <div style="width:100%; display:flex; flex-direction:column; justify-content:center;">
           
            <a class="dropdown-item" style="color:#000;" href="../OTT/index.jsp">장르별 추천</a>
            <a class="dropdown-item" style="color:#000;" href="../OTT/rank.jsp">랭킹</a>
         
         <!-- 상영예정작 드롭다운 -->
			<div class="dropdowna" style="color:transparent;" href="#">
				
					<button class="dropbtn" onclick="myFunction()"> <span>상영예정작</span> </button>
					<div id = "myDropdown" class = "dropdown-content">

						<a href = "../OTT/OttSelectCon.do?video_type=1&video_ott=netflix"> 넷플릭스 </a>
						<a href = "../OTT/OttSelectCon.do?video_type=1&video_ott=watcha"> 왓챠 </a>
						<a href = "../OTT/OttSelectCon.do?video_type=1&video_ott=wavve"> 웨이브 </a>
					</div>
			
      		
      		</div>
      	
      	<!--  종료예정작 드롭다운 -->
            
            <div class="dropdownb" style="color:transparent;" href="#">
				
					<button class="dropbtn" onclick="myFunction()"><span>종료예정작</span> </button>
					<div id = "myDropdown" class = "dropdown-content b">

						<a href = "../OTT/OttSelectCon.do?video_type=2&video_ott=netflix"> 넷플릭스 </a>
						<a href = "../OTT/OttSelectCon.do?video_type=2&video_ott=watcha"> 왓챠 </a>
						<a href = "../OTT/OttSelectCon.do?video_type=2&video_ott=wavve"> 웨이브 </a>
				</div>
				
      	
      		</div>
      		
      	
      		
            

             <!--  로그인 했을 때 페이지 만들기 -->
      		
     		
            <% if (vo != null) {   %>
            	<a class="dropdown-item" style="color:#000;" href="../TABLE/board.jsp">자유게시판</a>
					 <div class="dropdown-divider"></div>
					<a href="LogoutCon.do" class="dropdown-item" style="color:#000;" >로그아웃</a>
					<a href="../template/pages/samples/Edit.jsp" class="dropdown-item" style="color:#000;" >회원정보수정</a>
					   </div>
						<%} else{ %>
			
				
				<div class="dropdown-divider"></div>
              <a class="dropdown-item" style="color:#000;" href="../template/pages/samples/login.jsp">로그인</a>
          	<a class="dropdown-item" style="color:#000;" href="../template/pages/samples/register.jsp">회원가입</a>
          	
        
      </div>
      		<%} %>

        
      </div>
           
           
          </div>
        </li>
      </ul>

  
  </div>
</nav>

</body>
</html>