<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 예매</title>
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
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
	<div class="ticket-movie-wrappers">
		<div class="ticket-left">
			<div class="ticket-text">
				<p class="ticket-intext">01<br><br>상영시간</p>
			</div>
			<div class="ticket-text">
				<p class="ticket-intext">02<br><br>인원,좌석</p>
			</div>
			<div class="ticket-text">
				<p class="ticket-intext">03<br><br>결제</p>
			</div>
			<div class="ticket-text-bottomon">
				<p class="ticket-intext">04<br><br>예매완료</p>
			</div>
		</div>
		<div class="ticket-right">
			<div id="pay-complete-view">
				<h3>예매 완료 되었습니다.</h3><br>
				<h3>무비유환을 이용해주셔서 감사합니다.</h3><br>
				<div>
					<button class="background-off" onclick="location.href='/home.yh'">메인페이지</button>
					<button class="background-on" onclick="location.href='/my/movieTicketHistory.yh'">예매내역</button>
				</div>	
			</div>
		</div>
	</div>
</body>
</html>