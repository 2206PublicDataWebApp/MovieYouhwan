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
	<input type="hidden" id="hidden-movie-name" value="${movieTitle }" name="movieName" />
	<input type="hidden" id="hidden-point" value="${userPoint }" name="userPoint"/>
	<input type="hidden" id="hidden-movie-money" value="${adultPay + teenagerPay }" name="movieMoney"/>
	<div class="ticket-movie-wrapper">
		<div class="ticket-left">
			<div class="ticket-text">
				<p class="ticket-intext">01<br><br>상영시간</p>
			</div>
			<div class="ticket-text">
				<p class="ticket-intext">02<br><br>인원,좌석</p>
			</div>
			<div class="ticket-choice">
				<p class="ticket-intext">03<br><br>결제</p>
			</div>
			<div class="ticket-text-bottom">
				<p class="ticket-intext">04<br><br>예매완료</p>
			</div>
		</div>
		<div class="ticket-pay-area">
			<div class="pay-top">
				<div class="pay-information-top">예매정보
					<div class="pay-information-bottom">
						<div class="information-text">
							<img src="/resources/images/movieLodeImg/${movieImgRename }" id="pay-movie-img" width="240px" height="340px;"/>
							<div class="font-align">
								<p class="font-color">${cinemaName }</p>
								<p class="font-color">${movieTitle }</p>
								<p class="font-color">${movieDay }</p>
								<p class="font-color">${movieStart } ~ ${movieEnd }</p>
								<p class="font-color">${seatChoice }</p>
								<button type="button" id="change-seat">좌석 변경</button>
							</div>
						</div>
					</div>
				</div>
				<div class="pay-list-top">결제하기
					<div class="pay-list-bottom">
						<div class="pay-list-user">
							<p class="font-yellow">${userNick }</p>
							<p class="font-navy">님의 보유 포인트 : </p>
							<p class="font-yellow">&ensp;${userPoint } P</p>
						</div>
						<div>
							<p class="font-navy play-left">사용할 포인트</p>
							<p id="point-tip" class="font-navy">&ensp;(1000P 이상부터 사용 가능)</p>
							<input type="number" id="write-point" name="userPointUse" value=""/>
							<button type="button" class="point-button" onclick="pointUseAll()">전액사용</button>
							<button type="button" class="point-button" onclick="savePoint()">적용</button>
						</div>
						<div class="pay-choice-wrap">
							<div id="pay-trans" class="img-wrapper">
								<img src="/resources/images/ticket/카드결제.png" class="pay01" id="card-img"/>
								<input type="radio" value="card" name="payMethod" id="pay-method-card" class="pay-method"/>
								<label for="pay-method-card" class="font-navy">카드결제</label>
							</div>
							<div id="pay-trans" class="img-wrapper">
								<img src="/resources/images/ticket/계좌이체.png" class="pay02" id="trans-img"/>
								<input type="radio" value="trans" name="payMethod" id="pay-method-trans" class="pay-method"/>
								<label for="pay-method-trans" class="font-navy">계좌이체</label>
							</div>
							<div id="pay-trans" class="img-wrapper">
								<img src="/resources/images/ticket/무통장입금.png" class="pay03" id="bank-img"/>
								<input type="radio" value="bank" name="payMethod" id="pay-method-bank" class="pay-method"/>
								<label for="pay-method-bank" class="font-navy">무통장입금</label>
							</div>
							<div id="pay-trans" class="img-wrapper">
								<img src="/resources/images/ticket/카카오페이.png" class="pay04" id="kakaopay-img"/>
								<input type="radio" value="kakaopay" name="payMethod" id="pay-method-kakao" class="pay-method"/>
								<label for="pay-method-kakao" class="font-navy">카카오페이</label>
							</div>
							<button type="button" id="btn-movie-pay">결제하기</button>
						</div>
					</div>
					<div class="pay-input">
						<p id="movie-money" class="text-right">영화 금액 : ${adultPay + teenagerPay }원</p>
						<p class="text-right"> - <p>
						<p id="using-point">포인트 사용 : 0P</p>
						<p class="text-lright"> = </p>
						<p>최종 결제 금액 : </p>
						<p id="final-money">${adultPay + teenagerPay}</p>
						<p>원</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>