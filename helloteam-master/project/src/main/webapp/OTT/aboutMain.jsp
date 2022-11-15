<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- movie info -->

<style>

/*여기부터*/

	.bg{
		width : 100%;
	    height : calc(100vh - 60px);
	    margin-top : 60px;
	    background-size : cover;
	    background-repeat : no-repeat;
	    position:relative;
	}
    .promotion {
      height: 300px;
	  position: relative;
		top:10px;

  	  margin-bottom: 60px;
	  	
    }
    
    .promotion .swiper-container{
    	/*width:calc(200px*5+40px);*/
    	width:1200px;
    	height: 430px;
		
    	position:absolute;
		left:50%;
		margin-left:-400px;
   
    	
    }
    

    .slide{
        cursor:pointer;
    }


    

</style>

 

    <div class = "bg">
    <div class ="movie-info" style="position:relative; width:100%;'">
    	
        <div class = "movie-detail">
        <div class="movie-info" style=" margin-top:0%; width:100%; height:100%; ">
        <div class="movie-poster" style=""></div>
            <h1 class ="movie-name"style="margin-top:30px;"></h1>
            <div class="movie-ott"></div>
            <p class = "genres"> 장르:</p>
            <p class ="des"> </p>
                <div class="open">
                <div>상영중</div><div class ="starring" ></div>
                </div>
                            <!-- video clips -->

    <div class="promotion mt-5">
    <div class="swiper-container">
    <div class = "swiper-wrapper">
    	
    </div>
    </div>
    
    

    
    </div>
                
                
                </div>
        </div>
        

        </div>

    </div>

  


    <script src = "js/swiper.js"></script>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>            
    <script defer src = "js/about.js"></script>
    <script src = "js/api.js"></script>
    
