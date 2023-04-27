
$(document).ready(function() {
	$('#item').fadeIn(2000);
});

$(document).ready(function() {
	$(".clickable").click(function() {
		$(this).toggleClass("rotate");
	});
});

function reloadpage() {
    window.location.reload(false);
}