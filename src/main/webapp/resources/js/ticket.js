// movieTicketTime.jsp

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
				var movieTitleTag = $('<input type="radio" id="ticket-name'+m+'" class="title-radio-button" name="movieNo" value="" onclick="ticketMovieday('+movieNo+', '+cinemaNo+', \''+movieTitle+'\')"/>');
				movieBoxTag.append(movieLabelTag);
				movieBoxTag.append(movieTitleTag);
				listWrap.append(movieBoxTag);
				$('#ticket-name'+m).attr('value', movieNo);
			}
		},
		error : function() {
			alert("관리자에게 문의해주세요. (02-655-9523)");
		}
	});
}

// 모달창
let registerModal = $('#movie-choice-done');
let registerBtn; 

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
			'movieNo' : movieNo
		},
		dataType : "json",
		success : function(result) {
			const cinema = JSON.parse(result[0].cinema);
			const movie = JSON.parse(result[0].mList);
			const movieTime = JSON.parse(result[0].cmList);
			const movieImg = JSON.parse(result[0].miList);
			var listWrap = $('.ticket-movie-time').html('');
			for(var m in movie) {
				var movieNo = movie[m].movieNo;
				var movieTitle = movie[m].movieTitle;
				var movieTitleTag = $('<p class="font-black">'+ movieTitle +'</p>');
				for(var mt in movieTime) {
					var theaterNo = movieTime[mt].theaterNo;
					var theaterName = movieTime[mt].theaterName;
					var movieTicket = movieTime[mt].movieTicket;
					var movieSeat = movieTime[mt].movieSeat;
					var movieStart = movieTime[mt].movieStart;
					var movieEnd = movieTime[mt].movieEnd;
					var movieDay = movieTime[mt].movieDay;
					console.log(movieTime);
					var movieDivTag = $('<div id="time-choice-wrapper"></div>');
					var movieSeatTag = $('<p class="movie-seat-choice">'+ theaterName +' '+ movieTicket + '/' + movieSeat +'</p>');
					var movieTimeTag = $('<p>'+ movieStart +'~'+ movieEnd+'</p>');
					movieDivTag.append(movieSeatTag);
					movieDivTag.append(movieTimeTag);
				}
				movieTitleTag.append(movieDivTag);
				listWrap.append(movieTitleTag);
			}
			var cinemaName = cinema.cinemaName;
			var movieImgRename = movieImg[0].movieImgRename;
			registerBtn = $('#time-choice-wrapper');
			// 영화 선택 시 영화 선택 확인 jsp 화면에 띄우기
			registerBtn.click(function() {
				registerModal.css('display', 'block');
				var imgArea = $('#mticket-img');
				imgArea.append("<img src='/resources/images/movieLodeImg/"+movieImgRename+"' id='choice-movie-img' width='220px' height='320px'/>");
				var informationArea = $('#mticket-information');
				informationArea.append('<p class="information-all">'+ cinemaName +'</p>');
				informationArea.append('<p id="mticket-movie-title" class="information-all">'+ movieTitle +'</p>');
				informationArea.append('<p>'+ movieDay +'</p>')
				informationArea.append('<p>'+ movieStart +'</p>');
				informationArea.append('<p>'+ movieEnd +'</p>');
				informationArea.append('<p>'+ theaterName +'</p>');
				informationArea.append('<p class="information-all">'+ movieTicket +'/'+ movieSeat +'</p>');
				informationArea.append('<p>선택하신 영화 정보를 확인하신 후 아래 좌석선택 버튼을 눌러주세요.</p>');
				informationArea.append('<button id="choice-seat-button">좌석선택</button>');
				// 값 넘겨주기
				informationArea.append('<input type="hidden" name="cinemaNo" value="" />')
				$('input[name="cinemaNo"]').attr('value', cinemaNo);
				informationArea.append('<input type="hidden" name="movieNo" value="" />')
				$('input[name="movieNo"]').attr('value', movieNo);
				informationArea.append('<input type="hidden" name="theaterNo" value="" />')
				$('input[name="theaterNo"]').attr('value', theaterNo);
				informationArea.append('<input type="hidden" name="movieImgRename" value="" />')
				$('input[name=movieImgRename]').attr('value', movieImgRename);
				informationArea.append('<input type="hidden" name="cinemaName" value="" />')
				$('input[name="cinemaName"]').attr('value', cinemaName);
				informationArea.append('<input type="hidden" name="movieTitle" value="" />')
				$('input[name="movieTitle"]').attr('value', movieTitle);
				informationArea.append('<input type="hidden" name="movieDay" value="" />')
				$('input[name="movieDay"]').attr('value', movieDay);
				informationArea.append('<input type="hidden" name="movieStart" value="" />')
				$('input[name="movieStart"]').attr('value', movieStart);
				informationArea.append('<input type="hidden" name="movieEnd" value="" />')
				$('input[name="movieEnd"]').attr('value', movieEnd);
				informationArea.append('<input type="hidden" name="theaterName" value="" />')
				$('input[name="theaterName"]').attr('value', theaterName);
				informationArea.append('<input type="hidden" name="movieTicket" value="" />')
				$('input[name="movieTicket"]').attr('value', movieTicket);
				informationArea.append('<input type="hidden" name="movieSeat" value="" />')
				$('input[name="movieSeat"]').attr('value', movieSeat);
			});
		},
		error : function() {
			alert("관리자에게 문의해주세요. (02-655-9523)");
		}
	});
	
}

var movieChoice = $('.movie-seat-choice');

// 팝업창 열기
function popUp() {
	location.href="/movieList.yh";
}




// movieTicketSeat.jsp

// 좌석 선택 효과
let chocieSeat = $('.seat-box');
chocieSeat.click(function() {
	var adultCount = $('#adult-input').val();
	var teenagerCount = $('#teenager-input').val();
	var addAllCount = parseInt(adultCount) + parseInt(teenagerCount);
	console.log(addAllCount);
	if(adultCount == 0 && teenagerCount == 0) {
		alert("인원수를 선택해주세요");
	}else {
		if(addAllCount == 1) {
			var hol = $([id$='1']);
			hol.attr('disabled', 'disabled');
		}
		$(this).css('background-color', 'yellow');
	}

});