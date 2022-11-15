let api_key = "4b3fd2d5d3a33372bb64b192b7490d22";
let img_url = "https://image.tmdb.org/t/p/w500";

let original_img_url = "https://image.tmdb.org/t/p/original"
// 장르
let genres_list_http = "https://api.themoviedb.org/3/genre/tv/list?";

// 한국어
let value = "ko-KR";

let movie_genres_http = "https://api.themoviedb.org/3/discover/tv?";
let movie_detail_http = "https://api.themoviedb.org/3/tv";
// 티비 인기순위
let popular = "/tv/popular";

// 장르 제이슨
let genress = [{id:10759,name:'액션 & 어드벤처'},
				{id:16,name:'애니메이션'},
				{id:35,name:'코미디'},
				{id:80,name:'범죄'},
				{id:99,name:'다큐멘터리'},
				{id:18,name:'드라마'},
				{id:10751,name:'가족'},
				{id:10762,name:'어린이'},
				{id:9648,name:'미스터리'},
				{id:10763,name:'뉴스'},
				{id:10764,name:'예능'},
				{id:10765,name:'SF & 판타지'},
				{id:10767,name:'토크쇼'},
				{id:10768,name:'전쟁 & 정치'}];
				
let country = [
	{ct : 'US', name : '미국'},
	{ct : 'CN', name : '중국'},
	{ct : 'JP', name : '일본'},
	{ct : 'GB', name : '영국'},
	{ct : 'TR', name : '튀르키예'},
	{ct : 'MX', name : '멕시코'},
	{ct : 'BR', name : '브라질'},
	{ct : 'HK', name : '홍콩'},
	{ct : 'KR', name : '한국'}
];
// TV 게스트 및 제작진
///tv/{tv_id}/aggregate_credits  

