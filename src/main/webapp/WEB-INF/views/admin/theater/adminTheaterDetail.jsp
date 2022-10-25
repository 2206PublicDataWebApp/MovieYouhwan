<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 상영관 상세(관리자)</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/theater.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="/resources/js/theater.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="widetheater-wrapper">
		<br><br><h3>상영관 상세</h3><br><br>
		<div id="detail-cinemawrap">
			<div id="cinema-title">지점명</div>
			<div class="input">${cinemaName }</div>
		</div>
		<div id="detail-namewrap">
			<span class="title">상영관명</span>
			<p class="input">${theater.theaterName }</p>
		</div>
		<div id="seat-title">상영관 좌석</div>
		<div class="detail-seatwrap">
			<span class="title">첫번째</span>
			<p class="input">${theater.theaterSeatoneRow } x ${theater.theaterSeatoneColumn }
		</div>
		<div class="detail-seatwrap">
			<span class="title">두번째</span>
			<p class="input">${theater.theaterSeattwoRow } x ${theater.theaterSeattwoColumn }
		</div>
		<div class="detail-seatwrap">
			<span class="title">세번째</span>
			<p class="input">${theater.theaterSeatthreeRow } x ${theater.theaterSeatthreeColumn }
		</div>
		
		<div id="showseat-wrap">
			<div class="show-seat">
				<c:forEach begin="1" end="${theater.theaterSeatoneColumn }">
					<c:forEach begin="1" end="${theater.theaterSeatoneRow }">
						<button class="seat-box"></button>
					</c:forEach>
					<br>
				</c:forEach>
			</div>
			<div class="show-seat">
				<c:forEach begin="1" end="${theater.theaterSeattwoColumn }">
					<c:forEach begin="1" end="${theater.theaterSeattwoRow }">
						<button class="seat-box"></button>
					</c:forEach>
					<br>
				</c:forEach>
			</div>
			<div class="show-seat">
				<c:forEach begin="1" end="${theater.theaterSeatthreeColumn }">
					<c:forEach begin="1" end="${theater.theaterSeatthreeRow }">
						<button class="seat-box"></button>
					</c:forEach>
					<br>
				</c:forEach>
			</div>
		</div>
		<div id="theater-detailbutton">
			<button class="detail-button" onclick="javascript:history.go(-1);">목록</button>
			<button class="tdetail-button" onclick="theaterDataRemove();">삭제</button>
			<button class="tdetail-button" onclick="location.href='/admin/adminModifyView.yh?theaterNo=${theater.theaterNo}'">수정</button>
		</div>
	</div>
</body>
</html>