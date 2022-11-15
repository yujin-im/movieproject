<%@page import="com.VO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>SearchTT</title>
  
    <!-- plugins:css -->

    <link rel="stylesheet" href="../../assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../assets/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="../../assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="../../assets/images/favicon.png" />
        <style>
    	input[type="checkbox"] {
    	display: inline-block;
    	width:20px;
    	height:20px;
    	border : 3px solid #707070;
    	position:relative;
    	margin-right:100px;
    
    	}
    	
 
    	.modall{
    		position : absolute;
    		top:0;
    		left:0;
    		
    		width:100%;
    		height: 100%;
    			display:none;
    		background-color: rgba(0,0,0,0.4);
    	}
    	
    	.btn-open-popup{
    		padding:30px;
    		height:70px;
    		background-color:white;
    		display:flex;
    		align-items:center;
    		justify-content:center;
    		letter-spacing: 1px;
    		font-size:25px;
    		cursor:pointer;
    		color : #191c24;
    	}
    	
    	   .modall.show {
    		display:block;
    	}
    	
    	.modall-body{
    		position : absolute;
    		top:50%;
    		height: 50%;
    		color :black;
    		width : 1000px;
    		
    		height:800px;
    		padding:80px;
    		
    		text-align:center;
    		
    		background-color : rgb(255,255,255);
    		border-radius : 10px;
    		box-shadow : 0 2px 3px 0 rgba(34,36,38,0.15);
    		
    		transform : translateX(-15%) translateY(-50%);
    	}
    	
    	.modall-switch {
    		position: absolute;
    		right: 50px;
    		color : black;
    		cursor:pointer;
    	}
    	
    	.modall-head{
    		margin-top : 50px;
    	}
    	
    	div.modall-head > h3{
    		letter-spacing: 1.2px;
    		font-weight: 900;
    	}
    	
    	div.check-group>div.row>div.col-sm-6>div.row>div.col-sm-6 {
    		font-size:23px;
    		margin-top:15px;
    		margin-bottom:10px;

    	}
    	
    	.btn{
    		margin-top:30px;
    	}
    </style>
    
  </head>
  <body>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                <h3 class="card-title text-left mb-3">회원정보수정</h3>
                	<%		MemberDTO vo = (MemberDTO)session.getAttribute("vo");	%>
                	
                	<%  String gen = (String)session.getAttribute("gen"); %>
                	
                	<input type="hidden" id="gen" value=<%= gen %>>
                	
                <form action="UpdateCon.do" method="post">
                  <div class="form-group">
                    <label>수정할 닉네임</label>
                    <input type="text" class="form-control p_input" value="<%=vo.getMb_name() %>" id="name" name="name" required>
                 	
                  </div>
                  <div class="form-group">
                    <label>수정할 비밀번호</label>
                    <input type="text" class="form-control p_input" value="<%= vo.getMb_pw()%>" id="pw" name="pw" required>
                  
                  </div>
                  
  		
	
                    
               
                  	
                  <!--   -->	
                  
                  	
                  	
                                   <!-- modal  위에 체크박스 만들기 계속하기-->
                    <div class="form-group"> 
                    
                    
                    <div class="modall">
                    	<div class="modall-body">
                    		<div class="modall-switch"> <i class="fa-solid fa-xmark fa-2xl"></i> </div>
                    		
                    		<div class="modall-head"> <h3> 선호장르 수정 </h3></div>
                    		<hr/>
                    		<div class="check-group">
                    
          
              		<div class="row">
              			<div class="col-sm-6">
              			
              			<div class ="row">
              				<div class="col-sm-6">액션</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="10759"> </div>
              			</div>
              			
              		
              			 </div>
              			<div class="col-sm-6"> 
              			
              				<div class ="row">
              				<div class="col-sm-6">애니메이션</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="16"> </div>
              			</div>
              			
              			</div>
              		</div>
              		
              			<div class="row">
              			<div class="col-sm-6">
              			<div class ="row">
              				<div class="col-sm-6">코메디</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="35"> </div>
              			</div>
              			
              			 </div>
              			<div class="col-sm-6"> 
              			<div class ="row">
              				<div class="col-sm-6">범죄</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="80"> </div>
              			</div>
              			</div>
              		</div>
                    
                    
                    	<div class="row">
              			<div class="col-sm-6">
              			<div class ="row">
              				<div class="col-sm-6">다큐멘터리</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="99"> </div>
              			</div>
              			
              			 </div>
              			<div class="col-sm-6"> 
              			<div class ="row">
              				<div class="col-sm-6">드라마</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="18"> </div>
              			</div>
              			</div>
              		</div>
                    
                    
                    
                       <div class="row">
              			<div class="col-sm-6">
              			<div class ="row">
              				<div class="col-sm-6">가족</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="10751"> </div>
              			</div>
              			
              			 </div>
              			<div class="col-sm-6"> 
              			<div class ="row">
              				<div class="col-sm-6">만화</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="10762"> </div>
              			</div>
              			</div>
              		</div>
                    
                            
                       <div class="row">
              			<div class="col-sm-6">
              			<div class ="row">
              				<div class="col-sm-6">미스터리</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="9648"> </div>
              			</div>
              			
              			 </div>
              			<div class="col-sm-6"> 
              			<div class ="row">
              				<div class="col-sm-6">뉴스</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="10763"> </div>
              			</div>
              			</div>
              		</div>
                    
                            
                       <div class="row">
              			<div class="col-sm-6">
              			<div class ="row">
              				<div class="col-sm-6">예능</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="10751"> </div>
              			</div>
              			
              			 </div>
              			<div class="col-sm-6"> 
              			<div class ="row">
              				<div class="col-sm-6">SF&판타지</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="10765"> </div>
              			</div>
              			</div>
              		</div>
              		
              		        
                       <div class="row">
              			<div class="col-sm-6">
              			<div class ="row">
              				<div class="col-sm-6">토크쇼</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="10767"> </div>
              			</div>
              			
              			 </div>
              			<div class="col-sm-6"> 
              			<div class ="row">
              				<div class="col-sm-6">전쟁&정치</div>
              				<div class="col-sm-6"> <input type="checkbox" class="genreBox" name="genere" value="10768"> </div>
              			</div>
              			</div>
              		</div>
 
                    
                    <button type ="button" class="btn btn-primary btn-lg mt-5" style="font-size:20px;">선택완료</button>
                    
                    
                    
                    			</div>
                    		</div>
                    	</div>
                    <div class = "btn-open-popup" href="#"> 선호 장르 수정 </div>
                   </div>
                   
                   
                  <!-- ---선호 장르 불러오기 -->
                     	<script type="text/javascript"> 
	                  	var gen = document.querySelector('#gen');	//16,80,92,100 의 형식으로 들어옴
	                  	  // 밸류값 가져올때
	                  	var gensp = gen.value.split(",");   // , 기준으로 잘라서 리스트 형태로 만들어짐
	               	
	               			for(var j in document.getElementsByClassName("genreBox")){
	               				//console.log("클래스 벨류==>",document.getElementsByClassName("genreBox")[j].values)
	               			//	console.log("장르 벨류==>",gensp[0])
								for(var i in gensp ){
	                  		//	console.log(i)
	                  			if( document.getElementsByClassName("genreBox")[j].value == gensp[i]){
	                  				document.getElementsByClassName("genreBox")[j].setAttribute('checked',true);
	                  			}
	                  		}
	                  	}
                  	</script>
                 
                  
                  
                  <div class="text-center">
                
                    <a href="UpdateCon.do"><button type="submit" class="btn btn-primary btn-block enter-btn">변경</button></a>
                    <a href="../../OTT/index.jsp"></a><button type="submit" class="btn btn-primary btn-block enter-btn">돌아가기</button></a>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
     <script>
    const bg = sessionStorage.getItem("mineSession");
    loginbg = document.querySelector(".auth.login-bg");
    console.log(bg);
    loginbg.style.backgroundImage="url("+bg+")";

    </script>
    
    <!-- plugins:js -->
    <script src="../../assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="../../assets/js/off-canvas.js"></script>
    <script src="../../assets/js/hoverable-collapse.js"></script>
    <script src="../../assets/js/misc.js"></script>
    <script src="../../assets/js/settings.js"></script>
    <script src="../../assets/js/todolist.js"></script>
    <script src="../../assets/js/modal.js"></script>
    	<script src="../../assets/js/edit.js"></script>
    <!-- endinject -->
  </body>
</html>