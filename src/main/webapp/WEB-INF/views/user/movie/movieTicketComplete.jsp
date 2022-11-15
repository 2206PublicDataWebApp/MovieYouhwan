<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	</div>
</body>
</html>