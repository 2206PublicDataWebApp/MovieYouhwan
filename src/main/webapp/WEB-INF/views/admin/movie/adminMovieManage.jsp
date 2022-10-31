<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 관리(관리자)</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/movie.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="widemovie-wrapper">
		<h3>상영 영화 관리</h3><br><br>
		<div id="movietime-wrap">
			<input type="hidden" value="${cinema.cinemaNo }" name="cinemaNo">
			<input type="hidden" value="${theater.theaterNo }" name="theaterNo">
			<span class="cinema-theater">${cinema.cinemaName }</span>
			<span class="cinema-theater">${theater.theaterName }</span>
			<button id="add-movie-button">+</button>
			${oneday }
		</div>
	</div>
</body>
</html>