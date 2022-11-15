let page = 1;

$(function() {
	console.log("start12");
	//실행할 내용

	movie();

	$('.btn').on('click', (e) => {
		page += 1;
		console.log(page);
		movie();
	});
});
moviePopular = 'https://api.themoviedb.org/3/tv/popular?api_key=4b3fd2d5d3a33372bb64b192b7490d22&language=ko-KR'
movies = 'https://api.themoviedb.org/3/tv/1402/videos?api_key=4b3fd2d5d3a33372bb64b192b7490d22&language=ko-KR'
gen="https://api.themoviedb.org/3/genre/tv/list?api_key=4b3fd2d5d3a33372bb64b192b7490d22&language=ko-KR";
function movie() {
	$.ajax({
		// 1. 어디랑 통신 할껀지 ??
		url: gen,
		dataType: 'json',
		// 2. 성공 메소드
		// data -> 통신 성공시 응답받은 데이터가 담길 변수
		// 통신성공시 실행되는 함수의 매개변수에 응답데이터 전부 담겨지게 된다!
		success: function(jsonObj) {
			console.log("들어옴");
			console.log(jsonObj);
			
			let imgurl = "https://tmdb.org/t/p/w300";
			console.log("US ==>{}",jsonObj.results.KR)
			console.log("flatrate ==>{}",jsonObj.results.KR.flatrate[0])
			let imgP = imgurl + jsonObj.results.KR.flatrate[1].logo_path;
			console.log("imgP ==>{}",imgP);
			$('.div_tag').append("<img src='" + imgP + "'><div></div>")
					

		},
		error: function() {
			alert("통신 실패");
		}
	})


}

