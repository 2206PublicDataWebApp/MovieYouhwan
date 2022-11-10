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
				<button type="button" class="tmday-button" onclick="getMovieList(${cinema.cinemaNo}, ${i.index });">${tmday }</button>
			</c:forEach>
			<hr/>
	   	</div>
		<!-- 영화 선택 -->
		<div id="choice-movie-listwrap">
			<!-- 일별 현재 상영 영화 리스트 -->
			<c:forEach items="${mList }" var="movie">
				<div>
					<p>${movie.movieTitle }</p>
					<c:forEach items="${cmList }" var="cinemaMovie">
						<c:if test="${movie.movieNo eq cinemaMovie.movieNo}">
							<div class="choice-movie-list">
								<p>${cinemaMovie.theaterName } ${cinemaMovie.movieTicket } / ${cinemaMovie.movieSeat }</p>
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
    	function getMovieList(cinemaNo, dayIndex) {
    		$.ajax({
    			type : "post",
    			url : "/user/cinemaMovieDay.yh",
    			data : {
    				"cinemaNo" : cinemaNo,
    				"dayIndex" : dayIndex
    			},
    			dataType : "json",
    			success : function(result) {
					const movie = JSON.parse(result[0].mList);
    				const obj = JSON.parse(result[0].cmList);
	    			var listWrap = $('#choice-movie-listwrap').html('');
	    			for(var m in movie) {
	    				var movieItemTag = $('<div></div>');
	    			    var movieTitleTag = $('<div></div>');
		    			movieTitleTag.text(movie[m].movieTitle);
		    			for(var i in obj) {
		    				if(movie[m].movieNo == obj[i].movieNo) {
		    					var movieBoxTag = $('<div></div>');
		    					var movieInfoTag = $('<p></p>');
		    					var movieTimeTag = $('<p></p>');

		    					movieBoxTag.addClass('choice-movie-list');
		    					movieInfoTag.text(obj[i].theaterName + ' ' + obj[i].movieTicket + ' / ' + obj[i].movieSeat);
		    					movieTimeTag.text(obj[i].movieStart + ' ~ ' + obj[i].movieEnd);
		    					
		    					movieBoxTag.append(movieInfoTag);
		    					movieBoxTag.append(movieTimeTag);
		    					movieItemTag.append(movieBoxTag);
		    				}
	    				}
	    				if(movieItemTag.html() != '') {
	    					movieItemTag.prepend(movieTitleTag);
	    					listWrap.append(movieItemTag);
	    				}
	    			}
    			},
    			error : function() {
    				alert("실패!");
    			}
    		});
    	}
    </script>
</body>
</html>