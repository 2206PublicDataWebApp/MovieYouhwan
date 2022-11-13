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
	<div class="ticket-movie-wrapper">
		<div class="ticket-left">
			<div class="ticket-text">
				<p class="ticket-intext">01<br><br>상영시간</p>
			</div>
			<div class="ticket-choice">
				<p class="ticket-intext">02<br><br>인원,좌석</p>
			</div>
			<div class="ticket-text">
				<p class="ticket-intext">03<br><br>결제</p>
			</div>
			<div class="ticket-text-bottom">
				<p class="ticket-intext">04<br><br>예매완료</p>
			</div>
		</div>
		<div id="ticket-seat-information">
			<div id="information-wrapper">
				<div id="information-img">
					<img src="/resources/images/movieLodeImg/${movieImgRename }" width="100px" height = "150px;"/>
				</div>
				<div id="information-text">
					<p class="information-font">${cinemaName } ${theaterName }</p>
					<p class="information-font">${movieTitle }</p>
					<p class="information-font">${movieDay }</p>
					<p class="information-font">${movieStart } ~ ${movieEnd }</p>
				</div>
				<div id="count-choice">
					<div id="adult-count">
						<p class="count-font">어른</p>
						<input type="number" id="adult-input" value="0" min="0" max="5" name="adultCount"/>
					</div>
					<div id="teenager-count">
						<p class="count-font">청소년</p>
						<input type="number" id="teenager-input" value="0" min="0" max="5" name="teenagerCount"/>
					</div>
				</div>
			</div>
		</div>
		<div id="ticket-seat-area">
			<div id="showseat-wrap">
				<div class="show-seat">
					<c:forEach items="${abcd }" var="j" begin="0" end="${theater.theaterSeatoneColumn }">
						<c:forEach var="i" begin="1" end="${theater.theaterSeatoneRow }">
							<button type="button" id="${j}${i}" class="seat-box" name="seatName" value="${j}${i}">${j}${i }</button>
						</c:forEach>
						<br>
					</c:forEach>
				</div>
				<div class="show-seat">
					<c:forEach items="${abcd }" var="j" begin="0" end="${theater.theaterSeattwoColumn }">
						<c:forEach var="i" begin="${theater.theaterSeatoneRow +1}" end="${theater.theaterSeattwoRow + theater.theaterSeatoneRow +1}">
							<button type="button" id="${j}${i}" class="seat-box" name="seatName" value="${j}${i}">${j}${i }</button>
						</c:forEach>
						<br>
					</c:forEach>
				</div>
				<div class="show-seat">
					<c:forEach items="${abcd }" var="j" begin="0" end="${theater.theaterSeatthreeColumn }">
						<c:forEach var="i" begin="${theater.theaterSeatoneRow + theater.theaterSeattwoRow + 2}" end="${theater.theaterSeatoneRow + theater.theaterSeattwoRow + theater.theaterSeatthreeRow + 2}">
							<button type="button" id="${j}${i}" class="seat-box" name="seatName" value="${j}${i}">${j}${i }</button>
						</c:forEach>
						<br>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="ticket-seat-button">
			<button type="button" id="removie" class="seat-button">영화 재선택</button>
			<button type="submit" id="gopay" class="seat-button">결제</button>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>