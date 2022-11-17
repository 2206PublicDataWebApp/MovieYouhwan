$('.movie-tab').addClass('tab-selected');

// movieTicketTime.jsp

// 영화관 - 첫번째 라디오 버튼 checked
// $('input:radio[name=cinemaName]').eq(0).attr("checked", true);
// $('input:radio[name=movieTitle]').eq(0).attr("checked", true);

// 영화관 선택시 영화관, 날짜 별 상영 영화 
function cinemaNameChoice(cinemaNo) {
	// 영화관 이름 가져오기
	var radioText = $('input[name="cinemaName"]:checked').siblings('label').text();
	// 상단 div에 영화관 이름 출력
	var divTag = $('.ticket-cinema-name');
	// 상단 div p태그 삭제 후 새로운 p태그 출력
	$(divTag).children('p').remove();
	$(divTag).append('<p class="cmovie-name">' + radioText + '</p>');
	// 영화관 선택시 해당 영화관에서 상영하는 영화만 출력
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
				// onclick -> 영화 선택 시 상영 시간표 출력
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
					var movieDivTag = $('<div class="time-choice-wrapper"></div>');
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
			registerBtn = $('.time-choice-wrapper');
			// 영화 선택 시 영화 선택 확인 jsp 화면에 띄우기
			registerBtn.click(function() {
				console.log("클릭!!!!!!!!!!!!!!")
				registerModal.css('display', 'block');
				var imgArea = $('#mticket-img');
				imgArea.append("<img src='/resources/images/movieLodeImg/"+movieImgRename+"' id='choice-movie-img' width='220px' height='320px'/>");
				var informationArea = $('#mticket-information');
				informationArea.append('<p class="information-all">'+ cinemaName +'</p>');
				informationArea.append('<p id="mticket-movie-title" class="information-all">'+ movieTitle +'</p>');
				informationArea.append('<p class="movie-in-bottom">'+ movieDay +'</p>')
				informationArea.append('<p class="movie-in-bottom">'+ movieStart +'</p>');
				informationArea.append('<p class="movie-in-bottom">'+ movieEnd +'</p>');
				informationArea.append('<p class="movie-in-bottom">'+ theaterName +'</p>');
				informationArea.append('<p class="information-all">'+ movieTicket +'/'+ movieSeat +'</p>');
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

// 영화 예매 날짜 선택 시 영화관, 영화, 영화 정보 출력하기
function ticketTimeDay(movieDay) {
	var cinemaNo = $('input[name="cinemaName"]:checked').val();
	var movieNo = $('input[name="movieNo"]:checked').val();
	$.ajax({
		type : "post",
		url : "/choiceTicketComplete.yh",
		data : {
			"cinemaNo" : cinemaNo,
			"movieNo" : movieNo,
			"movieDay" : movieDay
		},
		dataType : "json",
		success : function(result) {
			const movieList = JSON.parse(result.mlList);
			var listWrap = $('.ticket-movie-time').html('');
			for(var m in movieList) {
				var movieTitle = movieList[m].movieTitle;
				var theaterName = movieList[m].theaterName
				var movieTicket = movieList[m].movieTicket
				var movieSeat = movieList[m].movieSeat
				var movieStart = movieList[m].movieStart
				var movieEnd = movieList[m].movieEnd

				var divWrap = $('<div class="ticket-movie-times"></div>');
				var movieTitleText = $('<p class="font-black">'+ movieTitle +'</p>');
				var movieListWrap = $('<div class="time-choice-wrapper"></div>');
				var theaterNameText = $('<p class="font-black seat-time-margin">'+ theaterName + '  ' + movieTicket + ' / '+ movieSeat +'</p>');
				var movieTimeText = $('<p class="font-black">'+ movieStart + ' ~ ' + movieEnd +'</p>');
				movieListWrap.append(theaterNameText);
				movieListWrap.append(movieTimeText);
				divWrap.append(movieTitleText);
				divWrap.append(movieListWrap);
				listWrap.append(divWrap);
			}
		},
		error : function() {
			alert("관리자에게 문의해주세요. (02-6555-9523)");
		}
	});
}




// movieTicketSeat.jsp

// 좌석 선택 효과
// 페이지 입성 - 모든 좌석 disabled
let chocieSeat = $('.seat-box');
chocieSeat.attr('disabled', 'disabled');
var hiddenTag = $('#hidden-value');

var addAllCount = 0; // 총인원수
var seatBoxCount = $('.seat-box').length;

// 인원수가 변경될 때 작동
$('#adult-input, #teenager-input').change(function() {
	// (성인) 예매 인원 수
	var adultCount = $('#adult-input').val();
	// (청소년) 예매 인원 수
	var teenagerCount = $('#teenager-input').val();
	addAllCount = parseInt(adultCount) + parseInt(teenagerCount);
	chocieSeat.removeClass('selected-seat');
	// 함수호출
	activeSeat(addAllCount);
	// addAllCount가 0일때 (if문 사용해서 작성하기)
	if(addAllCount == 0) {
		chocieSeat.attr('disabled', 'disabled');
	}else if(addAllCount >= 2) {
		chocieSeat.removeAttr('disabled');
	}
});

// 좌석을 클릭할 때 작동
chocieSeat.click(function() {
	$(this).toggleClass('selected-seat');
	var selectCount = $('.selected-seat').length;
	if(addAllCount == selectCount) {
		chocieSeat.not("[id*=selected-seat]").attr('disabled', 'disabled');
	}
	if(addAllCount == 1) {
		if($(this).hasClass('selected-seat')) {
			chocieSeat.not("[id*=selected-seat]").attr('disabled', 'disabled');
			$(this).removeAttr('disabled');
		}else {
			activeSeat(addAllCount);
		}
	}
});


// 예매자 수에 따른 좌석 선택 제한
function activeSeat(addAllCount) {
	if(addAllCount = 1) {
		for(var i = 0; 2*i < seatBoxCount; i++) {
			$('.seat-box').eq(2*i).removeAttr('disabled');
		}
	}
}

function payMoney() {
	// (성인) 예매 인원 수
	var adultCount = $('#adult-input').val();
	// (청소년) 예매 인원 수
	var teenagerCount = $('#teenager-input').val();
	// (성인) 예매 총 금액
	var adultPay = parseInt(adultCount) * 15000;
	// (청소년) 예매 총 금액
	var teenagerPay = parseInt(teenagerCount) * 10000;
	// input 태그 추가 div 영역
	var hiddenTag = $('#hidden-value');
	// 선택 좌석 저장
	let seatListStr='';
	for(let i=0; i<$('.selected-seat').length;i++){
		seatListStr+=$('.selected-seat').eq(i).val();
		if(i!=$('.selected-seat').length-1){
			seatListStr+=', ';
		}
	}
	hiddenTag.append('<input type="hidden" value="" name="seatChoice"/>');
	$('input[name="seatChoice"]').attr('value', seatListStr);

	// 성인, 청소년 예매 총 금액 전달
	hiddenTag.append('<input type="hidden" value="" name="adultPay"/>');
	$('input[name="adultPay"]').attr('value', adultPay);
	hiddenTag.append('<input type="hidden" value="" name="teenagerPay"/>');
	$('input[name="teenagerPay"]').attr('value', teenagerPay);
	hiddenTag.append('<input type="hidden" value="" name="orderNo"/>');
	$('input[name="orderNo"]').attr('value', orderNo);
}



// movieTicketPay.jsp
function pointUseAll() {
	var userPoint = $('#hidden-point').val();
	$('input[name="userPointUse"]').attr('value', userPoint);
}

// 포인트 아래 출력
function savePoint()  {
	var userPoint = $('#hidden-point').val();
	const writePoint = document.getElementById('write-point').value;
	var usePoint = document.getElementById("using-point").value;
	if(writePoint > userPoint) {
		alert("보유하신 포인트를 확인해주세요.");
	} else {
		document.getElementById("using-point").innerText = '포인트 사용 : '+ writePoint + 'P';
		const movieMoney = document.getElementById('hidden-movie-money').value;
		var finalMoney = movieMoney - writePoint;
		document.getElementById("final-money").innerText = finalMoney;
	}
}