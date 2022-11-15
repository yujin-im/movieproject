
function getParameterByName(name) {

	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");

	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),

		results = regex.exec(location.search);

	return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));

}// 주석

// 위 함수 이용해서 id값 가져오기
$(function() {

	var id = getParameterByName('id');

	let image_url = "https://api.themoviedb.org/3/tv/" + id + "/watch/providers?api_key=4b3fd2d5d3a33372bb64b192b7490d22";
	let detail_url = "https://api.themoviedb.org/3/tv/" + id + "?api_key=4b3fd2d5d3a33372bb64b192b7490d22&language=ko-KR";
	let same_url = "https://api.themoviedb.org/3/tv/" + id + "/similar?api_key=4b3fd2d5d3a33372bb64b192b7490d22&language=ko-KR&page=1";
	console.log("detail_url==>{}", detail_url);
	console.log("image_url ==>{}", image_url);
	$.ajax({
		// 1. 어디랑 통신 할껀지 ??``
		url: detail_url,
		dataType: 'json',//키:밸류123

		// 2. 성공 메소드
		// data -> 통신 성공시 응답받은 데이터가 담길 변수
		// 통신성공시 실행되는 함수의 매개변수에 응답데이터 전부 담겨지게 된다!
		success: function(jsonObj) {

			console.log("jsondata ==>{}", jsonObj);
			let imgurl = "https://tmdb.org/t/p/w300";
			let bk_img = "https://tmdb.org/t/p/original";
			// 장르 이름만 뽑아오기
			console.log("조건 ==>",genress[0].id == jsonObj.genres[0].id)
			let god = [];
			for (let i = 0; i < genress.length; i++) {
				for(let j=0; j<jsonObj.genres.length;j++){
		
				console.log("반복문11 -->",genress[i].id)
				if (genress[i].id == jsonObj.genres[j].id) {
					god.push(genress[i].name);
				}
			}}
			console.log("god ==>",god)


			$('.movie-poster').append("<img src='" + imgurl + jsonObj.poster_path + "'><div>")

			$(".bg").css({ "background": "url(" + bk_img + jsonObj.backdrop_path, "background-size": "cover" });
			$('.movie-name').append("<div>" + jsonObj.name + "</div>")
			//주석123
			$('.genres').append("<div>" + god + "</div>")
			$('.des').append("<div>" + jsonObj.overview + "</div>")

			// 상세페이지 이미지, 제목, 줄거리, 장르 api 받아오기
			//123
		},
		error: function() {
			alert("통신 실패");
		}
	})

	$.ajax({
		// 1. 어디랑 통신 할껀지 ??``
		url: image_url,
		dataType: 'json',//키:밸류

		// 2. 성공 메소드
		// data -> 통신 성공시 응답받은 데이터가 담길 변수
		// 통신성공시 실행되는 함수의 매개변수에 응답데이터 전부 담겨지게 된다!
		success: function(jsonObj) {

			console.log("jsondata ==>{}", jsonObj);
			// 상영중인 OTT 이미지 불러오기
			// 이미지 클릭시 사이트로 이동

		$('.starring').append("<div><a href='https://www."+jsonObj.results.KR.flatrate[0].provider_name+".com'><img src='https://tmdb.org/t/p/w200"+jsonObj.results.KR.flatrate[0].logo_path+"' ><div></a>")
	
	console.log("wave =>",jsonObj.results.KR.flatrate[0].provider_name);

		},
		error: function() {

		}
	})
	$.ajax({
		// 1. 어디랑 통신 할껀지 ??``
		url: same_url,
		dataType: 'json',//키:밸류

		success: function(jsonObj) {

			console.log("samevideo ==>{}" , jsonObj);
			let img = "https://tmdb.org/t/p/w200";
			
		for(let i = 0; i < 20; i++) {
			
			$('.swiper-wrapper').append(`<div onclick='location.href="about.jsp?id=${jsonObj.results[i].id}"' class='slide' style=' font-size:17px;'>
											<img src="${img+jsonObj.results[i].poster_path}">
											<div class='title' style='color:white; margin-top:15px;width:210px; text-align:center;'>
											"${jsonObj.results[i].name}"</div>
											</div>`)	
			console.log("id=" + jsonObj.results[i].id);
			
		}

		// 유사 프로그램 포스터!
		
		
			

		},
		error: function() {

		}
	})


});



let movie_id = location.pathname;
console.log(movie_id)
// fetching movie details
fetch(`${movie_detail_http}${movie_id}?` + new URLSearchParams({
	api_key: api_key, language: value
}))
	.then(res => res.json())
	.then(data => {
		console.log(data);
	})


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

