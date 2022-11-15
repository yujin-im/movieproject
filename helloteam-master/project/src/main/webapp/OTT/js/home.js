const main = document.querySelector('.main');
const datalist=[]
const fetchMoviesListByGenres = (id, genres) => {
	
    fetch(movie_genres_http + new URLSearchParams({
        api_key: api_key,language:value,
        with_genres: id,
        page: Math.floor(Math.random() * 3) + 1
    }))
    .then(res => res.json())
    .then(data => {
        makeCategoryElement(genres, data.results);
        
        datalist.push(data.results[0].backdrop_path);
		
		sessionStorage.setItem("mineSession", original_img_url+datalist[0] );
		console.log("data",data);
		
    })
    .catch(err =>  console.log(err));
}
const makeCategoryElement = (category, data) => {
    main.innerHTML += `
    <div class="movie-list">
        <button class="pre-btn"><img src="img/pre.png" alt=""></button>
        <h1 class="movie-category">${category}</h1>
        <div class="movie-container" id="${category}">
        </div>
        <button class="nxt-btn"><img src="img/nxt.png" alt=""></button>
    </div>
    `;
    makeCards(category, data);
}
const makeCards = (id, data) => {
    const movieContainer = document.getElementById(id);
    data.forEach((item, i) => {
        if(item.backdrop_path == null){
            item.backdrop_path = item.poster_path;
            if(item.backdrop_path == null){
                return;
            }
        }
        movieContainer.innerHTML += `
        <div class="movie" onclick="location.href = 'about.jsp?id=${item.id}'">
            <img src="${img_url}${item.backdrop_path}" alt="">
            <p class="movie-title">${item.name}</p>
        </div>
        `;
        if(i == data.length -1) {
            setTimeout(()=> {
                setupScrolling();
            },100);
        }
    })
}

// 선호장르로 추천 리스트 뽑기
let seesion_gen = null;
console.log(document.getElementById("gen").value,"벨류")
if (document.getElementById("gen").value != null) {
	session_gen = document.getElementById("gen").value
	console.log(session_gen)

	//형변환		const inter = session_gen.map((i) => Number(i))
	console.log("그냥 장르", genress)
	gen = genress.filter(x => session_gen.includes(x.id))
	console.log("gen", gen)
	gen2 = genress.filter(x => !session_gen.includes(x.id))
	console.log("gen2", gen2)
	genress = gen.concat(gen2)
	console.log("장르 : ->",genress)
}


genress.forEach(item => {
	fetchMoviesListByGenres(item.id, item.name);
})


sessionStorage.getItem("mineSession");
console.log("length",sessionStorage.getItem("mineSession"));


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


