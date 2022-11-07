<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 관리(관리자)</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/movie.css" rel="stylesheet">
<!-- <script src="/resources/js/jquery-3.6.1.min.js" defer></script> -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script src="/resources/js/movie.js" defer></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="widemovie-wrapper">
		<h3>상영 영화 관리</h3><br><br>
		<div id="movietime-wrap">
			<input type="hidden" value="${cinema.cinemaNo }" name="cinemaNo">
			<input type="hidden" value="${theater.theaterNo }" name="theaterNo">
			<input type="hidden" value="${(theater.theaterSeatoneRow * theater.theaterSeatoneColumn) + (theater.theaterSeattwoRow * theater.theaterSeattwoColumn) + (theater.theaterSeatthreeRow * theater.theaterSeatthreeColumn) }" name="movieSeat">
			<span class="cinema-theater">${cinema.cinemaName }</span>
			<span class="cinema-theater">${theater.theaterName }</span>
			<button type="button" id="add-movie-button">+</button>
		</div>
		<div id="date-wrapper">
			<div class="ayear-month">${movieDay.thisYear }년 ${movieDay.thisMonth }월</div>
			<c:forEach items="${movieDay.dayList }" var="day">
			<div class="day-ones">
				<div id="${day }" class="week-list">${day }</div>
				<c:forEach items="${movieDay.timeList }" var="time">
					<div id="${day }T${time }" class="date-input ${day }"></div>
				</c:forEach>
			</div>
			</c:forEach>
		</div>
		<div id="time-wrapper">
			<c:forEach items="${movieDay.timeList }" var="time">
				<p class="time-wrap">${time }</p>
			</c:forEach>
		</div>
	</div>
	<div id="add-movie-time">
		<jsp:include page="addMovieTime.jsp" />
	</div>
	<script>
		// div 태그의 클래스명인 .date-input를 반복해서
		$('.date-input').each(function(){
			// id 속성값 가져오기 가져온 아이디 속성값 정규표현식 적용!
			$(this).attr('id', $(this).attr('id').replace(/[^0-9]/g,  ''));
		});
		<c:forEach items="${mtList}" var="movieTime">
			// 영화 시작 시간 id
			var timeStartId = '${movieTime.movieDay}'+'T'+'${movieTime.movieStart}';
			// 영화 종료 시간 id
			var timeEndId='${movieTime.movieDay}'+'T'+'${movieTime.movieEnd}';
			// 영화 시작, 종료 시간에도 정규표현식 적용해서 : 삭제하기
			timeStartId=timeStartId.replace(/[^0-9]/g,  '');
			timeEndId=timeEndId.replace(/[^0-9]/g,  '');

			var startIndex=$('#'+timeStartId).index('.${movieTime.movieDay}');
			var endIndex=$('#'+timeEndId).index('.${movieTime.movieDay}');
			var name = '${movieTime.movieName }';
			console.log("s:"+startIndex);
			console.log("e:"+endIndex);
			
			for(var i=startIndex; i<endIndex; i++){
				$('.${movieTime.movieDay}').eq(i).text(name);
			}
		</c:forEach>
	</script>
</body>
</html>