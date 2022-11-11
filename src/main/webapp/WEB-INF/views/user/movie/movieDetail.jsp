<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 상세페이지</title>
<link href="/resources/css/common.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
<link href="/resources/css/footer.css" rel="stylesheet" />
<link href="/resources/css/movie.css" rel="stylesheet" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/footer.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" />
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div class="movie-wrapper">
		<div class="movie-product">
			<!-- 영화 메인 이미지 영역 -->
			<div id="movie-imgwrap">
				<img src="/resources/images/movieLodeImg/${miList[0].movieImgRename }" width="220px">
			</div>
			<!-- 상영 상태 표시 -->
			<div id="movie-textwrap">
				<h3 id="detail-movietitle">${movie.movieTitle }</h3>
				<fmt:formatDate var="today" value="${now }" pattern="yyyy-MM-dd"/>
				<c:if test="${movie.movieStartday > today}">
					<button id="movie-next">상영예정</button>
				</c:if>
				<c:if test="${movie.movieStartday <= today && movie.movieEndday > today}">
					<button id="movie-start">상영중</button>
				</c:if>
				<c:if test="${movie.movieStartday < today && movie.movieEndday < today}">
					<button id="movie-end">상영종료</button>
				</c:if>
				<img src="/resources/images/movie/15.jpg" width="30px" >
			</div>
			<!-- 영화 리뷰 작성 후 영화 평균 평점 추가해주시면 됩니다 ~ (to.은혜) -->
			<!-- 영화 평점 영역 -->
			<div class="grade-see-wrapper">
				<div class="grade-wrap">
					<p>관람객 평점 : </p>
				</div>
				<!-- 누적 관객수 (추후 구현 예정)  -->
				<div>
					<p>누적 관객수 : 명</p>
				</div>
			</div>
			<hr>
			<div id="movie-information">
				<p class="detail-text">장르 : ${movie.movieGenre }</p>
				<p class="detail-text">상영시간 : ${movie.movieRuntime }</p>
			</div>
			<div id="movie-actor">
				<p class="detail-actor">감독 : ${movie.movieDirector }</p>
				<p class="detail-actor">배우 : ${movie.movieActor }</p>
			</div>
			<div id="detail-button">
				<button class="go-movieList" onclick="location.href='/movieTicketTime.yh'">예매하기</button>
				<button class="go-movieList" onclick="javascript:history.go(-1);">목록으로</button>
				<!-- 영화 찜하기 기능 추가해주시면됩니다. (to.은선언니) -->
			</div>	
		</div>
		<!-- 정보, 리뷰 구분 탭 -->
		<div class="movie-tab-wrapper">
			<button class="movie-tab-on" onclick="/movieDetail.yh?movieNo=${movieNo}">영화 정보</button>
			<button class="movie-tab-off">영화 리뷰</button>
		</div>
		<!-- 하단 영역 시작 -->
		<!-- 줄거리 영역 -->
		<div class="detail-moviecontent">
			<h4 id="content-text">간편 줄거리</h4>
			<p id="content-detail">${movie.movieContent }</p>
		</div>
		<!-- 통계(도표) 기능 추가 -->
		
		<!-- 영화 영상 영역 -->
		<div class="detail-moviecontent">
			<h4 id="video-text">영화 영상</h4>
			<c:forEach items="${mvList }" var="movieVideo" varStatus="i">
				<video class="detail-video" src="/resources/images/movieLodeVideo/${movieVideo.movieVideoRename }" controls></video>
			</c:forEach>
		</div>
		<div class="detail-movieimg">
			<h4 id="video-text">영화 사진</h4>
			<c:forEach items="${miList }" var="movieImg" varStatus="i">
				<img src="/resources/images/movieLodeImg/${movieImg.movieImgRename }" width="490px">
			</c:forEach>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>