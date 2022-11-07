<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 예매</title>
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
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<!-- 영화 예매 (영화관, 영화, 상영관 선택) 페이지 시작 -->
	<div class="ticket-movie-wrapper">
		<div class="ticket-left">
			<div class="ticket-choice">
				<p class="ticket-intext">01<br><br>상영시간</p>
			</div>
			<div class="ticket-text">
				<p class="ticket-intext">02<br><br>인원,좌석</p>
			</div>
			<div class="ticket-text">
				<p class="ticket-intext">03<br><br>결제</p>
			</div>
			<div class="ticket-text-bottom">
				<p class="ticket-intext">04<br><br>예매완료</p>
			</div>
		</div>
		<div class="ticket-right">
			<div class="ticket-top">
				<div class="ticket-cinema-name">
					<p>무비유환 강남점</p>
				</div>
				<div class="ticket-movie-name">
					<p>공조2</p>
				</div>
				<div class="ticket-theater-choice">
					<p>2022-11-06</p>
				</div>
			</div>
			<div class="wrap-inside">
				<div class="cinema-name-wrap">
					<c:forEach items="${cList }" var="cinema">
						<p class="cinema-name-text">${cinema.cinemaName }</p>
					</c:forEach>
				</div>
				<div class="movie-name-wrap">
					<c:forEach items="${mList }" var="movie">
						<div class="movie-name-outside">
							<p class="movie-name-text">${movie.movieTitle }</p>
						</div>
					</c:forEach>
				</div>
				<div class="theater-choice-wrap">
				   	<div class="cinema-movie-year-month">
					   	<div class="year-month">${movieDay.thisYear }년 ${movieDay.thisMonth }월</div>
						<c:forEach items="${movieDay.tmdayList }" var="tmday" varStatus="i">
							<button type="button" class="tmday-button">${tmday }</button>
						</c:forEach>
						<hr/>
	   				</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>