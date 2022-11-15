const searchParams = new URLSearchParams(location.search);
const value = searchParams.get('val');
console.log(value);
let num = []
let name = []
function movie(value) {
	console.log("들어옴");

	let page = 1;

	$.ajax({
		url: `https://api.themoviedb.org/3/search/tv?api_key=bedf90a784a3256d088fc405634864f4&language=ko-KR&query=${value}&page=1`,

		dataType: 'json',

		success: function(jsonObj) {

			for (let i = 0; i <= jsonObj.results.length; i++) {
				console.log("ob->", jsonObj.results[i]);
				if (jsonObj != null) {

					let imgurl = "https://tmdb.org/t/p/w300";
					let imgP = imgurl + jsonObj.results[i].poster_path;
					let mvtitle = jsonObj.results[i].name;
					let glad = jsonObj.results[i].vote_average;
					let first_date = jsonObj.results[i].first_air_date;
					let origin_country = jsonObj.results[i].origin_country[0];
					let id = jsonObj.results[i].id;

					$('.cardrow').append("<div class='col-sm-3 div_tag'>");
					$('.div_tag').append(`<div class='cards' style='height:600px;'>
					<div class='poster-img' style = "cursor:pointer;" onclick="location.href='about.jsp?id=${id}'")>
					<img src = "${imgP}">	
					</div>
					<div class="info-title" style="color:white; padding:20px; display:flex; line-height:20px;">
					<h5>${mvtitle}</h5>  <div class="badge bg-dark" style="line-height:20px; margin-left:10px;">평점 : ${glad}</div>
					</div>
					<div class="date" style="margin-left: 20px; margin-top:-10px;color:lightgray;">개봉 ${first_date} | </div>
					</div>	
					`);
				}
			}
		}
	})
}
movie(value)

/*		$.ajax({
	// 1. 어디랑 통신 할껀지 ??
		url: "https://api.themoviedb.org/3/tv/popular?api_key=4b3fd2d5d3a33372bb64b192b7490d22&language=ko-KR&page=" + page,

		dataType: 'json',//키:밸류
		// 2. 성공 메소드
		// data -> 통신 성공시 응답받은 데이터가 담길 변수
		// 통신성공시 실행되는 함수의 매개변수에 응답데이터 전부 담겨지게 된다!
		success: function(jsonObj) {

			console.log(jsonObj);

			console.log("jsondata ==>" + jsonObj);

		},
		error: function() {
			alert("통신 실패");
		}
	})*/
