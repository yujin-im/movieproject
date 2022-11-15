

const main = document.querySelector('.main');
const cardrow = document.querySelector('cardrow');
let page = 1;



$(function() {
	console.log("start");
	//실행할 내용
	
	movie();
	
	$('.btn').on('click', (e) => {
		page += 1;
		console.log(page);
		movie();
	});
});

	let cnt = [];
function movie() {
	
	$.ajax({
		// 1. 어디랑 통신 할껀지 ??
		url: "https://api.themoviedb.org/3/tv/popular?api_key=4b3fd2d5d3a33372bb64b192b7490d22&language=ko-KR&page=" + page,

		dataType: 'json',//키:밸류
		// 2. 성공 메소드
		// data -> 통신 성공시 응답받은 데이터가 담길 변수
		// 통신성공시 실행되는 함수의 매개변수에 응답데이터 전부 담겨지게 된다!
		success: function(jsonObj) {

			console.log(jsonObj);

			console.log("jsondata ==>" + jsonObj);
			if (jsonObj != null) {
			
				let imgurl = "https://tmdb.org/t/p/w300";
				console.log(jsonObj.results[0])
				for (let i = 0; i < 99; i++) {
					let imgP = imgurl + jsonObj.results[i].poster_path;
					let mvtitle = jsonObj.results[i].name;
					let glad = jsonObj.results[i].vote_average;
					let first_date = jsonObj.results[i].first_air_date;
					let origin_country = jsonObj.results[i].origin_country[0];
					let id = jsonObj.results[i].id;
					$('.cardrow').append("<div class='col-sm-3 div_tag'>");
					
					//country 출력
					console.log("제이슨 ==>",jsonObj.results[i])
					console.log("country"+country.length);
					console.log("originct=",origin_country[i]);
			
				
				
				for (let j = 0; j < country.length; j++){
						console.log("ct = ",country[j].ct);
				
					console.log("fff ==>",i,"==>",country[j].ct == origin_country)
					if(country[j].ct == origin_country) {
						cnt.push(country[j].name);
						
					}
					}
				
				
				
		console.log("cnt=",cnt)
			/*		let god = [];
			for (let i = 0; i < genress.length; i++) {
				for(let j=0; j<jsonObj.genres.length;j++){
		
				console.log("반복문11 -->",genress[i].id)
				if (genress[i].id == jsonObj.genres[j].id) {
					god.push(genress[i].name);
				}
			}}
			console.log("god ==>",god)
				//---*/
					
					$('.div_tag').append(`<div class='cards' style='height:600px;'>
										<div class='poster-img' style = "cursor:pointer;" onclick="location.href='about.jsp?id=${id}'")>
										<img src = "${imgP}">	
										</div>
										<div class="info-title" style="color:white; padding:20px; display:flex; line-height:20px;">
										<h5>${mvtitle}</h5>  <div class="badge bg-dark" style="line-height:20px; margin-left:10px;">평점 : ${glad}</div>
										</div>
										<div class="date" style="margin-left: 20px; margin-top:-10px;color:lightgray;">개봉 ${first_date} | ${cnt[i]}</div>
										</div>	
										`);

					$('.cardrow').append("<div style='position:relative; z-index : 200;class='medal-img'><img style='position:absolute; z-index:200; width: 150px; right:200px; top:-60px;' src = './img/medal2.png'></div>");
					
					if (i < 9){
					$('.cardrow').append(`<div style='position:relative;z-index:1000;'><h1 style='color:white; position:absolute; right:270px; top:-10px;  weight: 800' lass="count"><i>${i+1}</h1></i></div>`)
					} else{
						$('.cardrow').append(`<div style='position:relative; z-index:1000;'><h1 style='color:white; position:absolute; right:260px; top:-10px; weight: 800' lass="count"><i>${i+1}</i></h1></div>`)
					}
					$('.cardrow').append("</div> </div>");		

					

				}
		console.log("cnt ==>",cnt)
			}
		},
		error: function() {
			alert("통신 실패");
		}
	})


}




$('.navbar-nav').on('click', (e) => {
	console.log("상단바 누름")
		if ($(".dropdown-menu.one").css("display") == "none") { 
        $(".dropdown-menu.one").css("display", "flex");
    } else {
        $(".dropdown-menu.one").css("display", "none");
    }
    
    
	});
	

	


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



	

	