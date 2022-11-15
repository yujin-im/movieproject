<%@page import="com.VO.OttDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.11.1/gsap.min.js" integrity="sha512-Mf/xUqfWvDIr+1B6zfnIDIiG7XHzyP/guXUWgV6PgaQoIFeXkJQR5XWh9fqAiCiRCpemabt3naV4jhDWVnuYDQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<%@include file = "nav.jsp"%>
	


<%  ArrayList<OttDTO> list = (ArrayList<OttDTO>)session.getAttribute("list");  %>

<% System.out.println(list); %>
    <!--main section -->
    

    <header class = "main">

        <h1 class = "heading" style="margin-left:180px;"><%=list.get(0).getVideo_ott() %> </h1>
 
        <div class="cardrow mt-5" style="width:100%">
		
			<%for(int i =0; i<list.size()-1; i++){%>
				<div class="col-sm-3 div_tag" style="max-width:20%;">
				<div class="card" style="background-color:black; height:600px;" >
				<div class ="card-container" style=" height:400px; overflow:hidden; cursor:pointer">
					<a>
					<img onclick='location.href="OttDetailCon.do?id=<%=list.get(i).getVideo_seq()%>&video_type=<%=list.get(i).getVideo_type()%>&video_ott=<%=list.get(i).getVideo_ott()%>"'style="width:300px;" src ="<%=list.get(i).getVideo_img()%>"></a>
				</div>
				<div class="card-title mt-2" style="display:flex; padding:6px;"><h5><%=list.get(i).getVideo_title() %></h5></div>
				<%if (list.get(i).getVideo_open_date() != null) {%>
				<div class="d-day" style="padding:0 10px;">상영예정일 : <%=list.get(i).getVideo_open_date() %></div>
				<%}else{ %>
				<div class="d-day" style="padding:0 10px;">종료예정일 : <%=list.get(i).getVideo_close_date() %></div>
				<%} %>
				</div>
			</div>
				
			<% } %>

        </div>
    </header>
    <script>

    const brandEl = document.querySelector(".navbar-brand");
    window.addEventListener('scroll',_.throttle(function(){
    	console.log(window.scrollY);
    	if(window.scrollY > 500){
    		gsap.to(brandEl,.6,{
    			opacity : 0,
    			display:'none'
    		});
    		//brandEl.style.display = 'none';
    	} else{
    		gsap.to(brandEl,.6,{
    			opacity : 1,
    			display:'block'
    		});
    		//brandEl.style.display = 'block';
    	}
    },300));



     
    </script>
<scirpt src = "js/nav.js"></scirpt>
	 <script defer src = "js/movieMain.js"></script>
	
    <script src = "js/api.js"></script>
	<script src = "js/dropdown.js"></script>
   
