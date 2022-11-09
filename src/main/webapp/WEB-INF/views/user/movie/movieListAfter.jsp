<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 상영예정작</title>
<link href="/resources/css/common.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
<link href="/resources/css/footer.css" rel="stylesheet" />
<link href="/resources/css/movie.css" rel="stylesheet" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/footer.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" />
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="midmovie-wrapper">
    	<!-- top3 영화 부분 (추후 개발 예정) -->
    	<div></div>
    	<!-- 검색 창 -->
    	<div id="movielist-searchwrap">
    		<input type="text" id="movielist-search">
    		<button id="movielist-search-button">검색</button>
    	</div>
    	<!-- 영화 분류 -->
    	<div class="movielist-tab">
			<div class="movielist-tab-off" onclick="location.href='/movieList.yh'">현재 상영 영화</div>
			<div class="movielist-tab-on" onclick="location.href='/movieListAfter.yh'">상영 예정 영화</div>
			<div class="movielist-tab-off" onclick="location.href='/movieListBefore.yh'">상영 종료 영화</div>
    	</div>
    	<!-- 영화 리스트 -->
	    <div class="movieList-out">
	    	<c:forEach items="${mlList }" var="movieList">
	   			<div class="movieList-outside" onclick="location.href='/movieDetail.yh?movieNo=${movieList.movieNo}'">
	   				<div class="movie-img-area">
	   					<img src="/resources/images/movieLodeImg/${movieList.movieImgRename }" width="240px">
	   				</div>
	   				<div class="movie-information-area">
	   					<!-- 영화 제목 표시 -->
	   					<p class="movie-information-name">${movieList.movieTitle }<p>
	   					<!-- 관람가능 연령 이미지 표시 -->
	   					<div class="movie-information-age">
							<c:if test="${movieList.movieAge eq '전체' }">
								<img src="/resources/images/movie/전체.jpg" width="25px" height="25px" />
							</c:if>
							<c:if test="${movieList.movieAge eq '만12세' }">
								<img src="/resources/images/movie/12.jpg" width="25px" height="25px" />
							</c:if>
							<c:if test="${movieList.movieAge eq '만15세' }">
								<img src="/resources/images/movie/15.jpg" width="25px" height="25px" />
							</c:if>
							<c:if test="${movieList.movieAge eq '청불' }">
								<img src="/resources/images/movie/청불.jpg" width="25px" height="25px" />
							</c:if>
						</div>
						<!-- 영화 개봉 일자 -->
						<div class="movie-information-start">
							<p class="movie-start-day">${movieList.movieStartday } 상영예정&nbsp; | <p>
						</div>
						<!-- 관람객 수 (추후 구현 예정) -->
						<div class="movie-information-see">
							<p class="movie-see-count">&nbsp;&nbsp;관람객 : 명</p>						
						</div>
						<!-- 예매하기 버튼 -->
						<div class="ticket-button-area">
							<button type="button" class="ticket-button" onclick="location.href='/movieTicketTime.yh'">예매하기</button>
						</div>
						<!-- 옆에 ♡ 아이콘으로 찜하기 만들어주시면 됩니다~ -->
						<!-- 찜하기 버튼 -->
	   				</div>
	   			</div>
	    	</c:forEach>
	   	</div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>