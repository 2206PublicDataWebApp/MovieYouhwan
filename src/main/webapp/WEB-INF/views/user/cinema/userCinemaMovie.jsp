<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 전체 상영 영화</title>
<link href="/resources/css/common.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
<link href="/resources/css/footer.css" rel="stylesheet" />
<link href="/resources/css/cinema.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/footer.js" defer></script>
<script src="/resources/js/cinema.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
</head>
<body>
	<!-- 페이지 시작 -->
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<input type="hidden" value="${cinema.cinemaNo }" name="cinemaNo">
    <div class="cinemaImg-wrapper">
	    <img class="cinemaImg" src="/resources/images/cinemaLodeImg/${cinema.cinemaImgRename }"/>
    </div>
    <div class="usercinema-wrapper">
	    <!-- 영화관 이름 옆에 즐겨찾기 추가해주시면 됩니다 ! -->
    	<div class="usercinema-bottom">
	    	<h3>${cinema.cinemaName }</h3>
    	</div>
    	<div class="usercinema-bottom">
    		<p>${cinema.cinemaContent }</p>
    	</div>
    	<div class="usercinema-bottom">
    		<button id="usercinema-listbutton" onclick="location.href='/user/cinemaList.yh'">목록으로</button>
    	</div>
		<!-- 영화관 정보, 전체 상영 영화 메뉴 탭 -->
	   	<div id="movie-menu">
	   		<button class="cinema-off" onclick="location.href='/user/cinemaInformation.yh?cinemaNo=${cinema.cinemaNo}'">영화관 정보</button>
			<button class="cinema-on" onclick="location.href='/user/cinemaMovie.yh?cinemaNo=${cinema.cinemaNo}'">전체 상영 영화</button>
	   	</div>
	   	<!-- 날짜 -->
	   	<div class="cinema-movie-year-month">
		   	<div class="year-month">${movieDay.thisYear }년 ${movieDay.thisMonth }월</div>
			<c:forEach items="${movieDay.tmdayList }" var="tmday" varStatus="i">
				<button type="button" class="tmday-button filter-not-clicked" onclick="getMovieList(${cinema.cinemaNo}, ${i.index });">${tmday }</button>
			</c:forEach>
			<hr/>
	   	</div>
		<!-- 영화 선택 -->
		<div id="choice-movie-listwrap">
			<!-- 일별 현재 상영 영화 리스트 -->
			<c:forEach items="${mList }" var="movie">
				<div class="choice-movie-wrap">
					<div id="age-movie-wrap">
						<c:if test="${movie.movieAge eq '전체' }">
							<img src="/resources/images/movie/전체.jpg" width="30px" height="30px" />
						</c:if>
						<c:if test="${movie.movieAge eq '만12세' }">
							<img src="/resources/images/movie/12.jpg" width="30px" height="30px" />
						</c:if>
						<c:if test="${movie.movieAge eq '만15세' }">
							<img src="/resources/images/movie/15.jpg" width="30px" height="30px" />
						</c:if>
						<c:if test="${movie.movieAge eq '청불' }">
							<img src="/resources/images/movie/청불.jpg" width="30px" height="30px" />
						</c:if>
						<p class="cmovie-title">${movie.movieTitle }</p>
					</div>
					<c:forEach items="${cmList }" var="cinemaMovie">
						<c:if test="${movie.movieNo eq cinemaMovie.movieNo}">
							<div class="choice-movie-list" onclick="ticketBuy()">
								<div class="cmt-top">
									<p class="cmt-name">${cinemaMovie.theaterName }</p>
									<p>${cinemaMovie.movieTicket } / ${cinemaMovie.movieSeat }</p>
								</div>
								<p>${cinemaMovie.movieStart } ~ ${cinemaMovie.movieEnd }</p>
							</div>
							</c:if>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    <script>
    	$('.tmday-button').click(function() {
    		$(this).removeClass('filter-not-clicked');
    		$(this).addClass('filter-clicked');
    		$(this).siblings().removeClass('filter-clicked');
    		$(this).siblings().addClass('filter-not-clicked');
    	})
    	function getMovieList(cinemaNo, movieNo, dayIndex) {
    		$.ajax({
    			type : "post",
    			url : "/user/cinemaMovieDay.yh",
    			data : {
    				"cinemaNo" : cinemaNo,
    				"movieNo" : movieNo,
    				"dayIndex" : dayIndex
    			},
    			dataType : "json",
    			success : function(result) {
					const movie = JSON.parse(result[0].mList);
    				const obj = JSON.parse(result[0].cmList);
	    			var listWrap = $('#choice-movie-listwrap').html('');
	    			for(var m in movie) {
	    				var movieAge = movie[m].movieAge;
	    				var movieItemTag = $('<div class="choice-movie-wrap"></div>');
	    				var movieAgeTag = $('<div id="age-movie-wrap"></div>')
	    				if(movieAge == '전체') {
	    					movieAgeTag.append('<img src="/resources/images/movie/전체.jpg" width="30px" height="30px" />');
	    				}else if(movieAge == '만12세') {
	    					movieAgeTag.append('<img src="/resources/images/movie/12.jpg" width="30px" height="30px" />');
	    				}else if(movieAge == '만15세') {
	    					movieAgeTag.append('<img src="/resources/images/movie/15.jpg" width="30px" height="30px" />');
	    				}else {
	    					movieAgeTag.append('<img src="/resources/images/movie/청불.jpg" width="30px" height="30px" />');
	    				}
	    			    movieAgeTag.append('<p class="cmovie-title">'+ movie[m].movieTitle +'</p>');
		    			for(var i in obj) {
		    				if(movie[m].movieNo == obj[i].movieNo) {
		    					var movieBoxTag = $('<div class="choice-movie-list"></div>');
		    					var movieBoxTop = $('<div class="cmt-top"></div>');
		    					movieBoxTop.append('<p class="cmt-name">'+ obj[i].theaterName +'</p>');
		    					movieBoxTop.append('<p>'+ obj[i].movieTicket + ' / ' + obj[i].movieSeat +'</p>');
		    					movieBoxTag.append(movieBoxTop);
		    					movieBoxTag.append('<p>'+ obj[i].movieStart + ' ~ '+ obj[i].movieEnd +'</p>')
		    					movieItemTag.append(movieBoxTag);
		    				}
	    				}
	    				if(movieItemTag.html() != '') {
	    					movieItemTag.prepend(movieAgeTag);
	    					listWrap.append(movieItemTag);
	    				}
	    			}
	        		$('.choice-movie-list').click(function () {
	        		    if (!$('#profile-user').length) {
	        		      alert('로그인이 필요한 서비스입니다.');
	        		      $(location).attr('href', '/member/loginView.yh');
	        		    }else {
	        		        $(location).attr('href', '/movieTicketTime.yh');
	        		    }
	        		  });
    			},
    			error : function() {
    				alert("실패!");
    			}
    		});
    	}
    </script>
</body>
</html>