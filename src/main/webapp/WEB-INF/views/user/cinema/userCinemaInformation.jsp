<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화관 정보</title>
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link href="/resources/css/common.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
<link href="/resources/css/footer.css" rel="stylesheet" />
<link href="/resources/css/cinema.css" rel="stylesheet" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/footer.js" defer></script>
<script src="/resources/js/cinema.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <!-- 영화관 대표 이미지 -->
    <div class="cinemaImg-wrapper">
	    <img class="cinemaImg" src="/resources/images/cinemaLodeImg/${cinema.cinemaImgRename }"/>
    </div>
    <div class="usercinema-wrapper">
	    <!-- 영화관 이름 -->
    	<div class="usercinema-bottom">
	    	<h3>${cinema.cinemaName }</h3>
    	</div>
    	<!-- 영화관 한줄 소개 -->
    	<div class="usercinema-bottom">
    		<p>${cinema.cinemaContent }</p>
    	</div>
    	<!-- 영화관 리스트로 이동 -->
    	<div class="usercinema-bottom">
    		<button id="usercinema-listbutton" onclick="location.href='/user/cinemaList.yh'">목록으로</button>
    	</div>
    	<!-- 영화관 탭 (영화관 정보, 전체 상영 영화) -->
	   	<div id="movie-menu">
	   		<button class="cinema-on" onclick="location.href='/user/cinemaInformation.yh?cinemaNo=${cinema.cinemaNo}'">영화관 정보</button>
			<button class="cinema-off" onclick="location.href='/user/cinemaMovie.yh?cinemaNo=${cinema.cinemaNo }'">전체 상영 영화</button>
	   	</div>
	   	<!-- 영화관 정보 -->
	   	<div>
	   		<!-- 위치정보  -->
	   		<input type="hidden" id="cinemaAddress" value="${cinema.cinemaAddress1 }">
	   		<input type="hidden" id="cinemaName" value="${cinema.cinemaName }">
	   		<h4 class="usercinema-bottom">위치정보</h4>
	   		<p class="usercinema-bottom">주소 : ${cinema.cinemaAddress1 }, ${cinema.cinemaAddress2 }</p>
	   		<!-- 지도 API 영역 -->
	   		<div id="map" class="usercinema-under" style="width:100%; height:500px;"></div>
	   		<!-- 전화번호 -->
	   		<h4 class="usercinema-bottom">전화번호</h4>
	   		<p class="usercinema-under">${cinema.cinemaTel }</p>
	   		<!-- 주차정보 -->
	   		<h4 class="usercinema-bottom">주차정보</h4>
	   		<p id="cinema-park" class="usercinema-under">${cinema.cinemaPark }</p>
	   		<!-- 대중교통 정보 -->
	   		<h4 class="usercinema-bottom">대중교통</h4>
	   		<p id="cinema-public" class="usercinema-under">${cinema.cinemaPublic }</p>
	   	</div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    <!-- 지도 API 스크립트 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=819945560b3247fda289e8c72db15a3c&libraries=services"></script>
</body>
</html>