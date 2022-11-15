const setupScrolling = () => {
    const conainter = [...document.querySelectorAll('.movie-container')];
    const nxtBtn = [...document.querySelectorAll('.nxt-btn')];
    const preBtn = [...document.querySelectorAll('.pre-btn')];

    conainter.forEach((item, i) => {
		console.log("스크롤 확")
        let containerDimensions = item.getBoundingClientRect();
        let containerWidth = containerDimensions.width;

        nxtBtn[i].addEventListener('click', () => {
            item.scrollLeft += containerWidth;
       
        })

        preBtn[i].addEventListener('click', () => {
            item.scrollLeft -= containerWidth;
       
        })
    })
}