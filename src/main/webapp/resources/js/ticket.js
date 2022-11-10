// movieTicketTime

// 영화관 - 첫번째 라디오 버튼 checked
$('input:radio[name=cinemaName]').eq(0).attr("checked", true);

// 영화관 선택시 영화관, 날짜 별 상영 영화 
function cinemaNameChoice(cinemaNo) {
	var radioVal = $('input[name="cinemaName"]:checked').val();
	var divTag = $('.ticket-cinema-name');
	$(divTag).children('p').remove();
	$(divTag).append('<p>' + radioVal + '</p>');
	$.ajax({
		type : "post",
		url : "/movieTicketTimeCinema.yh",
		data : {
			"cinemaNo" : cinemaNo
		},
		dataType : "json",
		success : function(result) {
			const movie = JSON.parse(result.mList);
			var listWrap = $('.movie-name-wrap').html('');
			for(var m in movie) {
				var movieBoxTag = $('<div class="movie-name-outside"></div>');
				var movieTitleTag = $('<p class="title-text" onclick="ticketMovieday()"></p>');
				movieTitleTag.text(movie[m].movieTitle);
				
				movieBoxTag.append(movieTitleTag);
				listWrap.append(movieBoxTag);
			}
		},
		error : function() {
			alert("실패!");
		}
	});
}

function ticketMovieday() {
	alert("성공!");
}