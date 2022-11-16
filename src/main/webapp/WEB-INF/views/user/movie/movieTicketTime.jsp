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
<link href="/resources/css/ticket.css" rel="stylesheet" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/footer.js" defer></script>
<script src="/resources/js/ticket.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<input type="hidden" name="movieNo" value="${movie.movieNo }"/>
	<input type="hidden" name="cinemaNo" value="${cinema.cinemaNo }"/>
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
			<!-- 상단 영화관 이름, 영화 이름, 선택 일자 노출 부분 -->
			<div class="ticket-top">
				<div class="ticket-cinema-name">
					<p>영화관</p>
				</div>
				<div class="ticket-movie-name">
					<p>영화</p>
				</div>
				<div class="ticket-theater-choice">
					<p>날짜</p>
				</div>
			</div>
			<div class="wrap-inside">
				<!-- 영화관 이름 리스트 -->
				<div class="cinema-name-wrap">
					<c:forEach items="${cList }" var="cinema" varStatus="i">
						<div id="cinema-name-outside${i.count }" class="cinema-name-outside">
							<label for="cinema-name${i.count }" class="cinema-name-text">${cinema.cinemaName }</label>
							<input type="radio" id="cinema-name${i.count }" class="cinema-name-radio" name="cinemaName" value="${cinema.cinemaName }" onclick="cinemaNameChoice(${cinema.cinemaNo})"/>
						</div>
					</c:forEach>
				</div>
				<!-- 영화 제목 리스트 -->
				<div class="movie-name-wrap">
					<c:forEach items="${mList }" var="movie" varStatus="i">
						<div class="movie-name-outside">
							<label for="ticket-name${i.count }" class="cinema-name-text">${movie.movieTitle }</label>
							<input type="radio" id="ticket-name${i.count }" class="title-radio-button" name="movieTitle" value="${movie.movieNo }" />
						</div>
					</c:forEach>
				</div>
				<!-- 영화 선택 리스트 -->
				<div class="theater-choice-wrap">
				   	<div class="cinema-movie-year-month">
					   	<div class="year-month">${movieDay.thisYear }년 ${movieDay.thisMonth }월</div>
						<c:forEach items="${movieDay.tmdayList }" var="tmday" varStatus="i">
							<input type="hidden" class="movieday-list" name="movieDay" value="${movieDay.dayList[i.count-1] }" />
							<button type="button" class="tmday-button" value="${movieDay.dayList[i.count-1] }" onclick="ticketMovieday(${movieDay.dayList[i.count-1]})">${tmday }</button>
						</c:forEach>
						<hr/>
						<div class="ticket-movie-time">
							<p class="font-black">영화관와 영화를 선택해주세요.</p>
						</div>
	   				</div>
				</div>
			</div>
		</div>
	</div>
	<div id="movie-choice-done">
		<jsp:include page="movieChoiceDone.jsp" />
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>