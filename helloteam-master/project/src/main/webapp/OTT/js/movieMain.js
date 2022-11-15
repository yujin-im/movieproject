const searchParams = new URLSearchParams(location.search);

for(const param of serachParams) {
	console.log(param);
}


for (let i = 0; i < 20; i++) {
	$('.cardrow').append(`
	
		<div class="col-sm-3 div_tag">
			<div class="card" style="background-color:black; height:600px;">
			<div class ="card-container" style=" height:400px; overflow:hidden; cursor:pointer">
				<a href="startmovie.jsp"><img style="width:300px;" src ="https://t1.daumcdn.net/movie/3adf584ca89902d68a8b88db75a3f39a912baab9"></a>
			</div>
			<div class="card-title mt-2" style="display:flex; padding:6px;"><h3>제목</h3></div>
			<div class="d-day" style="padding:0 10px;">상영날짜 22.22.22 | KR</div>
			</div>
		</div>
		
	`);
	}
	
	