// movieTicketTime

// 첫번째 라디오 버튼 checked
$('input:radio[name=cinemaName]').eq(0).attr("checked", true);

function cinemaNameChoice() {
	var radioVal = $('input[name="cinemaName"]:checked').val();
	var divTag = $('.ticket-cinema-name');
	$(divTag).children('p').remove();
	$(divTag).append('<p>' + radioVal + '</p>');
}