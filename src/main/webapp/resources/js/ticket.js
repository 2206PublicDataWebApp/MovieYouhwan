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
				var movieTitle = movie[m].movieTitle;
				var movieBoxTag = $('<div class="movie-name-outside"></div>');
				var movieLabelTag = $('<label for="ticket-name'+m+'" class="title-text">' + movieTitle + '</label>')
				var movieTitleTag = $('<input type="radio" id="ticket-name'+m+'" name="movieTitle" value="" onclick="ticketMovieday()"/>');
				$('input[name=movieTitle]').attr('value', movieTitle);
				
				movieBoxTag.append(movieLabelTag);
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
	var movieTitleVal = $('input[name="movieTitle"]:checked').val();
	var divTag = $('.ticket-movie-name');
	$(divTag).children('p').remove();
	$(divTag).append('<p>' + movieTitleVal + '</p>');
}