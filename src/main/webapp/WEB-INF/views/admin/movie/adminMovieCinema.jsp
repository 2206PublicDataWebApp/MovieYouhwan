<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화&영화관 관리</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/movie.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/movie.js" defer></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="admin-movie-wrap">
		<div id="cmbutton-area">
			<button class="cmbutton" onclick="location.href='/admin/adminMovieRegister.yh'">영화 등록</button>
			<button class="cmbutton" onclick="location.href='/admin/adminCinemaRegister.yh'">영화관 등록</button>
		</div>
		<div id="amovie-wrap">
			<div id="movie-cinema-rank">
				<div></div>
				<div></div>
			</div>
			<div id="movie-cinema-list">
				<div id="amovie-list">
					<div id="amovie-top">
						<p class="show-text">영화 리스트</p>
						<button class="show-button" onclick="location.href='/admin/adminMovieList.yh'">전체보기</button>
					</div>
				</div>
				<div id="acinema-list">
					<div id="acinema-top">
						<p class="show-text">영화관 리스트</p>
						<button class="show-button" onclick="location.href='/admin/adminCinemaList.yh'">전체보기</button>	
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>