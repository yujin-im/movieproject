$('.navbar-nav').on('click', (e) => {
	console.log("상단바 누름")
		if ($(".dropdown-menu.one").css("display") == "none") { 
        $(".dropdown-menu.one").css("display", "flex");
    } else {
        $(".dropdown-menu.one").css("display", "none");
    }
    
    
	});
	

console.log("nav");

