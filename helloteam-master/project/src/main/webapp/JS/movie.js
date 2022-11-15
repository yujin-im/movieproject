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

	
function movie() {
	console.log("https://api.themoviedb.org/3/genre/tv/list?api_key=4b3fd2d5d3a33372bb64b192b7490d22");
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
				for (let i = 0; i < 20; i++) {
					let imgP = imgurl + jsonObj.results[i].poster_path;
					$('.div_tag').append("<img src='" + imgP + "'><div>" + jsonObj.genres[i].id + "</div>")
	
					$('.div_tag').append("<div style ='display:none'>" + jsonObj.genres[i].id + "</div>")

				}

			}
		},
		error: function() {
			alert("통신 실패");
		}
	})


}

