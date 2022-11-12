// movieTicketTime

// 영화관 - 첫번째 라디오 버튼 checked
$('input:radio[name=cinemaName]').eq(0).attr("checked", true);
$('input:radio[name=movieTitle]').eq(0).attr("checked", true);

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
				var movieNo = movie[m].movieNo;
				var movieTitle = movie[m].movieTitle;
				var movieBoxTag = $('<div class="movie-name-outside"></div>');
				var movieLabelTag = $('<label for="ticket-name'+m+'" class="title-text">' + movieTitle + '</label>')
				var movieTitleTag = $('<input type="radio" id="ticket-name'+m+'" class="title-radio-button" name="movieTitle" value="" onclick="ticketMovieday('+movieNo+', '+cinemaNo+', \''+movieTitle+'\')"/>');
				movieBoxTag.append(movieLabelTag);
				movieBoxTag.append(movieTitleTag);
				listWrap.append(movieBoxTag);
				$('#ticket-name'+m).attr('value', movieTitle);
			}
		},
		error : function() {
			alert("실패!");
		}
	});
}

function ticketMovieday(movieNo, cinemaNo, movieTitle) {
	// 상단 영화 제목 출력하기
	var divTag = $('.ticket-movie-name');
	$(divTag).children('p').remove();
	$(divTag).append('<p>' + movieTitle + '</p>');
	var testbt = $('.tmday-button').val();
	$.ajax({
		type : "post",
		url : "/movieTicketTimeMovie.yh",
		data : {
			'cinemaNo' : cinemaNo,
			'movieTitle' : movieTitle
		},
		dataType : "json",
		success : function(result) {
			alert("성공!");
			console.log(result);
		},
		error : function() {
			alert("실패!");
		}
	});
}