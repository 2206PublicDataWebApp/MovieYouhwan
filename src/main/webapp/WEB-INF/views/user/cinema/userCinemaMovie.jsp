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
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
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
				<button type="button" class="tmday-button" onclick="getMovieList(${cinema.cinemaNo}, '${movieDay.dayList[i.index] }');">${tmday }</button>
			</c:forEach>
			<hr/>
	   	</div>
	   	<div id="choice-movie-listwrap">
		<!-- 영화 선택 -->
			<c:forEach items="${mList }" var="movie">
			
				<div class="chocie-movie-listwrap">
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
					<span class="choice-movielist-text">${movie.movieTitle }</span>
					${mtList }
					<c:forEach items="${mtList }" var="movieTime">
						<c:if test="${movie.movieNo eq movieTime.movieNo }">
<%-- 							<c:forEach items="${movieDay.dayList }" var="movieDate"> --%>
<%-- 							moveDate: ${movieDate }<br> --%>
<%-- 							movieDay: ${movieTime.movieDay } --%>
<%-- 							<c:if test="${movieTime.movieDay eq movieDate} "> --%>
								<div class="one-cinema-movie">
									<p>${movieTime.theaterName} ${movieTime.movieSeat }석 / ${movieTime.movieSeat }석</p>
									<p>${movieTime.movieStart } ~ ${movieTime.movieEnd }</p>
								</div>
							</c:if>
<%-- 							</c:forEach> --%>
<%-- 						</c:if> --%>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    <script>
    	function getMovieList(cinemaNo, movieDay) {
    		console.log("click");
    		$.ajax({
    			url : "/user/cinemaMovieDay.yh",
    			data : {
    				"cinemaNo" : cinemaNo,
    				"movieDay" : movieDay
    			},
    			type : "post",
    			success : function(result) {
    				alert("성공!");
    				console.log(result);
//     				$("#choice-movie-listwrap").html('');
//     				var str = '';
//     				for(var i in result) {
//     					str += '<div class="chocie-movie-listwrap">'
//     					str += '<span class="choice-movielist-text">'+result[i]+'</span>'
//     				}
//     				var movieListByDate='';
    			},
    			error : function() {
    				alert("실패!");
    			}
    		});
    	}
    </script>
</body>
</html>