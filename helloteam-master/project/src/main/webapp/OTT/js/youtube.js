// youtube api

movie();
// Youtube IFrame API를 비동기로 로드합니다.
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);


function movie() {
	const qu = document.getElementById("h3tag").textContent;
	console.log(qu);
	console.log("유튜브 트레일러펑션 실행");
	$.ajax({
		type: "GET",
		url: "https://www.googleapis.com/youtube/v3/search?key=AIzaSyC6E_VeHDPM83YTIjsXCc3j44WCxf-uL8Y&q="+qu+"&part=snippet&type=video",
		dataType: 'json',

		success: function(jsonObj) {
			// onYouTubePlayerAPIReady 함수 이름은,
			// Youtube IFrame Player API에서 사용하는 이름이기 때문에,
			// 다르게 지정하면 동작하지 않습니다!
			// 그리고 함수는 전역(Global) 등록해야 합니다!

			new YT.Player('player', {

				videoId: jsonObj.items[0].id.videoId, // 최초 재생할 유튜브 영상 ID
				playerVars: {
					autoplay: true, // 자동 재생 유무
					loop: true, // 반복 재생 유무
					playlist: jsonObj.items[0].id.videoId // 반복 재생할 유튜브 영상 ID 목록
				},
				events: {
					// 영상이 준비되었을 때,
					onReady: function(event) {
						event.target.mute() // 음소거!
					}
				}
			})


		}

	})

}
