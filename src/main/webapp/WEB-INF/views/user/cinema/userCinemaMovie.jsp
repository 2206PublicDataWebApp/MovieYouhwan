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
<link href="/resources/css/cinema.css" rel="stylesheet" />
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
	   	<div class="year-month">${movieDay.thisYear }년 ${movieDay.thisMonth }월</div>
		<c:forEach items="${movieDay.tmdayList }" var="tmday">
			<button type="button" class="tmday-button">${tmday }</button>
		</c:forEach>
		<!-- 영화 선택 -->
		${mtList }
		<c:forEach items="${mtList }" var="movieTime">
		</c:forEach>
		<hr/>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>